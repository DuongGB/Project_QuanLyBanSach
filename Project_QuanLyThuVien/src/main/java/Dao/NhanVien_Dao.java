/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.KhachHang;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC
 */
public class NhanVien_Dao {

    public NhanVien_Dao() {
    }

    //Them Nhan Vien
    public boolean themNhanVien(NhanVien nhanVien) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement psm = null;

        int n = 0;

        try {
            psm = con.prepareStatement("insert into NhanVien (MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, SoDienThoai, DiaChi, TrangThai, ChucVu, LuongCoBan, NgayVaoLam)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psm.setString(1, nhanVien.getMaNhanVien());
            psm.setString(2, nhanVien.getTenNhanVien());
            Date date = nhanVien.getNgaySinh();
            psm.setInt(4, nhanVien.getGioiTinh());
            psm.setString(5, nhanVien.getSoDienThoai());
            psm.setString(6, nhanVien.getDiaChi());
            psm.setInt(7, nhanVien.getTrangThai());
            psm.setInt(8, nhanVien.getChucVu());
            psm.setDouble(9, nhanVien.getLuongCoBan());
            Date dateVaoLam = nhanVien.getNgayVaoLam();
            java.sql.Date ngaySinh = new java.sql.Date(date.getTime());
            psm.setDate(3, ngaySinh);
            java.sql.Date ngayVaoLam = new java.sql.Date(dateVaoLam.getTime());
            psm.setDate(10, ngayVaoLam);

            n = psm.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                psm.close();
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }

        return n > 0;
    }

    public int checkSDT(String sdt) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String q = "select count(*) from NhanVien where SoDienThoai = ?";
        int n = 0;
        try {
            stmt = con.prepareStatement(q);
            stmt.setString(1, sdt);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                // TODO: handle exception
            }
        }
        return n;
    }

    // Lấy số lượng nhan vien
    public int getSoLuongNV() {
        int soLuong = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select count(*) from NhanVien";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return soLuong;
    }

    //Lay Tat Ca Nhan Vien
    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from NhanVien";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String maNV = rs.getString("MaNhanVien");
                String tenNV = rs.getString("TenNhanVien");
                Date ngaySinh = rs.getDate("NgaySinh");
                int gioiTinh = rs.getInt("GioiTinh");
                String soDT = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                int trangThai = rs.getInt("TrangThai");
                int chucVu = rs.getInt("ChucVu");
                double luongCoBan = rs.getDouble("LuongCoBan");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");

                NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, soDT, diaChi, trangThai, chucVu, luongCoBan, ngayVaoLam);
                dsNV.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsNV;
    }

    public boolean capNhatNV(NhanVien nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;

        int n = 0;

        try {
            stmt = con.prepareStatement("update NhanVien SET TenNhanVien=?, NgaySinh=?, GioiTinh=?, SoDienThoai=?, DiaChi=?, TrangThai=?, ChucVu=?, LuongCoBan=?, NgayVaoLam=? WHERE MaNhanVien=?");
            stmt.setString(1, nv.getTenNhanVien());
            stmt.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
            stmt.setInt(3, nv.getGioiTinh());
            stmt.setString(4, nv.getSoDienThoai());
            stmt.setString(5, nv.getDiaChi());
            stmt.setInt(6, nv.getTrangThai());
            stmt.setInt(7, nv.getChucVu());
            stmt.setDouble(8, nv.getLuongCoBan());
            stmt.setDate(9, new java.sql.Date(nv.getNgayVaoLam().getTime()));
            stmt.setString(10, nv.getMaNhanVien());

            n = stmt.executeUpdate(); //sua duoc thì chuyen thanh 1
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                // TODO: handle exception
            }
        }
        return n > 0;
    }

    //Tim Kiem 
    public ArrayList<NhanVien> timNhanVien(String thongTin) {
        ArrayList<NhanVien> dsNV = new ArrayList<>();

        PreparedStatement stmt = null;

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE LOWER(MaNhanVien) like LOWER(?) OR [dbo].[RemoveNonASCII](LOWER(TenNhanVien)) like LOWER(?) OR (LOWER(TenNhanVien)) like LOWER(?) OR SoDienThoai like ? OR LOWER(DiaChi) = LOWER(?) COLLATE Vietnamese_CI_AI OR LOWER(LuongCoBan) like LOWER(?)";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + thongTin + "%");
            stmt.setString(2, "%" + thongTin + "%");
            stmt.setString(3, "%" + thongTin + "%");
            stmt.setString(4, "%" + thongTin + "%");
            stmt.setString(5, "%" + thongTin + "%");
            stmt.setString(6, "%" + thongTin + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("MaNhanVien");
                String tenNV = rs.getString("TenNhanVien");
                Date ngaySinh = rs.getDate("NgaySinh");
                int gioiTinh = rs.getInt("GioiTinh");
                String soDT = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                int trangThai = rs.getInt("TrangThai");
                int chucVu = rs.getInt("ChucVu");
                double luongCoBan = rs.getDouble("LuongCoBan");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");

                NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, soDT, diaChi, trangThai, chucVu, luongCoBan, ngayVaoLam);
                dsNV.add(nhanVien);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return dsNV;

    }

    //Loc
    public ArrayList<NhanVien> LayDanhSachNhanVienTheoTieuChi(int cv, int gt, int tt) {

        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM Nhanvien WHERE 1 = 1";

            if (cv >= 0 && cv != 2) {
                sql += " AND ChucVu = ?";
            }
            if (gt >= 0 && gt != 3) {
                sql += " AND GioiTinh = ?";
            }
            if (tt >= 0 && tt != 2) {
                sql += " AND TrangThai = ?";
            }

            stmt = con.prepareStatement(sql);

            int parameterIndex = 1;

            if (cv >= 0 && cv != 2) {
                stmt.setInt(parameterIndex, cv);
                parameterIndex++;
            }
            if (gt >= 0 && gt != 3) {
                stmt.setInt(parameterIndex, gt);
                parameterIndex++;
            }
            if (tt >= 0 && tt != 2) {
                stmt.setInt(parameterIndex, tt);
                parameterIndex++;
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maNV = rs.getString("MaNhanVien");
                String tenNV = rs.getString("TenNhanVien");
                Date ngaySinh = rs.getDate("NgaySinh");
                int gioiTinh = rs.getInt("GioiTinh");
                String soDT = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                int trangThai = rs.getInt("TrangThai");
                int chucVu = rs.getInt("ChucVu");
                double luongCoBan = rs.getDouble("LuongCoBan");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");

                NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, soDT, diaChi, trangThai, chucVu, luongCoBan, ngayVaoLam);
                dsNV.add(nhanVien);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }

        return dsNV;
    }

    //tim nhan vien theo ma
    public NhanVien timNhanVienByMa(String maNV) {

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        NhanVien nhanVien = null;

        try {
            String sql = "SELECT * FROM NhanVien WHERE MaNhanVien=?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, maNV);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaNhanVien");
                String tenNV = rs.getString("TenNhanVien");
                Date ngaySinh = rs.getDate("NgaySinh");
                int gioiTinh = rs.getInt("GioiTinh");
                String soDT = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                int trangThai = rs.getInt("TrangThai");
                int chucVu = rs.getInt("ChucVu");
                double luongCoBan = rs.getDouble("LuongCoBan");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");

                nhanVien = new NhanVien(ma, tenNV, ngaySinh, gioiTinh, soDT, diaChi, trangThai, chucVu, luongCoBan, ngayVaoLam);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return nhanVien;

    }
}
