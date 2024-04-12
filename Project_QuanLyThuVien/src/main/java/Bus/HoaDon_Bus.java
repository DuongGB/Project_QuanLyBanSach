/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;

import Dao.HoaDon_Dao;
import Entity.HoaDon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ngoct
 */
public class HoaDon_Bus {
    private final HoaDon_Dao hd_Dao;
    public HoaDon_Bus() {
        hd_Dao = new HoaDon_Dao();
    }
    public boolean themHD(HoaDon hd) {
        return hd_Dao.themHoaDon(hd);
    }
    public ArrayList<HoaDon> getAllHD() {
        return hd_Dao.getAllHD();
    }
    public int getThuTuHoaDon() throws SQLException {
        return hd_Dao.getThuTuHoaDon();
    }
    public ArrayList<HoaDon> getHoaDonByDateRange(Date fromDate, Date toDate, String maNV) {
        return hd_Dao.getHoaDonByDateRange(fromDate, toDate, maNV);
    }
    public ArrayList<HoaDon> getHoaDonByDate(Date date, String maNV) {
        return hd_Dao.getHoaDonByDate(date, maNV);
    }
    public ArrayList<HoaDon> getHoaDonByMonthYear(int month, int year, String maNV) {
        return hd_Dao.getHoaDonByMonthYear(month, year, maNV);
    }
    public ArrayList<HoaDon> getHoaDonByNhanVien(String maNV) {
        return hd_Dao.getAllHDByNhanVien(maNV);
    }
    public ArrayList<HoaDon> timHoaDon(String thongTin, String maNV) {
        return hd_Dao.timKiemHD(thongTin, maNV);
    }
}
