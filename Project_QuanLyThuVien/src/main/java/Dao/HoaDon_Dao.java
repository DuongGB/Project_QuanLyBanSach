/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class HoaDon_Dao {

    public int getThuTuHoaDon() throws SQLException {
        Connection conn;
        conn = ConnectDB.getConnection();
        //Lấy số lượng bản ghi hiện có
        String countQuery = "SELECT COUNT(*) FROM HoaDon";
        PreparedStatement countStatement = conn.prepareStatement(countQuery);
        ResultSet countResult = countStatement.executeQuery();
        countResult.next();
        return countResult.getInt(1);
    }

    public boolean themHoaDon(HoaDon hoaDon) {
        Connection conn;
        conn = ConnectDB.getConnection();
        String insertQuery = "INSERT INTO HoaDon (maHoaDon, ngayLap, maKhachHang, maNhanVien, giamGia) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement prestm = conn.prepareStatement(insertQuery);
            prestm.setString(1, hoaDon.getMaHoaDon());
            prestm.setDate(2, new java.sql.Date(hoaDon.getNgayLap().getTime()));
            if (hoaDon.getKhachHang() != null) {
                prestm.setString(3, hoaDon.getKhachHang().getMaKhachHang());
            } else {
                prestm.setString(3, null);
            }
            prestm.setString(4, hoaDon.getNhanVien().getMaNhanVien());
            prestm.setDouble(5, hoaDon.getGiamGia());

            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<HoaDon> getAllHD() {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        KhachHang_Dao kh_Dao = new KhachHang_Dao();
        String selectQuery = "SELECT * FROM HoaDon hd JOIN NhanVien nv ON hd.maNhanVien = nv.maNhanVien";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(selectQuery);
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Date ngayLap = rs.getDate("ngayLap");
                String maKhachHang = rs.getString("maKhachHang");
                String maNhanVien = rs.getString("maNhanVien");
                KhachHang kh = kh_Dao.getKhachHangByMa(maKhachHang);
                String tenNV = rs.getString("TenNhanVien");
                Date ngaySinh = rs.getDate("NgaySinh");
                int gioiTinh = rs.getInt("GioiTinh");
                String soDT = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                int trangThai = rs.getInt("TrangThai");
                int chucVu = rs.getInt("ChucVu");
                double luongCoBan = rs.getDouble("LuongCoBan");
                double giamGia = rs.getDouble("GiamGia");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");
                NhanVien nv = new NhanVien(maNhanVien, tenNV, ngaySinh, gioiTinh, soDT, diaChi, trangThai, chucVu, luongCoBan, ngayVaoLam);
                // Tạo đối tượng HoaDon và thêm vào danh sách
                HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, kh, nv, giamGia);
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }

    public ArrayList<HoaDon> getAllHDByNhanVien(String maNV) {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon hd WHERE MaNhanVien = ?";
        Connection conn = ConnectDB.getConnection();
        KhachHang_Dao kh_Dao = new KhachHang_Dao();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maNV);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Date ngayLap = rs.getDate("ngayLap");
                String maKhachHang = rs.getString("maKhachHang");
                String maNhanVien = rs.getString("maNhanVien");
                double giamGia = rs.getDouble("GiamGia");
                KhachHang kh = kh_Dao.getKhachHangByMa(maKhachHang);
                NhanVien nv = new NhanVien(maNhanVien);
                HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, kh, nv, giamGia);
                hoaDonList.add(hoaDon);
            }

            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public ArrayList<HoaDon> getHoaDonByDateRange(Date fromDate, Date toDate, String maNV) {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon WHERE ngayLap BETWEEN ? AND ?";
        if (!maNV.equals("")) {
            query = "SELECT * FROM HoaDon WHERE ngayLap BETWEEN ? AND ? AND MaNhanVien = ?";
        }
        Connection conn = ConnectDB.getConnection();
        KhachHang_Dao kh_Dao = new KhachHang_Dao();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, dateFormat.format(fromDate));
            preparedStatement.setString(2, dateFormat.format(toDate));
            if (!maNV.equals("")) {
                preparedStatement.setString(3, maNV);
            }
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Date ngayLap = rs.getDate("ngayLap");
                String maKhachHang = rs.getString("maKhachHang");
                String maNhanVien = rs.getString("maNhanVien");
                KhachHang kh = kh_Dao.getKhachHangByMa(maKhachHang);
