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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Patients_diagnoses_value;

/**
 *
 * @author nguyen
 */
public class Patients_diagnoses_valueDAO {

    public boolean themDuLieuBenhNhan(Patients_diagnoses_value padia) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO `picturefuzzy`.`patients_diagnoses_value` ( `fever`, `malaria`, `typhoid`, `stomach`, `chestProblem`, `date`, `idpatient`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setDouble(1, padia.getFever());
            ps.setDouble(2, padia.getMalaria());
            ps.setDouble(3, padia.getTyphoid());
            ps.setDouble(4, padia.getStomach());
            ps.setDouble(5, padia.getChestProblem());
            ps.setString(6, padia.getDate());
            ps.setInt(7, padia.getIdPatient());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(Patients_diagnoses_valueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return false;
    }

    public ArrayList<Patients_diagnoses_value> timDuLieuKhamBenh(int idPatient) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM picturefuzzy.patients_diagnoses_value where idpatient = '" + idPatient + "'";
        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Patients_diagnoses_value> list = new ArrayList<>();
        while (rs.next()) {
            Patients_diagnoses_value pt = new Patients_diagnoses_value();
            pt.setId(rs.getInt("id"));
            pt.setFever(rs.getDouble("fever"));
            pt.setMalaria(rs.getDouble("malaria"));
            pt.setTyphoid(rs.getDouble("typhoid"));
            pt.setStomach(rs.getDouble("stomach"));
            pt.setChestProblem(rs.getDouble("chestProblem"));
            pt.setDate(rs.getString("date"));
            pt.setIdPatient(rs.getInt("idpatient"));
            list.add(pt);
        }
        return list;
    }

    public Patients_diagnoses_value timDuLieuKhamBenhMoiNhat(int idPatient) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM picturefuzzy.patients_diagnoses_value \n"
                + "WHERE idpatient = '" + idPatient + "'\n"
                + "ORDER BY id DESC\n"
                + "LIMIT 1;";
        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Patients_diagnoses_value pt = new Patients_diagnoses_value();
        while (rs.next()) {
            pt.setId(rs.getInt("id"));
            pt.setFever(rs.getDouble("fever"));
            pt.setMalaria(rs.getDouble("malaria"));
            pt.setTyphoid(rs.getDouble("typhoid"));
            pt.setStomach(rs.getDouble("stomach"));
            pt.setChestProblem(rs.getDouble("chestProblem"));
            pt.setDate(rs.getString("date"));
            pt.setIdPatient(rs.getInt("idpatient"));
        }
        return pt;
    }

    public static void main(String[] args) throws SQLException {
//        System.out.println(new Patients_diagnoses_valueDAO().timDuLieuKhamBenhMoiNhat("bn001").getDate());
//        ArrayList<Patients_diagnoses_value> list = new Patients_diagnoses_valueDAO().timDuLieuKhamBenh("bn001");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getId() + "\n");
//        }
        Patients_diagnoses_value pdv = new Patients_diagnoses_value();
        
    }
}

