/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.NhanVien;
import DomainModel.SanPham;
import Service.Implement.HoaDonChiTietServiceImplement;
import Service.Implement.HoaDonServiceImplement;
import Service.Implement.LoaiSanPhamServiceImplement;
import Service.Implement.MauSacServiceImplement;
import Service.Implement.SanPhamServiceImplement;
import Service.Interface.HoaDonChiTietServiceInterface;
import Service.Interface.HoaDonServiceInterface;
import Service.Interface.LoaiSanPhamServiceInterface;
import Service.Interface.MauSacServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import ViewModel.ChatLieuViewModel;
import ViewModel.HoaDonChiTietViewModel;
import ViewModel.HoaDonViewModel;
import ViewModel.LoaiSanPhamViewModel;
import ViewModel.MauSacViewModel;
import ViewModel.SanPhamViewModel;
import ViewModel.SizeViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mr.quyen
 */
public class BanHangJpanel extends javax.swing.JPanel {

    private HoaDonChiTietServiceInterface hdCTService = new HoaDonChiTietServiceImplement();
    private HoaDonServiceInterface hdService = new HoaDonServiceImplement();
    private SanPhamServiceInterface sanPhamServiceInterface = new SanPhamServiceImplement();
    private LoaiSanPhamServiceInterface loaiSanPhamServiceInterface = new LoaiSanPhamServiceImplement();
    private MauSacServiceInterface mauSacServiceInterface = new MauSacServiceImplement();

    /**
     * Creates new form BanHang
     */
    public BanHangJpanel() {
        initComponents();
        filltableHoaDon();
        fillSanphamBanhang();
        loadCombobox();

    }

    public void filltableHoaDon() {
        DefaultTableModel tbmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        tbmHoaDon.setRowCount(0);
        for (HoaDonViewModel x : hdService.getAllHD()) {
            tbmHoaDon.addRow(new Object[]{x.getMaHoaDon(), x.getNhanVien(), x.getNgayTao(), x.getTrangThai()});
        }

    }

    public void filltableGioHang(String mahd) {
        DefaultTableModel tbmGioHang = (DefaultTableModel) tblGiohang.getModel();
        tbmGioHang.setRowCount(0);
        for (HoaDonChiTietViewModel x : hdCTService.getHDCT(mahd)) {
            tbmGioHang.addRow(new Object[]{
                x.getTenSP(),
                x.getSoLuong(),
                x.getDonGia()});
        }

    }
//          public void filltotablehdct(String mahd) {
//        tbmHDCT.setRowCount(0);
//        for (HoaDonCTVmodel x : hdctitf.gethdct(mahd)) {
//            tbmHDCT.addRow(new Object[]{x.getMa_SP(), x.getTenSP(), x.getDonGia(), x.getSL_Mua(), x.getID_VI(), x.getID_SIZE(), x.getID_dM(), x.getTongtien()});
//        }
//    }

    public void fillSanphamBanhang() {

        DefaultTableModel tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        List<SanPhamViewModel> list = sanPhamServiceInterface.getListSP();
        for (SanPhamViewModel sanPhamViewModel : list) {
            tblModel.addRow(new Object[]{
                sanPhamViewModel.getMaSanPham(),
                sanPhamViewModel.getTenSanPham(),
                sanPhamViewModel.getMauSac(),
                sanPhamViewModel.getChatLieu(),
                sanPhamViewModel.getLoaiSanPham(),
                sanPhamViewModel.getSize(),
                sanPhamViewModel.getSoLuong(),
                sanPhamViewModel.getGiaBan(),
                sanPhamViewModel.isTinhTrang() ? "còn hàng" : "hết hàng"
            });
        }

    }

