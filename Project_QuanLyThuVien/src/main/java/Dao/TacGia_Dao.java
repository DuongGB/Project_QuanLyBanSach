/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.TacGia;
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
 * @author PC
 */
public class TacGia_Dao {
    private EntityManager em;

    public TacGia_Dao() {
        em = Persistence.createEntityManagerFactory("JPA_MSSQL").createEntityManager();
    }

    public int getThuTuTacGia() {
//        Connection conn;
//        conn = ConnectDB.getConnection();
//        //Lấy số lượng bản ghi hiện có
//        String countQuery = "SELECT COUNT(*) FROM TacGia";
//        PreparedStatement countStatement = conn.prepareStatement(countQuery);
//        ResultSet countResult = countStatement.executeQuery();
//        countResult.next();
//        return countResult.getInt(1);
        return em.createNamedQuery("TacGia.count", Integer.class).getSingleResult();
    }

    public boolean themTacGia(TacGia tg) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(tg);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTacGia(TacGia tg) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(tg);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public List<TacGia> getAllTacGia() {
        return em.createNamedQuery("TacGia.findAll", TacGia.class).getResultList();
    }

    public List<TacGia> timKiemTacGia(String queryParams) {
//        ArrayList<TacGia> danhSachTacGia = new ArrayList<>();
//        String query = "SELECT * FROM TacGia WHERE (LOWER(maTacGia)) LIKE LOWER(?) OR [dbo].[RemoveNonASCII](LOWER(tenTacGia)) LIKE LOWER(?) OR (LOWER(tenTacGia)) LIKE LOWER(?) OR soDienThoai LIKE ?";
//        Connection conn = ConnectDB.getConnection();
//
//        try {
//            PreparedStatement prestm;
//            prestm = conn.prepareStatement(query);
//            prestm.setString(1, "%" + queryParams + "%"); // Mã tác giả có chứa searchTerm
//            prestm.setString(2, "%" + queryParams + "%"); // Tên tác giả có chứa searchTerm
//            prestm.setString(3, "%" + queryParams + "%"); // Số điện thoại có chứa searchTerm
//            prestm.setString(4, "%" + queryParams + "%"); // Số điện thoại có chứa searchTerm
//            try (ResultSet rs = prestm.executeQuery()) {
//                while (rs.next()) {
//                    String maTacGia = rs.getString("maTacGia");
//                    String tenTacGia = rs.getString("tenTacGia");
//                    String soDienThoai = rs.getString("soDienThoai");
//                    int gioiTinh = rs.getInt("gioiTinh");
//                    TacGia tg = new TacGia(maTacGia, tenTacGia, soDienThoai, gioiTinh);
//                    danhSachTacGia.add(tg);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return danhSachTacGia;
        return em.createNamedQuery("TacGia.find", TacGia.class)
                .setParameter("maTG", "%" + queryParams + "%")
                .setParameter("tenTG", "%" + queryParams + "%")
                .setParameter("sdt", "%" + queryParams + "%")
                .getResultList();
    }
}
