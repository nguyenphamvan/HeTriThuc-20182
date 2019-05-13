/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Patient;

/**
 *
 * @author nguyen
 */
public class PatientDAO {

    public boolean themBenhNhan(Patient p) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO `picturefuzzy`.`patient`(idpatient, name, birth, gender, bhyt, image) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getBirth());
            ps.setString(4, p.getGender());
            ps.setString(5, p.getBhyt());
            ps.setString(6, p.getImage());
            ps.executeUpdate();

            ResultSet lastId = ps.getGeneratedKeys();
            if (lastId.next()) {
                p.setId(lastId.getInt(1));
            }
            return true;

        } catch (Exception e) {
//            System.out.println("Có lỗi xảy ra");
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean xoaBenhNhan(String id) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "DELETE FROM `picturefuzzy`.`patient` WHERE idpatient = ?";

        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1, id);
            return (ps.executeUpdate() == 1);

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra");
        }
        return false;
    }
    
    

    public Patient timBenhNhan(int IdBN) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM picturefuzzy.patient where idpatient = '" + IdBN + "'";
        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Patient pt = new Patient();
        while (rs.next()) {
            pt.setId(rs.getInt("idpatient"));
            pt.setName(rs.getString("name"));
            pt.setBirth(rs.getString("birth"));
            pt.setGender(rs.getString("gender"));
            pt.setBhyt(rs.getString("bhyt"));
            pt.setImage(rs.getString("image"));
        }
        return pt;
    }
    
    public boolean updateAvatar(int IdBN , String updateImage) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "UPDATE `picturefuzzy`.`patient` SET `image` = '"+updateImage+"' WHERE (`idpatient` = '"+IdBN+"');";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
            return (ps.executeUpdate() == 1);
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra");
        }
        return false;
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println(new PatientDAO().themBenhNhan(new Patient(0, "Iron Man", "11/04/1998", "Nam", "01245", null)));
    }

}