    public void loadCombobox() {
//        cbbmausac.removeAllItems();
        List<MauSacViewModel> listMauSacs = mauSacServiceInterface.getAllForCBB();
        for (MauSacViewModel listMauSac : listMauSacs) {
            cbbmausac.addItem(listMauSac.getTenMauSac());
        }
//        cbbloai.removeAllItems();
        List<LoaiSanPhamViewModel> listLoaiSanPhams = loaiSanPhamServiceInterface.getAllForCBB();
        for (LoaiSanPhamViewModel listMauSac : listLoaiSanPhams) {
            cbbloai.addItem(listMauSac.getTenLoaiSanPham());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSDTKhachhang = new javax.swing.JTextField();
        btnTimKiemKhachhang = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtHoTemKhachhang = new javax.swing.JTextField();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbMaHoaDon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbMaNhanVien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        btnHoaDonCho = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lbTienThua = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHuyThanhToan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbCanThanhToan = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGiohang = new javax.swing.JTable();
        btXoaSanPham = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimKiemSanPham = new javax.swing.JTextField();
        btnTimKiemSanPham = new javax.swing.JButton();
        cbbmausac = new javax.swing.JComboBox<>();
        cbbloai = new javax.swing.JComboBox<>();
        btnThemSanPham = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Table Đơn hàng ");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã NV", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Khách hàng");

        lbKhachHang.setText("...");

        jLabel6.setText("SĐT");

        txtSDTKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTKhachhangActionPerformed(evt);
            }
        });

        btnTimKiemKhachhang.setText("Tìm Kiếm");

        jLabel7.setText("Họ Tên KH");

        btnThemKhachHang.setText("Thêm Khách hàng");

        jLabel8.setText("Mã hóa đơn");

        lbMaHoaDon.setText("...");

        jLabel10.setText("Mã nhân viên");

        lbMaNhanVien.setText("1");

        jLabel12.setText("Ngày Tạo");

        lbNgayTao.setText("dd/mm/yyyy");

        btnHoaDonCho.setText("HD Chờ");
        btnHoaDonCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lbMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHoaDonCho))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMaNhanVien)
                                    .addComponent(lbNgayTao)
                                    .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDTKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnThemKhachHang))
                                    .addComponent(txtHoTemKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 58, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnTimKiemKhachhang)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbMaHoaDon)
                    .addComponent(btnHoaDonCho))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaNhanVien)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgayTao)
                    .addComponent(jLabel12))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDTKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemKhachhang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtHoTemKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(btnThemKhachHang)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Tổng tiền");

        lbTongTien.setText("0");

        jLabel15.setText("Tiền Khách Đưa");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        jLabel16.setText("Tiền thừa");

        lbTienThua.setText("0");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyThanhToan.setText("Hủy Thanh Toán ");
        btnHuyThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyThanhToanActionPerformed(evt);
            }
        });

        jLabel5.setText("Cần Thanh Toán");

        lbCanThanhToan.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTienThua)
                            .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCanThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbTongTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCanThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTienThua)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnHuyThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Table giỏ hàng ");

        tblGiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"
            }
        ));
        jScrollPane2.setViewportView(tblGiohang);

        btXoaSanPham.setText("Xóa Tất cả");
        btXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoaSanPham)
                .addGap(74, 74, 74))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btXoaSanPham)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Table Sản Phẩm ");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản phẩm", "Màu", "Chất Liệu", "Loại", "Size", "Số Lượng", "Giá Bán", "Tình Trạng"
            }
        ));
        jScrollPane3.setViewportView(tblSanPham);

        txtTimKiemSanPham.setText(" ");

        btnTimKiemSanPham.setText("Tìm kiếm");
        btnTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamActionPerformed(evt);
            }
        });

        cbbmausac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu Sắc" }));
        cbbmausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbmausacActionPerformed(evt);
            }
        });

        cbbloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giới Tính" }));
        cbbloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbloaiActionPerformed(evt);
            }
        });

        btnThemSanPham.setText("Thêm Sản Phẩm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTimKiemSanPham)
                .addGap(126, 126, 126)
                .addComponent(cbbmausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(cbbloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSanPham)
                .addGap(49, 49, 49))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemSanPham)
                    .addComponent(cbbmausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSanPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTKhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTKhachhangActionPerformed

    private void btnHoaDonChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChoActionPerformed
        // TODO add your handling code here:
        HoaDon hd = new HoaDon();
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(Integer.parseInt(lbMaNhanVien.getText()));
        hd.setNhanVien(nv);
        hd.setNgayTao(new Date());
        hd.setTrangThai(0);
        hdService.addHD(hd);
        filltableHoaDon();
        JOptionPane.showMessageDialog(this, "Tạo đơn hàng chờ thành công!!");

    }//GEN-LAST:event_btnHoaDonChoActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        txtTienKhachDua.setText("");
        int index = tblHoaDon.getSelectedRow();
        lbMaHoaDon.setText(tblHoaDon.getValueAt(index, 0).toString());
        lbMaNhanVien.setText(tblHoaDon.getValueAt(index, 1).toString());
        lbNgayTao.setText(tblHoaDon.getValueAt(index, 2).toString());
        filltableGioHang(tblHoaDon.getValueAt(index, 0).toString());

        double tongtien = 0.0;
        for (int i = 0; i < hdCTService.getHDCT(tblHoaDon.getValueAt(index, 0).toString()).size(); i++) {
            tongtien += hdCTService.getHDCT(tblHoaDon.getValueAt(index, 0).toString()).get(i).getThanhTien();
        }

        lbTongTien.setText(tongtien + "");

        lbCanThanhToan.setText(tongtien + "");

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        // TODO add your handling code here:
        double TienTraLai = Double.parseDouble("0" + txtTienKhachDua.getText()) - Double.parseDouble(lbCanThanhToan.getText());
        lbTienThua.setText(String.valueOf(TienTraLai));
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        // TODO add your handling code here:
        int index = tblHoaDon.getSelectedRow();
        int index2 = tblSanPham.getSelectedRow();
        
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            HoaDon hd = new HoaDon();
            SanPham sp = new SanPham();
            for (int i = 0; i < hdService.getAllHD().size(); i++) {
                if (hdService.getAllHD().get(i).getMaHoaDon().equals(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0))) {
                    hd.setMaHoaDon(hdService.getAllHD().get(i).getMaHoaDon());
                   
                }
            }
            
            Object Slnhap = JOptionPane.showInputDialog(this, "Mời nhập số lượng");
            if (Slnhap instanceof String) {
                hdct.setSoLuong(Integer.parseInt(Slnhap.toString()));
            } else {
                return;
            }
            for (int i = 0; i < sanPhamServiceInterface.getListSP().size(); i++) {
                if (sanPhamServiceInterface.getListSP().get(i).getMaSanPham().equals(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0))) {
                    sp.setMaSanPham(sanPhamServiceInterface.getListSP().get(i).getMaSanPham());
                    hdct.setDonGia((sanPhamServiceInterface.getListSP().get(i).getGiaBan()));
                    sp.setSoLuong(sanPhamServiceInterface.getListSP().get(i).getSoLuong());
                }
            }
            
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Hóa đơn cần thêm");
            return;
        } else if (index2 == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Sản Phẩm cần thêm");
            return;
        }else if(Integer.parseInt(Slnhap.toString()) > sp.getSoLuong()){
              JOptionPane.showMessageDialog(this, "Số lượng nhập lớn hơn số lượng tồn");
            return; 
        }
            Integer soLuongConLai =null;
            soLuongConLai =sp.getSoLuong()- Integer.parseInt(Slnhap.toString()) ;
            hdct.setHoaDon(hd);
            hdct.setSanPham(sp);
            hdCTService.addHDCT(hdct);
            JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm vào giỏ hàng thành công");
             sanPhamServiceInterface.updateSoLuong(sp.getMaSanPham(),soLuongConLai);
            filltableGioHang(lbMaHoaDon.getText());
            fillSanphamBanhang();

            double tongtien = 0.0;
            for (int i = 0; i < hdCTService.getHDCT(tblHoaDon.getValueAt(index, 0).toString()).size(); i++) {
                tongtien += hdCTService.getHDCT(tblHoaDon.getValueAt(index, 0).toString()).get(i).getThanhTien();
            }

            lbTongTien.setText(tongtien + "");

            lbCanThanhToan.setText(tongtien + "");

        


    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaSanPhamActionPerformed
        // TODO add your handling code here:
          SanPham spgiohang = new SanPham();
           Integer soLuong = 0;
        String idhd = lbMaHoaDon.getText();
        if (idhd.equalsIgnoreCase("...")) {
            JOptionPane.showMessageDialog(this, "Xóa Lỗi");
            return;
        }
