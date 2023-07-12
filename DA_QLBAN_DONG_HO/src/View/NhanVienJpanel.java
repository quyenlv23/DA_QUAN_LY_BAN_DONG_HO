/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.NhanVien;
import Service.Implement.NhanVienServiceImplement;
import Service.Interface.NhanVienServiceInterface;
import ViewModel.NhanVienViewModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mr.quyen
 */
public class NhanVienJpanel extends javax.swing.JPanel {

    private NhanVienServiceInterface NVServiceInterface = new NhanVienServiceImplement();
    String strFind = "";

    public NhanVienJpanel() {
        initComponents();
        loadTable();
    }

    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel();
        dtm.setRowCount(0);
        List<NhanVienViewModel> nvds = this.NVServiceInterface.getAll();
        for (NhanVienViewModel khvm : nvds) {
            Object[] rowData = {
                khvm.getMaNhanVien(),
                khvm.getHoTen(),
                khvm.getGioiTinh() == 1 ? "Nam" : "Nu",
                khvm.getDiaChi(),
                khvm.getSoDienThoai(),
                khvm.getEmail(),
                khvm.getMatKhau(),
                khvm.getTrangThai() == 1 ? "Đi làm" : "Nghỉ làm"   ,             
                khvm.getChucVu(),

            };
            dtm.addRow(rowData);
        }
    }
    
    public void clearForm() {
        this.txt_search.setText("");
        this.rdo_nam.isSelected();
        this.rdo_nu.isSelected();
        this.txt_hoten.setText("");
        this.txt_email.setText("");
        this.txt_diachi.setText("");
        this.txt_manv.setText("");
        this.txt_pass.setText("");
        this.txt_sdt.setText("");
        this.cbo_chucvu.setSelectedItem(0);
        this.cbo_trangthai.setSelectedItem(0);

    }

    private NhanVien getFormDaTa() {

        String ma = this.txt_manv.getText().trim();
        String hoten = this.txt_hoten.getText().trim();
        String email = this.txt_email.getText().trim();
        String pass = this.txt_pass.getText().trim();
        String search = this.txt_search.getText().trim();

        int gt;
        if (rdo_nam.isSelected()) {
            gt = 1;
        } else if (rdo_nu.isSelected()) {
            gt = 0;
        } else {
            return null;
        }
//        String trangThai = this.cbo_trangthai.getSelectedItem().toString();
        int trangThai = 0 ;
        String tThai = String.valueOf(trangThai);
        if(cbo_trangthai.getSelectedItem().equals("Đi làm")){
            tThai = "Đi làm" ;
        }
        else{
            tThai ="Nghỉ làm" ;
        }
        String chucVu = this.cbo_chucvu.getSelectedItem().toString();
        String sdt = this.txt_sdt.getText().trim();
        String dc = this.txt_diachi.getText().trim();
        if (hoten.length() == 0 || sdt.length() == 0 || dc.length() == 0) {
            JOptionPane.showMessageDialog(this, "Cần nhập đầy đủ thông tin");
            return null;
        }
        NhanVien nv = new NhanVien(HEIGHT, hoten, gt, dc, sdt, email, pass, trangThai, chucVu);
        return nv;
    }

    public void search(String ten) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        List<NhanVien> khds = this.NVServiceInterface.search(ten);
        for (NhanVien khvm : khds) {
            Object[] rowData = {
                 khvm.getMaNhanVien(),
                khvm.getHoTen(),
                khvm.getGioiTinh() == 1 ? "Nam" : "Nu",
                khvm.getDiaChi(),
                khvm.getSoDienThoai(),
                khvm.getEmail(),
                khvm.getMatKhau(),
                khvm.getTrangThai() == 1 ? "Đi làm" : "Nghỉ làm"   ,             
                khvm.getChucVu(),
            };
            dtm.addRow(rowData);
        }

    }
    
    boolean flag = false;
    boolean check() {
        if (txt_hoten.getText().length() < 3) {
            if (txt_hoten.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Tên không được để trống");

            }
            
        } else if (txt_sdt.getText().length() < 10) {

            if (txt_sdt.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "SDT không được để trống");
            }
            if (txt_sdt.getText().length() > 0 || txt_sdt.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "SDT phải là 10 số");

            }

            if (!txt_sdt.getText().matches("0\\d{2}\\d{2}\\d{5}")) {
                JOptionPane.showMessageDialog(this, "số điện thoại phải đúng định dạng 0\\\\d{9}");
            }
        } else if (txt_email.getText().length() < 5) {
            if (txt_email.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "email không được để trống");
            }
            if (!txt_email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(this, "Email phải đúng định dạng ");

            }
        } else if (txt_diachi.getText().length() < 3) {
            if (txt_diachi.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            }

        } else {
            flag = true;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        cbo_chucvu = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbo_trangthai = new javax.swing.JComboBox<>();
        btn_moi = new javax.swing.JButton();
        Thêm = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("Quản lý nhân viên");

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_search.setText("Tìm kiếm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ và tên", "Giới tính", "Địa chỉ", "Điện thoại", "Email", "Mật khẩu", "Trạng thái", "Chức vụ"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã NV");

        txt_manv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_manv.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Họ Tên NV");

        txt_hoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Mật khẩu");

        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_diachi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Địa chỉ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Điện thoại");

        txt_sdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Email");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Giới tính");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdo_nam.setText("Nam");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdo_nu.setText("Nữ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Chức vụ");

        cbo_chucvu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_chucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Trạng thái");

        cbo_trangthai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi làm", "Nghỉ làm" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rdo_nam)
                                        .addGap(30, 30, 30)
                                        .addComponent(rdo_nu))
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdo_nam)
                    .addComponent(rdo_nu))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(cbo_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbo_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        Thêm.setText("Thêm");
        Thêm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThêmActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btn_moi)
                        .addGap(75, 75, 75)
                        .addComponent(Thêm)
                        .addGap(91, 91, 91)
                        .addComponent(btn_sua))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_search))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_moi)
                    .addComponent(btn_sua)
                    .addComponent(Thêm))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThêmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThêmActionPerformed
        // TODO add your handling code here:
        NhanVien nv = this.getFormDaTa();
        if(check() == false){
           
            JOptionPane.showMessageDialog(this, "Nhập lại ");
            
            
            
        }
        else {
            NVServiceInterface.insert(nv);
            loadTable();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        }
