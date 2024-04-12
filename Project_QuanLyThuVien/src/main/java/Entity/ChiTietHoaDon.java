package Entity;

import jakarta.persistence.*;

@Entity
public class ChiTietHoaDon {
    @Column(name = "SoLuong", columnDefinition = "int")
    private int soLuong;

    @ManyToOne
    @Id
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @Id
    @JoinColumn(name = "MaSanPham")
    private SanPham sanPham;

    @Column(name = "GiaBan", columnDefinition = "money")
    private double giaBan;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int soLuong, HoaDon hoaDon, SanPham sanPham, double giaBan) {
        this.soLuong = soLuong;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.giaBan = giaBan;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }


    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "soLuong=" + soLuong + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", giaBan=" + giaBan + '}';
    }
    
}
