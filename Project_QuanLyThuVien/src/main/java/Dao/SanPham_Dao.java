/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDB.ConnectDB;
import Entity.DanhMuc;
import Entity.NhaCungCap;
import Entity.NhaXuatBan;
import Entity.SanPham;
import Entity.TacGia;
import Entity.TheLoai;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

/**
 *
 * @author PC
 */
public class SanPham_Dao {
    private EntityManager em;
    public SanPham_Dao() {
        em= createEntityManagerFactory("JPA_MSSQL").createEntityManager();
    }
    public List<SanPham> getAllSanPham() {
//        ArrayList<SanPham> dsSanPham = new ArrayList<>();
//        Connection conn = ConnectDB.getConnection();
//        String selectQuery = "SELECT * FROM SanPham sp JOIN NhaCungCap n ON sp.MaNhaCungCap = n.MaNhaCungCap "
//                + "JOIN TheLoai tl ON sp.MaTheLoai = tl.MaTheLoai "
//                + "JOIN DanhMucSanPham d ON tl.MaDanhMuc = d.MaDanhMuc";
//
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet result = stm.executeQuery(selectQuery);
////            PreparedStatement pm = conn.prepareStatement(selectQuery);
////            ResultSet result = pm.executeQuery(selectQuery);
//            while (result.next()) {
//                String maSP = result.getString("MaSanPham");
//                String tenSP = result.getString("TenSanPham");
//                double giaBan = result.getDouble("GiaMua");
//                double VAT = result.getDouble("vat");
//                String hinhAnh = result.getString("HinhAnh");
//                NhaCungCap ncc = new NhaCungCap(result.getString("MaNhaCungCap"),
//                        result.getString("TenNhaCungCap"), result.getString("diaChiNCC"),
//                        result.getString("soDienThoai"));
//                TacGia tg = new TacGia();
//                DanhMuc danhMuc = new DanhMuc(result.getInt("MaDanhMuc"), result.getString("TenDanhMuc"));
//                TheLoai theLoai = new TheLoai(result.getInt("maTheLoai"), result.getString("tenTheLoai"), danhMuc);
//                String moTa = result.getString("MoTa");
//                NhaXuatBan nxb = new NhaXuatBan();
//                int soTrang = result.getInt("SoTrang");
//                int soLuongTon = result.getInt("soLuongTon");
//                SanPham sp = new SanPham(maSP, tenSP, giaBan, hinhAnh, ncc, tg, soTrang, theLoai, moTa, nxb, soLuongTon, VAT);
//                dsSanPham.add(sp);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return dsSanPham;
        return em.createNamedQuery("SanPham.findAll").getResultList();
    }

