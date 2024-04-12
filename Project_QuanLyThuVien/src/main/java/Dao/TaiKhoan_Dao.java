/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.TaiKhoan;
import ConnectDB.ConnectDB;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TaiKhoan_Dao {

    public TaiKhoan_Dao() {
    }

    public TaiKhoan getTaiKhoanByTen(String tenDn) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        TaiKhoan tk = null;

        try {
            String sql = "SELECT * FROM TaiKhoan WHERE TenTaiKhoan = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tenDn);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tenDN = rs.getString("TenTaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String maNV = rs.getString("MaNhanVien");
                String role = rs.getString("Role");

                tk = new TaiKhoan(tenDN, matKhau, new NhanVien(maNV), role);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
        return tk;
    }

    public boolean themTaiKhoan(NhanVien nv) {
        Connection conn = ConnectDB.getConnection();
        String insertQuery = "INSERT INTO TaiKhoan (TenTaiKhoan, MatKhau, MaNhanVien, Role) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement prestm = conn.prepareStatement(insertQuery);
            prestm.setString(1, nv.getSoDienThoai());
            prestm.setString(2, "11111111");
            prestm.setString(3, nv.getMaNhanVien());
            if (nv.getChucVu() == 0) {
                prestm.setString(4, "BH");
            } else {
                prestm.setString(4, "QL");
            }

            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMatKhau(String tenTaiKhoan, String matKhau) {
        Connection conn = ConnectDB.getConnection();
        String insertQuery = "UPDATE TaiKhoan SET MatKhau = ? WHERE TenTaiKhoan = ?";
        try {
            PreparedStatement prestm = conn.prepareStatement(insertQuery);
            prestm.setString(1, matKhau);
            prestm.setString(2, tenTaiKhoan);

            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
