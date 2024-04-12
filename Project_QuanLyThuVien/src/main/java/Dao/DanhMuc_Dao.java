/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.DanhMuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DanhMuc_Dao {
    private EntityManager em;

    public DanhMuc_Dao() {
        em= Persistence.createEntityManagerFactory("JPA_MSSQL").createEntityManager();
    }

    public boolean themDanhMuc(String tenDanhMuc){
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setTenDanhMuc(tenDanhMuc);
            em.persist(danhMuc);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
//    public boolean themDanhMuc(String tenDanhMuc) {
//        Connection conn = ConnectDB.getConnection();
//        String insertQuery = "INSERT INTO DanhMucSanPham (TenDanhMuc) VALUES (?)";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(insertQuery);
//            prestm.setString(1, tenDanhMuc);
//            return (prestm.executeUpdate() > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public boolean updateDanhMuc(DanhMuc danhMuc) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(danhMuc);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
//    public boolean updateDanhMuc(DanhMuc danhMuc) {
//        Connection conn = ConnectDB.getConnection();
//        String updateQuery = "UPDATE DanhMucSanPham SET tenDanhMuc = ? WHERE maDanhMuc = ?";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(updateQuery);
//            prestm.setString(1, danhMuc.getTenDanhMuc());
//            prestm.setInt(2, danhMuc.getMaDanhMuc());
//            return (prestm.executeUpdate() > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    public List<DanhMuc> timKiemDanhMuc(String searchTerm){
        return em.createNamedQuery("DanhMuc.findByTenDanhMuc", DanhMuc.class).setParameter("tenDanhMuc", "%"+searchTerm+"%").getResultList();
    }
//    public ArrayList<DanhMuc> timKiemDanhMuc(String searchTerm) {
//        ArrayList<DanhMuc> dsDanhMuc = new ArrayList<>();
//        Connection conn = ConnectDB.getConnection();
//        String searchQuery = "SELECT * FROM DanhMucSanPham WHERE [dbo].[RemoveNonASCII](LOWER(tenDanhMuc)) LIKE ? OR (LOWER(tenDanhMuc)) LIKE ?";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(searchQuery);
//            prestm.setString(1, "%" + searchTerm + "%");
//            prestm.setString(2, "%" + searchTerm + "%");
//            ResultSet rs = prestm.executeQuery();
//
//            while (rs.next()) {
//                int maDanhMuc = rs.getInt("maDanhMuc");
//                String tenDanhMuc = rs.getString("tenDanhMuc");
//                DanhMuc danhMuc = new DanhMuc(maDanhMuc, tenDanhMuc);
//                dsDanhMuc.add(danhMuc);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return dsDanhMuc;
//    }

    public List<DanhMuc> getAllDanhMuc() {
        return em.createNamedQuery("DanhMuc.findAll", DanhMuc.class).getResultList();
    }
//    public ArrayList<DanhMuc> getAllDanhMuc() {
//        Connection conn = ConnectDB.getConnection();
//        ArrayList<DanhMuc> dsDanhMuc = new ArrayList<>();
//        String selectQuery = "SELECT * FROM DanhMucSanPham";
//
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet result = stm.executeQuery(selectQuery);
//
//            while (result.next()) {
//
//                int maDanhMuc = result.getInt("maDanhMuc");
//                String tenDanhMuc = result.getString("tenDanhMuc");
//                DanhMuc danhMuc = new DanhMuc(maDanhMuc, tenDanhMuc);
//                dsDanhMuc.add(danhMuc);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return dsDanhMuc;
//    }
    public void close() {
        em.close();
    }
}
