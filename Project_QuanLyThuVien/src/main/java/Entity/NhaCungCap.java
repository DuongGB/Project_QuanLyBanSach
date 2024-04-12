package Entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class NhaCungCap {
    @Id
    @Column(name = "MaNhaCungCap", columnDefinition = "nchar(15)")
    private String maNhaCungCap;
    @Column(name = "TenNhaCungCap", columnDefinition = "nvarchar(255)")
    private String tenNhaCungCap;
    @Column(name = "DiaChiNCC", columnDefinition = "nvarchar(255)")
    private String diaChi;
    @Column(name = "SoDienThoai", columnDefinition = "varchar(20)")
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private Set<SanPham> sanPhams;
    public NhaCungCap() {
    }

    public NhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Set<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(Set<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.maNhaCungCap);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhaCungCap other = (NhaCungCap) obj;
        return Objects.equals(this.maNhaCungCap, other.maNhaCungCap);
    }

    @Override
    public String toString() {
        return tenNhaCungCap;
    }
    
}
