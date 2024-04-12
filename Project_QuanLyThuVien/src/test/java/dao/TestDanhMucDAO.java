/*
 * @ {#} TestDanhMucDAO.java   1.0     12/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package dao;

import Bus.DanhMuc_Bus;
import Dao.DanhMuc_Dao;
import Entity.DanhMuc;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   12/04/2024
 * @version:    1.0
 */
public class TestDanhMucDAO {
    private static DanhMuc_Dao danhMucDao=new DanhMuc_Dao();
    @BeforeAll
    public static void init(){
        danhMucDao = new DanhMuc_Dao();
    }
    @Test
    public void testGetAllDanhMuc() {
        List<DanhMuc> danhMucList = danhMucDao.getAllDanhMuc();
        assertFalse(danhMucList.isEmpty(), "Danh sách danh mục không được rỗng");
        assertEquals(2, danhMucList.size());

    }
    @Test
    public void testTimKiemDanhMuc(){
        List<DanhMuc> danhMucList = danhMucDao.timKiemDanhMuc("Phòng");
        assertFalse(danhMucList.isEmpty(), "Danh sách danh mục không được rỗng");
        assertEquals(1, danhMucList.size());
    }
    @Test
    public void testThemDanhMuc(){
        String tenDanhMuc = "Phòng 3";
        assertTrue(danhMucDao.themDanhMuc(tenDanhMuc));
    }
    @AfterAll
    public static void close() {
        danhMucDao.close();
    }
}
