/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;

import Dao.SanPham_Dao;
import Entity.DanhMuc;
import Entity.NhaCungCap;
import Entity.SanPham;
import Entity.TacGia;
import Entity.TheLoai;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class SanPham_Bus {
    private final SanPham_Dao sp_Dao;
    public SanPham_Bus() {
        sp_Dao = new SanPham_Dao();
    }
    
    public int getThuTuSanPham() throws SQLException {
        return sp_Dao.getThuTuSP();
    }
    
    public boolean themSanPham(SanPham s) {
        return sp_Dao.themSanPham(s);
    }
    
    public boolean updateSanPham(SanPham s) {
        return sp_Dao.updateSanPham(s);
    }
    
    public List<SanPham> getAllSanPham() {
        return sp_Dao.getAllSanPham();
    }
    
    public ArrayList<SanPham> timKiemSanPham(String queryParams) {
        return sp_Dao.timKiemSanPham(queryParams);
    }
    
    public  ArrayList<SanPham> locSanPham(NhaCungCap nhaCungCap, TacGia tacGia, DanhMuc danhMuc, TheLoai theLoai) {
        return sp_Dao.locSanPham(nhaCungCap, tacGia, danhMuc, theLoai);
    }
    
    public String getTenSPByMa(String maSP) {
        return sp_Dao.getSanPhamByMaSP(maSP);
    }
    
    public SanPham getSanPhamTheoMa(String maSPham) {
        return sp_Dao.getSanPhamTheoMa(maSPham);
    }
}
