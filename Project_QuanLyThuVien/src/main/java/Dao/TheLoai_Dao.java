/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.DanhMuc;
import Entity.TheLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class TheLoai_Dao {
    private EntityManager em;

    public TheLoai_Dao() {
        em= Persistence.createEntityManagerFactory("JPA_MSSQL").createEntityManager();
    }
    public boolean themTheLoai(String tenTheLoai, int maDanhMuc) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TheLoai theLoai = new TheLoai();
            theLoai.setTenTheLoai(tenTheLoai);
            DanhMuc danhMuc = em.find(DanhMuc.class, maDanhMuc);
            theLoai.setDanhMuc(danhMuc);
            em.persist(theLoai);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
//    public boolean themTheLoai(String tenTheLoai, int maDanhMuc) {
//        Connection conn = ConnectDB.getConnection();
//        String insertQuery = "INSERT INTO TheLoai (tenTheLoai, maDanhMuc) VALUES (?, ?)";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(insertQuery);
//            prestm.setString(1, tenTheLoai);
//            prestm.setInt(2, maDanhMuc);
//            return (prestm.executeUpdate() > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public boolean updateTheLoai(TheLoai theLoai) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(theLoai);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
//    public boolean updateTheLoai(TheLoai theLoai) {
//        Connection conn = ConnectDB.getConnection();
//        String updateQuery = "UPDATE TheLoai SET tenTheLoai = ?, maDanhMuc = ? WHERE maTheLoai = ?";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(updateQuery);
//            prestm.setString(1, theLoai.getTenTheLoai());
//            prestm.setInt(2, theLoai.getDanhMuc().getMaDanhMuc());
//            prestm.setInt(3, theLoai.getMaTheLoai());
//            return (prestm.executeUpdate() > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public ArrayList<TheLoai> timKiemTheLoai(String searchTerm) {
        ArrayList<TheLoai> dsTheLoai = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        String searchQuery = "SELECT * FROM TheLoai t JOIN DanhMucSanPham d ON t.MaDanhMuc = d.MaDanhMuc WHERE [dbo].[RemoveNonASCII](LOWER(TenTheLoai)) LIKE ? OR (LOWER(TenTheLoai)) LIKE ?";

        try {
            PreparedStatement prestm = conn.prepareStatement(searchQuery);
            prestm.setString(1, "%" + searchTerm + "%");
            prestm.setString(2, "%" + searchTerm + "%");
            ResultSet rs = prestm.executeQuery();

            while (rs.next()) {
                int maTheLoai = rs.getInt("maTheLoai");
                String tenTheLoai = rs.getString("tenTheLoai");
                DanhMuc danhMuc = new DanhMuc(rs.getInt("MaDanhMuc"), rs.getString("TenDanhMuc"));
                TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai, danhMuc);
                dsTheLoai.add(theLoai);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsTheLoai;
    }

    public ArrayList<TheLoai> getAllTheLoai() {
        Connection conn = ConnectDB.getConnection();
        ArrayList<TheLoai> dsTheLoai = new ArrayList<>();
        String selectQuery = "SELECT * FROM TheLoai t JOIN DanhMucSanPham d ON t.MaDanhMuc = d.MaDanhMuc";

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(selectQuery);

            while (result.next()) {
                int maTheLoai = result.getInt("maTheLoai");
                String tenTheLoai = result.getString("tenTheLoai");
                DanhMuc danhMuc = new DanhMuc(result.getInt("MaDanhMuc"), result.getString("TenDanhMuc"));
                TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai, danhMuc);
                dsTheLoai.add(theLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsTheLoai;
    }
}
