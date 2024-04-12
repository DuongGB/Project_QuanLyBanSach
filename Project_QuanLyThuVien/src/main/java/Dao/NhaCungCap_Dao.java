/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.NhaCungCap;
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
public class NhaCungCap_Dao {

    public int getThuTuNCC() throws SQLException {
        Connection conn;
        conn = ConnectDB.getConnection();
        //Lấy số lượng bản ghi hiện có
        String countQuery = "SELECT COUNT(*) FROM NhaCungCap";
        PreparedStatement countStatement = conn.prepareStatement(countQuery);
        ResultSet countResult = countStatement.executeQuery();
        countResult.next();
        return countResult.getInt(1);
    }
    // Thêm nhà cung cấp vào CSDL

    public boolean themNCC(NhaCungCap ncc) {
        Connection conn = ConnectDB.getConnection();
        String insertQuery = "INSERT INTO NhaCungCap (MaNhaCungCap, TenNhaCungCap, DiaChiNCC, SoDienThoai) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement prestm = conn.prepareStatement(insertQuery);
            prestm.setString(1, ncc.getMaNhaCungCap());
            prestm.setString(2, ncc.getTenNhaCungCap());
            prestm.setString(3, ncc.getDiaChi());
            prestm.setString(4, ncc.getSoDienThoai());
            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

// Sửa thông tin nhà xuất bản trong CSDL
    public boolean updateNCC(NhaCungCap ncc) {
        Connection conn = ConnectDB.getConnection();
        String updateQuery = "UPDATE NhaCungCap SET tenNhaCungCap = ?, diaChiNCC = ?, soDienThoai = ? WHERE maNhaCungCap = ?";

        try {
            PreparedStatement prestm = conn.prepareStatement(updateQuery);
            prestm.setString(1, ncc.getTenNhaCungCap());
            prestm.setString(2, ncc.getDiaChi());
            prestm.setString(3, ncc.getSoDienThoai());
            prestm.setString(4, ncc.getMaNhaCungCap());
            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

// Tìm kiếm nhà xuất bản trong CSDL
    public ArrayList<NhaCungCap> timKiemNCC(String searchTerm) {
        ArrayList<NhaCungCap> danhSachNCC = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        String searchQuery = "SELECT * FROM NhaCungCap WHERE maNhaCungCap LIKE ? OR [dbo].[RemoveNonASCII](LOWER(tenNhaCungCap)) "
                + "LIKE LOWER(?) OR LOWER(tenNhaCungCap) LIKE LOWER(?) OR soDienThoai LIKE ?";

        try {
            PreparedStatement prestm = conn.prepareStatement(searchQuery);
            prestm.setString(1, "%" + searchTerm + "%");
            prestm.setString(2, "%" + searchTerm + "%");
            prestm.setString(3, "%" + searchTerm + "%");
            prestm.setString(4, "%" + searchTerm + "%");
            ResultSet rs = prestm.executeQuery();

            while (rs.next()) {
                String maNXB = rs.getString("maNhaCungCap");
                String tenNXB = rs.getString("tenNhaCungCap");
                String diaChi = rs.getString("diaChiNCC");
                String soDienThoai = rs.getString("soDienThoai");
                NhaCungCap ncc = new NhaCungCap(maNXB, tenNXB, diaChi, soDienThoai);
                danhSachNCC.add(ncc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachNCC;
    }

    public ArrayList<NhaCungCap> getAllNCC() {
        Connection conn = ConnectDB.getConnection();
        ArrayList<NhaCungCap> danhSachNCC = new ArrayList<>();
        String selectQuery = "SELECT * FROM NhaCungCap";

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(selectQuery);

            while (result.next()) {

                String maNXB = result.getString("maNhaCungCap");
                String tenNXB = result.getString("tenNhaCungCap");
                String diaChi = result.getString("diaChiNCC");
                String soDienThoai = result.getString("soDienThoai");
                NhaCungCap ncc = new NhaCungCap(maNXB, tenNXB, diaChi, soDienThoai);
                danhSachNCC.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachNCC;
    }
}