//        if (nv == null) {
//            JOptionPane.showMessageDialog(this, "Cần nhập đầy đủ thông tin");
//            return;
//        } else {
//            int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thêm");
//            if (confirm == JOptionPane.YES_NO_OPTION);
//            NVServiceInterface.insert(nv);
//             loadTable();
//            JOptionPane.showMessageDialog(this, "Thêm thành công");
//            
//            this.clearForm();
//        }
//QuanAo qa = getForm();
//        if(valiDate(qa)){
//            service.addQA(getForm());
//            FillToTable();
//            service.ghi();
//             JOptionPane.showMessageDialog(this, "Ghi thành công");
//        }

         
    }//GEN-LAST:event_ThêmActionPerformed
    
    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        // TODO add your handling code here:
        this.clearForm();
        this.loadTable();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int row = this.jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng để sửa");

            return;
        }
        NhanVien nv = this.getFormDaTa();
        if (nv == null) {
            return;
        }
        String ma = this.jTable1.getValueAt(row, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận sửa");
        if (confirm != JOptionPane.YES_NO_OPTION) {
            return;
        }
        this.NVServiceInterface.update(nv, ma);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        this.loadTable();
        this.clearForm();
        



    }//GEN-LAST:event_btn_suaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = this.jTable1.getSelectedRow();
        if (row == -1) {
            return;
        }
        String ma = this.jTable1.getValueAt(row, 0).toString();
        String hoten = this.jTable1.getValueAt(row, 1).toString();
        String gt = this.jTable1.getValueAt(row, 2).toString();
        String dc = this.jTable1.getValueAt(row, 3).toString();
        String sdt = this.jTable1.getValueAt(row, 4).toString();
        String email = this.jTable1.getValueAt(row, 5).toString();
        String pass = this.jTable1.getValueAt(row, 6).toString();
        String tthai = this.jTable1.getValueAt(row, 7).toString();
        String cvu = this.jTable1.getValueAt(row, 8).toString();
        this.txt_manv.setText(ma);
        this.txt_hoten.setText(hoten);
        if (jTable1.getValueAt(row, 2).toString().equalsIgnoreCase("Nam")) {
            this.rdo_nam.setSelected(true);
        } else {
            this.rdo_nu.setSelected(true);
        }
        this.txt_sdt.setText(sdt);
        this.txt_diachi.setText(dc);
        this.txt_email.setText(email);
        this.txt_pass.setText(pass);
        this.cbo_trangthai.setSelectedItem(tthai);
        this.cbo_chucvu.setSelectedItem(cvu);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
//        String tk= txt_search.getText().trim();
//         if(tk.length()==0){
//             JOptionPane.showMessageDialog(this, "Nhập tên nhân viên !!!");
//             return ;
//         }else{
//             strFind=txt_search.getText();
//             List<NhanVien> nv=NVServiceInterface.search(tk);
//             if(nv.isEmpty()){
//                 JOptionPane.showMessageDialog(this, "khong tim thay ");
//                clearForm();
//             }else{
//                 search(tk);
//                 JOptionPane.showMessageDialog(this,"Đã tìm thấy nhân viên");
//                 clearForm();
//                
//             }
//         }
String tk = txt_search.getText().trim();
if (tk.length() == 0) {
    JOptionPane.showMessageDialog(this, "Nhập tên nhân viên !!!");
    return;
} else {
    strFind = txt_search.getText();
    List<NhanVien> nv = NVServiceInterface.search(tk);
    if (nv.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
        clearForm();
    } else {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear table
        for (NhanVien nhanvien : nv) {
            Object[] rowData = {
                nhanvien.getMaNhanVien(),
                nhanvien.getHoTen(),
                nhanvien.getGioiTinh() == 1 ? "Nam" : "Nu",
                nhanvien.getDiaChi(),
                nhanvien.getSoDienThoai(),
                nhanvien.getEmail(),
                nhanvien.getMatKhau(),
                nhanvien.getTrangThai() == 1 ? "Đi làm" : "Nghỉ làm",
                nhanvien.getChucVu(),
            };
            model.addRow(rowData); // Add row to table
        }
        JOptionPane.showMessageDialog(this, "Đã tìm thấy nhân viên");
        clearForm();
    }
}
       
         
    }//GEN-LAST:event_btn_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Thêm;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbo_chucvu;
    private javax.swing.JComboBox<String> cbo_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
