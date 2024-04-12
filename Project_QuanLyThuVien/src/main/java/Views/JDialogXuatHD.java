/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;

/**
 *
 * @author ngoct
 */
public class JDialogXuatHD extends javax.swing.JDialog {

    /**
     * Creates new form dialog_xuatHD
     */
    public JDialogXuatHD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_top = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        pnl_title = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        pnl_diaChi = new javax.swing.JPanel();
        lbl_diaChi = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnl_nhanVien = new javax.swing.JPanel();
        lbl_tenNV = new javax.swing.JLabel();
        lbl_maHD = new javax.swing.JLabel();
        lbl_ngayLapHD = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnl_khachHang = new javax.swing.JPanel();
        lbl_khachHang = new javax.swing.JLabel();
        lbl_soDT = new javax.swing.JLabel();
        scr_hoaDon = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        pnl_bottom = new javax.swing.JPanel();
        lbl_vat = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_tongTien = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_tienKhachDua = new javax.swing.JLabel();
        lbl_tienThua = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/H2.png"))); // NOI18N

        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setText("HÓA ĐƠN BÁN HÀNG");
        pnl_title.add(lbl_title);

        lbl_diaChi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_diaChi.setText("Địa chỉ: Nguyễn Văn Bảo, Phường 04, Gò Vấp, TP.HCM");
        pnl_diaChi.add(lbl_diaChi);

        lbl_tenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tenNV.setText("Nhân viên: Ngọc Thắng");

        lbl_maHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_maHD.setText("Mã hóa đơn: HD-0001");

        lbl_ngayLapHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ngayLapHD.setText("Ngày lập hóa đơn: 01-11-2023");

        javax.swing.GroupLayout pnl_nhanVienLayout = new javax.swing.GroupLayout(pnl_nhanVien);
        pnl_nhanVien.setLayout(pnl_nhanVienLayout);
        pnl_nhanVienLayout.setHorizontalGroup(
            pnl_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_nhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_tenNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_maHD)
                    .addComponent(lbl_ngayLapHD))
                .addGap(56, 56, 56))
        );
        pnl_nhanVienLayout.setVerticalGroup(
            pnl_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_nhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tenNV)
                    .addComponent(lbl_maHD))
                .addGap(18, 18, 18)
                .addComponent(lbl_ngayLapHD)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_topLayout = new javax.swing.GroupLayout(pnl_top);
        pnl_top.setLayout(pnl_topLayout);
        pnl_topLayout.setHorizontalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_topLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnl_diaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnl_nhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnl_topLayout.setVerticalGroup(
            pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topLayout.createSequentialGroup()
                .addGroup(pnl_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_topLayout.createSequentialGroup()
                        .addComponent(pnl_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbl_khachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_khachHang.setText("Khách hàng: Ngọc Thắng");

        lbl_soDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_soDT.setText("Số điện thoại: 0123456789");

        javax.swing.GroupLayout pnl_khachHangLayout = new javax.swing.GroupLayout(pnl_khachHang);
        pnl_khachHang.setLayout(pnl_khachHangLayout);
        pnl_khachHangLayout.setHorizontalGroup(
            pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_khachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_khachHang)
                    .addComponent(lbl_soDT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_khachHangLayout.setVerticalGroup(
            pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_khachHangLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_khachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_soDT)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        tbl_hoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scr_hoaDon.setViewportView(tbl_hoaDon);

        lbl_vat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_vat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vat.setText("VAT: 0.05");

        lbl_tongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tongTien.setText("Tổng tiền: 100.000 VND");

        lbl_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tienKhachDua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tienKhachDua.setText("Tiền khách đưa: 200.000 VND");

        lbl_tienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tienThua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tienThua.setText("Tiền thừa: 100.000 VND");

        javax.swing.GroupLayout pnl_bottomLayout = new javax.swing.GroupLayout(pnl_bottom);
        pnl_bottom.setLayout(pnl_bottomLayout);
        pnl_bottomLayout.setHorizontalGroup(
            pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addGroup(pnl_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tongTien)
                    .addComponent(lbl_vat)
                    .addComponent(lbl_tienKhachDua)
                    .addComponent(lbl_tienThua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_bottomLayout.setVerticalGroup(
            pnl_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bottomLayout.createSequentialGroup()
                .addComponent(lbl_vat)
                .addGap(23, 23, 23)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbl_tongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_tienKhachDua)
                .addGap(18, 18, 18)
                .addComponent(lbl_tienThua)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr_hoaDon)
            .addComponent(pnl_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scr_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogXuatHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogXuatHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogXuatHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogXuatHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogXuatHD dialog = new JDialogXuatHD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_diaChi;
    private javax.swing.JLabel lbl_khachHang;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_maHD;
    private javax.swing.JLabel lbl_ngayLapHD;
    private javax.swing.JLabel lbl_soDT;
    private javax.swing.JLabel lbl_tenNV;
    private javax.swing.JLabel lbl_tienKhachDua;
    private javax.swing.JLabel lbl_tienThua;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_tongTien;
    private javax.swing.JLabel lbl_vat;
    private javax.swing.JPanel pnl_bottom;
    private javax.swing.JPanel pnl_diaChi;
    private javax.swing.JPanel pnl_khachHang;
    private javax.swing.JPanel pnl_nhanVien;
    private javax.swing.JPanel pnl_title;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JScrollPane scr_hoaDon;
    private javax.swing.JTable tbl_hoaDon;
    // End of variables declaration//GEN-END:variables
}
