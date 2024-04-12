/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import com.raven.main.ChartUI;
import com.raven.main.ChartUIKhoangNgay;
import com.raven.main.ChartUISanPham;
import com.raven.main.ChartUITheoThang;
import java.sql.SQLException;

/**
 *
 * @author ngoct
 */
public class panel_ThongKeNVQL extends javax.swing.JPanel {
    /**
     * Creates new form panel_ThongKeNVBH
     * @throws java.sql.SQLException
     */
    public panel_ThongKeNVQL() throws SQLException {
        initComponents();
        customInitComponents();
    }
    
    private void customInitComponents() throws SQLException {
        charUITheoNgay();
        chartUITheoThang();
        chartUIByRange();
        ChartUISanPham ui = new ChartUISanPham();
        tb_sanPham.add("Sản phẩm bán chạy", ui.getContentPane());
    }
    
    private void charUITheoNgay() throws SQLException {
        ChartUI chart = new ChartUI(true);
        tp_inside.add("Thống kê theo ngày", chart.getContentPane());
    }
    
    private void chartUITheoThang() throws SQLException {
        ChartUITheoThang chart = new ChartUITheoThang(true);
        tp_inside.add("Thống kê từng tháng theo năm", chart.getContentPane());
    }
    
    private void chartUIByRange() throws SQLException {
        ChartUIKhoangNgay chart = new ChartUIKhoangNgay(true);
        tp_inside.add("Thống kê theo khoảng ngày", chart.getContentPane());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tp_all = new javax.swing.JTabbedPane();
        tp_inside = new javax.swing.JTabbedPane();
        tb_sanPham = new javax.swing.JTabbedPane();

        tp_all.addTab("Doanh thu", tp_inside);
        tp_all.addTab("Sản phẩm", tb_sanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_all, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_all, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tb_sanPham;
    private javax.swing.JTabbedPane tp_all;
    private javax.swing.JTabbedPane tp_inside;
    // End of variables declaration//GEN-END:variables
}
