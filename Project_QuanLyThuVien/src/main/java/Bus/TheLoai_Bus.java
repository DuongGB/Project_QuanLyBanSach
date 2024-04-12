/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus;

import Dao.TheLoai_Dao;
import Entity.TheLoai;
import java.util.ArrayList;

/**
 *
 * @author ngoct
 */
public class TheLoai_Bus {
     private final TheLoai_Dao theLoai_Dao;
    public TheLoai_Bus() {
        theLoai_Dao = new TheLoai_Dao();
    }
    
    public boolean themTheLoai(String tenDanhMuc, int maDanhMuc) {
        return theLoai_Dao.themTheLoai(tenDanhMuc, maDanhMuc);
    }
    
    public boolean updateTheLoai(TheLoai theLoai) {
        return theLoai_Dao.updateTheLoai(theLoai);
    }
    
    public ArrayList<TheLoai> getAllTheLoai() {
        return theLoai_Dao.getAllTheLoai();
    }
    
    public ArrayList<TheLoai> timKiemTheLoai(String queryParams) {
        return theLoai_Dao.timKiemTheLoai(queryParams);
    }
}