//                String tenNV = rs.getString("TenNhanVien");
//                Date ngaySinh = rs.getDate("NgaySinh");
//                int gioiTinh = rs.getInt("GioiTinh");
//                String soDT = rs.getString("SoDienThoai");
//                String diaChi = rs.getString("DiaChi");
//                int trangThai = rs.getInt("TrangThai");
//                int chucVu = rs.getInt("ChucVu");
//                double luongCoBan = rs.getDouble("LuongCoBan");
//                Date ngayVaoLam = rs.getDate("NgayVaoLam");
                NhanVien nv = new NhanVien(maNhanVien);
                double giamGia = rs.getDouble("GiamGia");
                // Tạo đối tượng HoaDon và thêm vào danh sách
                HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, kh, nv, giamGia);
                hoaDonList.add(hoaDon);
            }

            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public ArrayList<HoaDon> getHoaDonByDate(Date date, String maNV) {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon WHERE ngayLap = ?";

        if (!maNV.equals("")) {
            query = "SELECT * FROM HoaDon WHERE ngayLap = ? AND MaNhanVien = ?";
        }
        Connection conn = ConnectDB.getConnection();
        KhachHang_Dao kh_Dao = new KhachHang_Dao();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, dateFormat.format(date));
                if (!maNV.equals("")) {
                    preparedStatement.setString(2, maNV);
                }
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        String maHoaDon = rs.getString("maHoaDon");
                        Date ngayLap = rs.getDate("ngayLap");
                        String maKhachHang = rs.getString("maKhachHang");
                        String maNhanVien = rs.getString("maNhanVien");
                        KhachHang kh = kh_Dao.getKhachHangByMa(maKhachHang);
                        NhanVien nv = new NhanVien(maNhanVien);
                        // Tạo đối tượng HoaDon và thêm vào danh sách

                        double giamGia = rs.getDouble("GiamGia");
                        HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, kh, nv, giamGia);
                        hoaDonList.add(hoaDon);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public ArrayList<HoaDon> getHoaDonByMonthYear(int month, int year, String maNV) {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ? AND MONTH(ngayLap) = ?";
        if (!maNV.equals("")) {
            query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ? AND MONTH(ngayLap) = ? AND MaNhanVien = ?";
        }
        Connection conn = ConnectDB.getConnection();
        KhachHang_Dao kh_Dao = new KhachHang_Dao();
        try {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, year);
                preparedStatement.setInt(2, month);
                if (!maNV.equals("")) {
                    preparedStatement.setString(3, maNV);
                }
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        String maHoaDon = rs.getString("maHoaDon");
                        Date ngayLap = rs.getDate("ngayLap");
                        String maKhachHang = rs.getString("maKhachHang");
                        String maNhanVien = rs.getString("maNhanVien");
                        KhachHang kh = kh_Dao.getKhachHangByMa(maKhachHang);
//                        String tenNV = rs.getString("TenNhanVien");
//                        Date ngaySinh = rs.getDate("NgaySinh");
//                        int gioiTinh = rs.getInt("GioiTinh");
//                        String soDT = rs.getString("SoDienThoai");
//                        String diaChi = rs.getString("DiaChi");
//                        int trangThai = rs.getInt("TrangThai");
//                        int chucVu = rs.getInt("ChucVu");
//                        double luongCoBan = rs.getDouble("LuongCoBan");
//                        Date ngayVaoLam = rs.getDate("NgayVaoLam");
                        NhanVien nv = new NhanVien(maNhanVien);
                        // Tạo đối tượng HoaDon và thêm vào danh sách

                        double giamGia = rs.getDouble("GiamGia");
                        HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, kh, nv, giamGia);
                        hoaDonList.add(hoaDon);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public ArrayList<HoaDon> timKiemHD(String query, String maNV) {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        String querySQL = "SELECT * FROM HoaDon hd JOIN NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien WHERE LOWER(MaHoaDon) LIKE LOWER(?) AND LOWER(hd.MaNhanVien) LIKE LOWER(?) OR [dbo].[RemoveNonASCII](LOWER(TenNhanVien)) like LOWER(?) OR (LOWER(TenNhanVien)) like LOWER(?)";
        Connection conn = ConnectDB.getConnection();
        KhachHang_Dao kh_Dao = new KhachHang_Dao();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setString(2, "%" + maNV + "%");
            preparedStatement.setString(3, "%" + query + "%");
            preparedStatement.setString(4, "%" + query + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Date ngayLap = rs.getDate("ngayLap");
                String maKhachHang = rs.getString("maKhachHang");
                String maNhanVien = rs.getString("maNhanVien");
                KhachHang kh = kh_Dao.getKhachHangByMa(maKhachHang);
                NhanVien nv = new NhanVien(maNhanVien);
                double giamGia = rs.getDouble("GiamGia");
                HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, kh, nv, giamGia);
                hoaDonList.add(hoaDon);
            }

            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }
}