//        for (int i = 0; i < sanPhamServiceInterface.getListSP().size(); i++) {
//                if (sanPhamServiceInterface.getListSP().get(i).getMaSanPham().equals(tblGiohang.getValueAt(tblGiohang.getSelectedRow(), 0))) {
//                    spgiohang.setMaSanPham(sanPhamServiceInterface.getListSP().get(i).getMaSanPham());
//                    spgiohang.setSoLuong(sanPhamServiceInterface.getListSP().get(i).getSoLuong());
//                }
//            }
//          for (int i = 0; i < sanPhamServiceInterface.getListSP().size(); i++) {
//                SanPham spsp = new SanPham();
//                if (sanPhamServiceInterface.getListSP().get(i).getMaSanPham().equals(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0))) {
//                 spsp.setSoLuong(sanPhamServiceInterface.getListSP().get(i).getSoLuong());
//                }
//                  soLuong =  spgiohang.getSoLuong() + spsp.getSoLuong();
//            }
//         
//       
       
        hdCTService.removeHDCT(idhd);
//        sanPhamServiceInterface.updateSoLuong(spgiohang.getMaSanPham(), soLuong );
        
        filltableGioHang(lbMaHoaDon.getText());
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        fillSanphamBanhang();

    }//GEN-LAST:event_btXoaSanPhamActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:

        Date ngayThanhToan = new Date();

        int chonHD = tblHoaDon.getSelectedRow();
        if (chonHD < 0) {
            JOptionPane.showMessageDialog(this, "Mời Chọn Hóa Đơn Muốn Thanh Toán!!!");
        } else if (txtTienKhachDua.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mời Nhập Số Tiền Thanh Toán!!!");
        } else if (Double.parseDouble(lbTongTien.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "Thanh Toán Thất bại!!!");
        } else if (Double.parseDouble(txtTienKhachDua.getText()) < Double.parseDouble(lbCanThanhToan.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Đưa Lớn Hơn Số Tiền Cần Trả!!!");
        } else {
            hdService.ThanhToan(lbMaHoaDon.getText(), 2, Double.parseDouble(lbTongTien.getText()), Double.parseDouble(txtTienKhachDua.getText()), Double.parseDouble(lbTienThua.getText()), ngayThanhToan);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!!!");
            filltableHoaDon();
        }


    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamActionPerformed
        // TODO add your handling code here:

        if ("".equalsIgnoreCase(txtTimKiemSanPham.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sản phẩm để tìm kiếm");
            txtTimKiemSanPham.setText("");
            fillSanphamBanhang();
        } else {
            String tenSanPham = txtTimKiemSanPham.getText().trim();
            List<SanPhamViewModel> list = sanPhamServiceInterface.TimKiemSanPhamBH(tenSanPham);

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
                txtTimKiemSanPham.setText("");
            } else {
                DefaultTableModel tblModel = (DefaultTableModel) tblSanPham.getModel();
                tblModel.setRowCount(0);
                for (SanPhamViewModel sanPhamViewModel : list) {
                    tblModel.addRow(new Object[]{
                        sanPhamViewModel.getMaSanPham(),
                        sanPhamViewModel.getTenSanPham(),
                        sanPhamViewModel.getMauSac(),
                        sanPhamViewModel.getChatLieu(),
                        sanPhamViewModel.getLoaiSanPham(),
                        sanPhamViewModel.getSize(),
                        sanPhamViewModel.getSoLuong(),
                        sanPhamViewModel.getGiaBan(),
                        sanPhamViewModel.isTinhTrang() ? "còn hàng" : "hết hàng"
                    });
                }
                txtTimKiemSanPham.setText("");
            }

        }
    }//GEN-LAST:event_btnTimKiemSanPhamActionPerformed

    private void btnHuyThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyThanhToanActionPerformed
        // TODO add your handling code here:
        int chonhd = tblHoaDon.getSelectedRow();
        if (chonhd < 0) {
            JOptionPane.showMessageDialog(this, "Hủy Thất Bại!!!");
        } else {

            hdCTService.removeHDCT(lbMaHoaDon.getText());
            hdService.HuyThanhToan(lbMaHoaDon.getText(), 1);
            JOptionPane.showMessageDialog(this, "Hủy Thanh Toán thành công");
            filltableGioHang(lbMaHoaDon.getText());
        }


    }//GEN-LAST:event_btnHuyThanhToanActionPerformed

    private void cbbmausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbmausacActionPerformed
        // TODO add your handling code here:
        String nameDM = (String) cbbmausac.getSelectedItem();
        List<MauSacViewModel> listMauSacs = mauSacServiceInterface.getAllForCBB();
        List<SanPhamViewModel> list = sanPhamServiceInterface.getListSP();

        if (nameDM.equalsIgnoreCase("Màu Sắc")) {
            list = sanPhamServiceInterface.getListSP();
        } else {
            for (MauSacViewModel mauSacViewModel : listMauSacs) {
                if (mauSacViewModel.getTenMauSac().equalsIgnoreCase(nameDM)) {
                    list = sanPhamServiceInterface.locMauSac(mauSacViewModel.getMaMauSac());
                }
            }
        }
       DefaultTableModel tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModel sanPhamViewModel : list) {
            tblModel.addRow(new Object[]{
                sanPhamViewModel.getMaSanPham(),
                sanPhamViewModel.getTenSanPham(),
                sanPhamViewModel.getMauSac(),
                sanPhamViewModel.getChatLieu(),
                sanPhamViewModel.getLoaiSanPham(),
                sanPhamViewModel.getSize(),
                sanPhamViewModel.getSoLuong(),
                sanPhamViewModel.getGiaBan(),
                sanPhamViewModel.isTinhTrang() ? "còn hàng" : "hết hàng"
            });
        }
    }//GEN-LAST:event_cbbmausacActionPerformed

    private void cbbloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbloaiActionPerformed
        // TODO add your handling code here:
         String nameDM = (String) cbbloai.getSelectedItem();
      List<LoaiSanPhamViewModel> loaiSanPhamViewModels = loaiSanPhamServiceInterface.getAllForCBB();
        List<SanPhamViewModel> list = sanPhamServiceInterface.getListSP();

        if (nameDM.equalsIgnoreCase("Giới Tính")) {
            list = sanPhamServiceInterface.getListSP();
        } else {
            for (LoaiSanPhamViewModel mauSacViewModel : loaiSanPhamViewModels) {
                if (mauSacViewModel.getTenLoaiSanPham().equalsIgnoreCase(nameDM)) {
                    list = sanPhamServiceInterface.locLoai(mauSacViewModel.getTenLoaiSanPham());
                }
            }
        }
       DefaultTableModel tblModel = (DefaultTableModel) tblSanPham.getModel();
        tblModel.setRowCount(0);
        for (SanPhamViewModel sanPhamViewModel : list) {
            tblModel.addRow(new Object[]{
                sanPhamViewModel.getMaSanPham(),
                sanPhamViewModel.getTenSanPham(),
                sanPhamViewModel.getMauSac(),
                sanPhamViewModel.getChatLieu(),
                sanPhamViewModel.getLoaiSanPham(),
                sanPhamViewModel.getSize(),
                sanPhamViewModel.getSoLuong(),
                sanPhamViewModel.getGiaBan(),
                sanPhamViewModel.isTinhTrang() ? "còn hàng" : "hết hàng"
            });
        }
        
    }//GEN-LAST:event_cbbloaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btXoaSanPham;
    private javax.swing.JButton btnHoaDonCho;
    private javax.swing.JButton btnHuyThanhToan;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnTimKiemKhachhang;
    private javax.swing.JButton btnTimKiemSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbloai;
    private javax.swing.JComboBox<String> cbbmausac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCanThanhToan;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tblGiohang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtHoTemKhachhang;
    private javax.swing.JTextField txtSDTKhachhang;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiemSanPham;
    // End of variables declaration//GEN-END:variables
}
