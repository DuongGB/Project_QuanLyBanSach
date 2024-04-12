/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;

import Dao.ChiTietHoaDon_Dao;
import Dao.HoaDon_Dao;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ngoct
 */
public class ChiTietHoaDon_Bus {
    private final ChiTietHoaDon_Dao cthd_Dao;
    public ChiTietHoaDon_Bus() {
        cthd_Dao = new ChiTietHoaDon_Dao();
    }
    public boolean themCTHD(ChiTietHoaDon cthd) {
        return cthd_Dao.themCTHD(cthd);
    }
    public ArrayList<ChiTietHoaDon> getAllCTHD() {
        return cthd_Dao.getAllCTHD();
    }
    public ArrayList<ChiTietHoaDon> getChiTietByMa(String maHoaDon) {
        return cthd_Dao.getChiTietByMaHD(maHoaDon);
    }
    public double getTongTienHoaDon(String maHD) throws SQLException {
        return cthd_Dao.getTongTienHoaDon(maHD);
    }
    public ArrayList<Object[]> getSpBanChay(int limit, Date date, Date fromDate, Date endDate) throws SQLException {
        return cthd_Dao.getTopSanPhamBanChay(limit, date, fromDate, endDate);
    }
}
