/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;

import Dao.NhaCungCap_Dao;
import Entity.NhaCungCap;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ngoct
 */
public class NhaCungCap_Bus {
    private final NhaCungCap_Dao ncc_Dao;
    public NhaCungCap_Bus() {
        ncc_Dao = new NhaCungCap_Dao();
    }
    
    public int getThuTuNCC() throws SQLException {
        return ncc_Dao.getThuTuNCC();
    }
    
    public boolean themNCC(NhaCungCap ncc) {
        return ncc_Dao.themNCC(ncc);
    }
    
    public boolean updateNCC(NhaCungCap ncc) {
        return ncc_Dao.updateNCC(ncc);
    }
    
    public ArrayList<NhaCungCap> getAllNCC() {
        return ncc_Dao.getAllNCC();
    }
    
    public ArrayList<NhaCungCap> timKiemNCC(String queryParams) {
        return ncc_Dao.timKiemNCC(queryParams);
    }
}
