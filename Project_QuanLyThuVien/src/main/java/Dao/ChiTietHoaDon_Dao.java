/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ChiTietHoaDon_Dao {

    public boolean themCTHD(ChiTietHoaDon chiTietHoaDon) {
        Connection conn = ConnectDB.getConnection();
        String insertQuery = "INSERT INTO ChiTietHoaDon (soLuong, maHoaDon, maSanPham, giaBan) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement prestm = conn.prepareStatement(insertQuery);
            prestm.setInt(1, chiTietHoaDon.getSoLuong());
            prestm.setString(2, chiTietHoaDon.getHoaDon().getMaHoaDon());
            prestm.setString(3, chiTietHoaDon.getSanPham().getMaSanPham());
            prestm.setDouble(4, chiTietHoaDon.getGiaBan());

            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ChiTietHoaDon> getAllCTHD() {
        ArrayList<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        String selectQuery = "SELECT * FROM ChiTietHoaDon";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(selectQuery);
            while (rs.next()) {
                int soLuong = rs.getInt("soLuong");
                String maHoaDon = rs.getString("maHoaDon");
                String maSanPham = rs.getString("maSanPham");
                double giaBan = rs.getDouble("giaBan");
                HoaDon hd = new HoaDon(maHoaDon);
                SanPham sp = new SanPham(maSanPham);
                // Tạo đối tượng ChiTietHoaDon và thêm vào danh sách
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soLuong, hd, sp, giaBan);
                chiTietHoaDonList.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietHoaDonList;
    }

    public ArrayList<ChiTietHoaDon> getChiTietByMaHD(String maHoaDon) {
        ArrayList<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        String selectQuery = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";
        try {
            PreparedStatement prestm = conn.prepareStatement(selectQuery);
            prestm.setString(1, maHoaDon);

            ResultSet rs = prestm.executeQuery();
            while (rs.next()) {
                int soLuong = rs.getInt("soLuong");
                String maSanPham = rs.getString("maSanPham");
                double giaBan = rs.getDouble("giaBan");
                HoaDon hd = new HoaDon(maHoaDon);
                SanPham sp = new SanPham(maSanPham);
                // Tạo đối tượng ChiTietHoaDon và thêm vào danh sách
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soLuong, hd, sp, giaBan);
                chiTietHoaDonList.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietHoaDonList;
    }

    public double getTongTienHoaDon(String maHD) throws SQLException {
        String query = "SELECT MaHoaDon, SUM(GiaBan * SoLuong) as TongTien FROM ChiTietHoaDon WHERE MaHoaDon = ? GROUP BY MaHoaDon";
        Connection conn = ConnectDB.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, maHD);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            return rs.getDouble("TongTien");
        }
        return 0;
    }

    public ArrayList<Object[]> getTopSanPhamBanChay(int limit, Date date, Date fromDate, Date endDate) throws SQLException {
        ArrayList<Object[]> obj = new ArrayList<>();
        String query = "SELECT TOP (?) MaSanPham, SUM(GiaBan * SoLuong) as TongTien FROM ChiTietHoaDon cthd JOIN HoaDon hd ON cthd.MaHoaDon = hd.MaHoaDon"
                + " GROUP BY MaSanPham ORDER BY SUM(GiaBan * SoLuong) DESC";
        if (date != null && fromDate == null) {
            query = "SELECT TOP (?) MaSanPham, SUM(GiaBan * SoLuong) as TongTien FROM ChiTietHoaDon cthd JOIN HoaDon hd ON cthd.MaHoaDon = hd.MaHoaDon"
                    + " WHERE ngayLap = ?"
                    + " GROUP BY MaSanPham ORDER BY SUM(GiaBan * SoLuong) DESC";
        } else if (fromDate != null) {
            query = "SELECT TOP (?) MaSanPham, SUM(GiaBan * SoLuong) as TongTien FROM ChiTietHoaDon cthd JOIN HoaDon hd ON cthd.MaHoaDon = hd.MaHoaDon"
                    + " WHERE ngayLap BETWEEN ? AND ?"
                    + "GROUP BY MaSanPham ORDER BY SUM(GiaBan * SoLuong) DESC";
        }
        Connection conn = ConnectDB.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);

        preparedStatement.setInt(1, limit);
        if (date != null && fromDate == null) {
            preparedStatement.setDate(2, (java.sql.Date) date);
        } else if (fromDate != null) {
            preparedStatement.setDate(2, (java.sql.Date) fromDate);
            preparedStatement.setDate(3, (java.sql.Date) endDate);
        }
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            obj.add(new Object[]{rs.getString("MaSanPham"), rs.getDouble("TongTien")});
        }
        return obj;
    }
}
