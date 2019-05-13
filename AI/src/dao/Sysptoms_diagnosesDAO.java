/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.DBConnect;
import Controller.PictureFuzzySet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sysptoms_diagnoses;

/**
 *
 * @author nguyen
 */
public class Sysptoms_diagnosesDAO {

    public ArrayList<PictureFuzzySet[]> LayThongTinQuanHeTrieuChung_Benh() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM picturefuzzy.symptoms_diagnoses;";
        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<PictureFuzzySet[]> list = new ArrayList<>();
        while (rs.next()) {
            PictureFuzzySet[] pf = new PictureFuzzySet[5];
            pf[0] = new PictureFuzzySet(rs.getDouble("Fever_x"), rs.getDouble("Fever_y"), rs.getDouble("Fever_z"));;
            pf[1] = new PictureFuzzySet(rs.getDouble("Malaria_x"), rs.getDouble("Malaria_y"), rs.getDouble("Malaria_z"));
            pf[2] = new PictureFuzzySet(rs.getDouble("Typhoid_x"), rs.getDouble("Typhoid_y"), rs.getDouble("Typhoid_z"));
            pf[3] = new PictureFuzzySet(rs.getDouble("Stomach_x"), rs.getDouble("Stomach_y"), rs.getDouble("Stomach_z"));
            pf[4] = new PictureFuzzySet(rs.getDouble("Chest_problem_x"), rs.getDouble("Chest_problem_y"), rs.getDouble("Chest_problem_z"));
            list.add(pf);
        }
        return list;
    }

    public boolean UpdateDataTrieuChung_Benh(ArrayList<PictureFuzzySet> list, int id) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "UPDATE `picturefuzzy`.`symptoms_diagnoses` SET `Fever_x` = ?, `Fever_y` = ?, `Fever_z` = ?, `Malaria_x` = ?, `Malaria_y` = ?, `Malaria_z` = ?, `Typhoid_x` = ?, `Typhoid_y` = ?, `Typhoid_z` = ?, `Stomach_x` = ?, `Stomach_y` = ?, `Stomach_z` = ?, `Chest_problem_x` = ?, `Chest_problem_y` = ?, `Chest_problem_z` = ? WHERE (`idsymptoms_diagnoses` = ?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setDouble(1, list.get(0).getX());
            ps.setDouble(2, list.get(0).getY());
            ps.setDouble(3, list.get(0).getZ());
            ps.setDouble(4, list.get(1).getX());
            ps.setDouble(5, list.get(1).getY());
            ps.setDouble(6, list.get(1).getZ());
            ps.setDouble(7, list.get(2).getX());
            ps.setDouble(8, list.get(2).getY());
            ps.setDouble(9, list.get(2).getZ());
            ps.setDouble(10, list.get(3).getX());
            ps.setDouble(11, list.get(3).getY());
            ps.setDouble(12, list.get(3).getZ());
            ps.setDouble(13, list.get(4).getX());
            ps.setDouble(14, list.get(4).getY());
            ps.setDouble(15, list.get(4).getZ());
            ps.setInt(16, id);
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Sysptoms_diagnosesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