    public boolean themSanPham(SanPham sp) {
        Connection conn = ConnectDB.getConnection();
        String insertQuery = "INSERT INTO SanPham VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prestm = conn.prepareStatement(insertQuery);
            prestm.setString(1, sp.getMaSanPham());
            prestm.setString(2, sp.getTenSanPham());
            prestm.setDouble(3, sp.getGiaMua());
            prestm.setString(4, sp.getHinhAnh());
            prestm.setString(5, sp.getNhaCungCap().getMaNhaCungCap());
            if (sp.getTacGia() == null) {
                prestm.setString(6, "");
            } else {
                prestm.setString(6, sp.getTacGia().getMaTacGia());
            }
            prestm.setInt(7, sp.getSoTrang());
            prestm.setInt(8, sp.getTheLoai().getMaTheLoai());
            prestm.setString(9, sp.getMoTaSanPham());
            if (sp.getNhaXuatBan() == null) {
                prestm.setString(10, "");
            } else {
                prestm.setString(10, sp.getNhaXuatBan().getMaNhaXuatBan());
            }
            prestm.setInt(11, sp.getSoLuongTon());
            prestm.setDouble(12, sp.getVat());

            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSanPham(SanPham sp) {
        System.out.println(sp.getSoLuongTon());
        Connection conn = ConnectDB.getConnection();
        String updateQuery = "UPDATE SanPham "
                + "SET tenSanPham = ?, "
                + "giaMua = ?, "
                + "hinhAnh = ?, "
                + "maNhaCungCap = ?, "
                + "maTacGia = ?, "
                + "soTrang = ?, "
                + "maTheLoai = ?, "
                + "moTa = ?, "
                + "maNXB = ?, "
                + "soLuongTon = ?, "
                + "vat = ? "
                + "WHERE maSanPham = ?";

        try {
            PreparedStatement prestm = conn.prepareStatement(updateQuery);
            prestm.setString(12, sp.getMaSanPham());
            prestm.setString(1, sp.getTenSanPham());
            prestm.setDouble(2, sp.getGiaMua());
            prestm.setString(3, sp.getHinhAnh());
            prestm.setString(4, sp.getNhaCungCap().getMaNhaCungCap());
            if (sp.getTacGia() == null) {
                prestm.setString(5, "");
            } else {
                prestm.setString(5, sp.getTacGia().getMaTacGia());
            }
            prestm.setInt(6, sp.getSoTrang());
            prestm.setInt(7, sp.getTheLoai().getMaTheLoai());
            prestm.setString(8, sp.getMoTaSanPham());
            if (sp.getNhaXuatBan() == null) {
                prestm.setString(9, "");
            } else {
                prestm.setString(9, sp.getNhaXuatBan().getMaNhaXuatBan());
            }
            prestm.setInt(10, sp.getSoLuongTon());
            prestm.setDouble(11, sp.getVat());

            return (prestm.executeUpdate() > 0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public String getSanPhamByMaSP(String maSP) {
        String query = "SELECT tenSanPham FROM SanPham WHERE maSanPham = ?";
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement prestm = conn.prepareStatement(query);
            prestm.setString(1, maSP);
            ResultSet result = prestm.executeQuery();

            while (result.next()) {
                return result.getString("TenSanPham");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SanPham> timKiemSanPham(String searchTerm) {
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        String searchQuery = "SELECT * FROM SanPham sp JOIN NhaCungCap n ON sp.MaNhaCungCap = n.MaNhaCungCap "
                + "JOIN TheLoai tl ON sp.MaTheLoai = tl.MaTheLoai "
                + "JOIN DanhMucSanPham d ON tl.MaDanhMuc = "
                + "d.MaDanhMuc WHERE [dbo].[RemoveNonASCII](LOWER(tenSanPham)) LIKE LOWER(?) OR LOWER(tenSanPham) LIKE LOWER(?) OR maSanPham LIKE ?";
        try {
            PreparedStatement prestm = conn.prepareStatement(searchQuery);
            prestm.setString(1, "%" + searchTerm + "%");
            prestm.setString(2, "%" + searchTerm + "%");
            prestm.setString(3, "%" + searchTerm + "%");
            ResultSet result = prestm.executeQuery();

            while (result.next()) {
                String maSP = result.getString("MaSanPham");
                String tenSP = result.getString("TenSanPham");
                double giaBan = result.getDouble("GiaMua");
                double VAT = result.getDouble("vat");
                String hinhAnh = result.getString("HinhAnh");
                NhaCungCap ncc = new NhaCungCap(result.getString("MaNhaCungCap"),
                        result.getString("TenNhaCungCap"), result.getString("diaChiNCC"),
                        result.getString("soDienThoai"));
                TacGia tg = new TacGia();
                DanhMuc danhMuc = new DanhMuc(result.getInt("MaDanhMuc"), result.getString("TenDanhMuc"));
                TheLoai theLoai = new TheLoai(result.getInt("maTheLoai"), result.getString("tenTheLoai"), danhMuc);
                String moTa = result.getString("MoTa");
                NhaXuatBan nxb = new NhaXuatBan();
                int soTrang = result.getInt("SoTrang");
                int soLuongTon = result.getInt("soLuongTon");
                SanPham sp = new SanPham(maSP, tenSP, giaBan, hinhAnh, ncc, tg, soTrang, theLoai, moTa, nxb, soLuongTon, VAT);
                dsSanPham.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsSanPham;
    }

    public int getThuTuSP() throws SQLException {
        Connection conn;
        conn = ConnectDB.getConnection();
        //Lấy số lượng bản ghi hiện có
        String countQuery = "SELECT COUNT(*) FROM SanPham";
        PreparedStatement countStatement = conn.prepareStatement(countQuery);
        ResultSet countResult = countStatement.executeQuery();
        countResult.next();
        return countResult.getInt(1);
    }

    public ArrayList<SanPham> locSanPham(NhaCungCap nhaCungCap, TacGia tacGia, DanhMuc danhMuc, TheLoai theLoai) {
        String sql = "SELECT * FROM SanPham sp JOIN NhaCungCap n ON sp.MaNhaCungCap = n.MaNhaCungCap "
                + "JOIN TheLoai tl ON sp.MaTheLoai = tl.MaTheLoai "
                + "JOIN DanhMucSanPham d ON tl.MaDanhMuc = "
                + "d.MaDanhMuc WHERE 1 = 1";
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        if (!nhaCungCap.getMaNhaCungCap().equals("")) {
            sql += " AND sp.maNhaCungCap = ?";
        }
        if (!tacGia.getMaTacGia().equals("")) {
            sql += " AND sp.maTacGia = ?";
        }
        if (danhMuc.getMaDanhMuc() != 0) {
            sql += " AND d.maDanhMuc = ?";
        }
        if (theLoai.getMaTheLoai() != 0) {
            sql += " AND sp.maTheLoai = ?";
        }
        try {
            System.out.println(sql);
            int parameterIndex = 1;
            PreparedStatement prestm = conn.prepareStatement(sql);
            if (!nhaCungCap.getMaNhaCungCap().equals("")) {
                prestm.setString(parameterIndex++, nhaCungCap.getMaNhaCungCap());
            }
            if (!tacGia.getMaTacGia().equals("")) {
                prestm.setString(parameterIndex++, tacGia.getMaTacGia());
            }
            if (danhMuc.getMaDanhMuc() != 0) {
                prestm.setInt(parameterIndex++, danhMuc.getMaDanhMuc());
            }
            if (theLoai.getMaTheLoai() != 0) {
                prestm.setInt(parameterIndex, theLoai.getMaTheLoai());
            }
            ResultSet result = prestm.executeQuery();

            while (result.next()) {
                String maSP = result.getString("MaSanPham");
                String tenSP = result.getString("TenSanPham");
                double giaBan = result.getDouble("GiaMua");
                String hinhAnh = result.getString("HinhAnh");
                double VAT = result.getDouble("vat");
                NhaCungCap ncc = new NhaCungCap(result.getString("MaNhaCungCap"),
                        result.getString("TenNhaCungCap"), result.getString("diaChiNCC"),
                        result.getString("soDienThoai"));
                TacGia tg = new TacGia();
                DanhMuc danhMucResult = new DanhMuc(result.getInt("MaDanhMuc"), result.getString("TenDanhMuc"));
                TheLoai theLoaiResult = new TheLoai(result.getInt("maTheLoai"), result.getString("tenTheLoai"), danhMucResult);
                String moTa = result.getString("MoTa");
                NhaXuatBan nxb = new NhaXuatBan();
                int soTrang = result.getInt("SoTrang");
                int soLuongTon = result.getInt("soLuongTon");
                SanPham sp = new SanPham(maSP, tenSP, giaBan, hinhAnh, ncc, tg, soTrang, theLoaiResult, moTa, nxb, soLuongTon, VAT);
                dsSanPham.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsSanPham;
    }

    
     public SanPham getSanPhamTheoMa(String maSPham) {
        String query = "SELECT * FROM SanPham sp JOIN NhaCungCap n ON sp.MaNhaCungCap = n.MaNhaCungCap "
                + "JOIN TheLoai tl ON sp.MaTheLoai = tl.MaTheLoai "
                + "JOIN DanhMucSanPham d ON tl.MaDanhMuc = "
                + "d.MaDanhMuc WHERE MaSanPham = ?";
        Connection conn = ConnectDB.getConnection();
        SanPham sp = null;
        try {
            PreparedStatement prestm = conn.prepareStatement(query);
            prestm.setString(1, maSPham);
            ResultSet result = prestm.executeQuery();

            while (result.next()) {
                String maSP = result.getString("MaSanPham");
                String tenSP = result.getString("TenSanPham");
                double giaBan = result.getDouble("GiaMua");
                String hinhAnh = result.getString("HinhAnh");
                double VAT = result.getDouble("vat");
                NhaCungCap ncc = new NhaCungCap(result.getString("MaNhaCungCap"),
                        result.getString("TenNhaCungCap"), result.getString("diaChiNCC"),
                        result.getString("soDienThoai"));
                TacGia tg = new TacGia();
                DanhMuc danhMucResult = new DanhMuc(result.getInt("MaDanhMuc"), result.getString("TenDanhMuc"));
                TheLoai theLoaiResult = new TheLoai(result.getInt("maTheLoai"), result.getString("tenTheLoai"), danhMucResult);
                String moTa = result.getString("MoTa");
                NhaXuatBan nxb = new NhaXuatBan();
                int soTrang = result.getInt("SoTrang");
                int soLuongTon = result.getInt("soLuongTon");
                 sp = new SanPham(maSP, tenSP, giaBan, hinhAnh, ncc, tg, soTrang, theLoaiResult, moTa, nxb, soLuongTon, VAT);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
}
