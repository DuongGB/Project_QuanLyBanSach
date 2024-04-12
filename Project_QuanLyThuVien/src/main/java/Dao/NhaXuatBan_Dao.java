/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.NhaXuatBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author PC
 */
public class NhaXuatBan_Dao {
    private EntityManager em;
    public NhaXuatBan_Dao() {
        em = Persistence.createEntityManagerFactory("JPA_MSSQL").createEntityManager();
    }
    public int getThuTuNXB() {
//        Connection conn;
//        conn = ConnectDB.getConnection();
//        //Lấy số lượng bản ghi hiện có
//        String countQuery = "SELECT COUNT(*) FROM NhaXuatBan";
//        PreparedStatement countStatement = conn.prepareStatement(countQuery);
//        ResultSet countResult = countStatement.executeQuery();
//        countResult.next();
//        return countResult.getInt(1);
        return em.createNamedQuery("NhaXuatBan.count", Integer.class).getSingleResult();
    }
    // Thêm nhà xuất bản vào CSDL

    public boolean themNXB(NhaXuatBan nxb) {
//        Connection conn = ConnectDB.getConnection();
//        String insertQuery = "INSERT INTO NhaXuatBan (MaNhaXuatBan, TenNhaXuatBan, DiaChiNXB, SoDienThoai) VALUES (?, ?, ?, ?)";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(insertQuery);
//            prestm.setString(1, nxb.getMaNhaXuatBan());
//            prestm.setString(2, nxb.getTenNhaXuatBan());
//            prestm.setString(3, nxb.getDiaChiNXB());
//            prestm.setString(4, nxb.getSoDienThoai());
//            return (prestm.executeUpdate() > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nxb);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

// Sửa thông tin nhà xuất bản trong CSDL
    public boolean updateNXB(NhaXuatBan nxb) {
//        Connection conn = ConnectDB.getConnection();
//        String updateQuery = "UPDATE NhaXuatBan SET TenNhaXuatBan = ?, SoDienThoai = ?, DiaChiNXB = ? WHERE MaNhaXuatBan = ?";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(updateQuery);
//            prestm.setString(1, nxb.getTenNhaXuatBan());
//            prestm.setString(2, nxb.getSoDienThoai());
//            prestm.setString(3, nxb.getDiaChiNXB());
//            prestm.setString(4, nxb.getMaNhaXuatBan());
//            return (prestm.executeUpdate() > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(nxb);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

// Tìm kiếm nhà xuất bản trong CSDL
    public List<NhaXuatBan> timKiemNXB(String searchTerm) {
//        ArrayList<NhaXuatBan> danhSachNXB = new ArrayList<>();
//        Connection conn = ConnectDB.getConnection();
//        String searchQuery = "SELECT * FROM NhaXuatBan WHERE MaNhaXuatBan LIKE ? OR [dbo].[RemoveNonASCII](LOWER(TenNhaXuatBan)) LIKE LOWER(?) OR LOWER(TenNhaXuatBan) LIKE LOWER(?)";
//
//        try {
//            PreparedStatement prestm = conn.prepareStatement(searchQuery);
//            prestm.setString(1, "%" + searchTerm + "%");
//            prestm.setString(2, "%" + searchTerm + "%");
//            prestm.setString(3, "%" + searchTerm + "%");
//            ResultSet rs = prestm.executeQuery();
//
//            while (rs.next()) {
//                String maNXB = rs.getString("MaNhaXuatBan");
//                String tenNXB = rs.getString("TenNhaXuatBan");
//                String diaChi = rs.getString("DiaChiNXB");
//                String soDienThoai = rs.getString("SoDienThoai");
//                NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB, diaChi, soDienThoai);
//                danhSachNXB.add(nxb);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return danhSachNXB;
        return  em.createNamedQuery("NhaXuatBan.find", NhaXuatBan.class)
                .setParameter("maNXB", "%" + searchTerm + "%")
                .setParameter("tenNXB", "%" + searchTerm + "%")
                .setParameter("sdt", "%" + searchTerm + "%")
                .getResultList();
    }

    public List<NhaXuatBan> getAllNXB() {
//        Connection conn = ConnectDB.getConnection();
//        ArrayList<NhaXuatBan> dsNXB = new ArrayList<>();
//        String selectQuery = "SELECT * FROM NhaXuatBan";
//
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(selectQuery);
//
//            while (rs.next()) {
//                String maNXB = rs.getString("MaNhaXuatBan");
//                String tenNXB = rs.getString("TenNhaXuatBan");
//                String diaChi = rs.getString("DiaChiNXB");
//                String soDienThoai = rs.getString("SoDienThoai");
//                NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB, diaChi, soDienThoai);
//                dsNXB.add(nxb);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return dsNXB;
        return em.createNamedQuery("NhaXuatBan.findAll", NhaXuatBan.class).getResultList();
    }

}
