/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModel.ChatLieu;
import DomainModel.LoaiSanPham;
import DomainModel.MauSac;
import DomainModel.SanPham;
import DomainModel.Size;
import Repository.Implement.ChatLieuRepositoryImplement;
import Repository.Interface.ChatLieuRepositoryInterface;
import Service.Implement.ChatLieuServiceImplement;
import Service.Implement.LoaiSanPhamServiceImplement;
import Service.Implement.MauSacServiceImplement;
import Service.Implement.SanPhamServiceImplement;
import Service.Implement.SizeServiceImplement;
import Service.Interface.ChatLieuServiceInterface;
import Service.Interface.LoaiSanPhamServiceInterface;
import Service.Interface.MauSacServiceInterface;
import Service.Interface.SanPhamServiceInterface;
import Service.Interface.SizeServiceInterface;
import ViewModel.ChatLieuViewModel;
import ViewModel.LoaiSanPhamViewModel;
import ViewModel.MauSacViewModel;
import ViewModel.SanPhamViewModel;
import ViewModel.SizeViewModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mr.quyen
 */
public class SanPhamJpanel extends javax.swing.JPanel {

    final MauSacServiceInterface mauSacServiceInterface = new MauSacServiceImplement();
    final ChatLieuServiceInterface chatLieuServiceInterface = new ChatLieuServiceImplement();
    final LoaiSanPhamServiceInterface loaiSanPhamServiceInterface = new LoaiSanPhamServiceImplement();
    final SizeServiceInterface sizeServiceInterface = new SizeServiceImplement();
    final SanPhamServiceInterface sanPhamServiceInterface = new SanPhamServiceImplement();

    /**
     * Creates new form SanPhamJpanel
     */
    public SanPhamJpanel() {

        initComponents();
        txtMaThuocTinh.setEditable(false);
        txtMaSanPham.setEditable(false);
        loadCombobox();
        loadTableSanPham();
        loadTableMauSac();
        rdoCon.setSelected(true);
        rdoMauSac.setSelected(true);
    }

    //load thuoc tinh vao combobox
    public void loadCombobox() {
        cbbMauSac.removeAllItems();
        List<MauSacViewModel> listMauSacs = mauSacServiceInterface.getAllForCBB();
        for (MauSacViewModel listMauSac : listMauSacs) {
            cbbMauSac.addItem(listMauSac);
        }

        cbbKichThuoc.removeAllItems();
        List<SizeViewModel> listSizes = sizeServiceInterface.getAllForCBB();
        for (SizeViewModel listMauSac : listSizes) {
            cbbKichThuoc.addItem(listMauSac);
        }

        cbbChatLieu.removeAllItems();
        List<ChatLieuViewModel> listChatLieus = chatLieuServiceInterface.getAllForCBB();
        for (ChatLieuViewModel listMauSac : listChatLieus) {
            
            cbbChatLieu.addItem(listMauSac);
        }

        cbbLoaiSanPham.removeAllItems();
        List<LoaiSanPhamViewModel> listLoaiSanPhams = loaiSanPhamServiceInterface.getAllForCBB();
        for (LoaiSanPhamViewModel listMauSac : listLoaiSanPhams) {
            cbbLoaiSanPham.addItem(listMauSac);
        }
    }

    public void clear() {
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtTimKiem.setText("");
        txtMaSanPham.setText("");
        txtTenSP.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtSoLuong.setText("");
//        txtMaMay.setText("");
        rdoCon.setSelected(true);
        txtMoTa.setText("");
        loadCombobox();
    }

    public void loadTextField(int index) {
        txtMaThuocTinh.setText(tblThuocTinhSanPham.getValueAt(index, 0).toString());
        txtTenThuocTinh.setText(tblThuocTinhSanPham.getValueAt(index, 1).toString());
    }

    public void loadTextFieldSanPham(SanPham sanPham) {
        txtMaSanPham.setText(sanPham.getMaSanPham().toString());
        txtTenSP.setText(sanPham.getTenSanPham());
        txtGiaNhap.setText(sanPham.getGiaNhap().toString());
        txtGiaBan.setText(sanPham.getGiaBan().toString());
        txtSoLuong.setText(sanPham.getSoLuong().toString());
//        txtMaMay.setText(sanPham.getMaMay());
        txtMoTa.setText(sanPham.getMoTa());

        cbbMauSac.removeAllItems();
        List<MauSacViewModel> listMauSacs = mauSacServiceInterface.getAllForCBB();
        for (MauSacViewModel listMauSac : listMauSacs) {
            cbbMauSac.addItem(listMauSac);
            if (sanPham.getMauSac().getMaMauSac().equals(listMauSac.getMaMauSac())) {
                cbbMauSac.setSelectedItem(listMauSac);
            }
        }

        cbbKichThuoc.removeAllItems();
        List<SizeViewModel> listSizes = sizeServiceInterface.getAllForCBB();
        for (SizeViewModel listMauSac : listSizes) {
            cbbKichThuoc.addItem(listMauSac);
            if (sanPham.getSize().getMasize().equals(listMauSac.getMasize())) {
                cbbKichThuoc.setSelectedItem(listMauSac);
            }
        }

        cbbChatLieu.removeAllItems();
        List<ChatLieuViewModel> listChatLieus = chatLieuServiceInterface.getAllForCBB();
        for (ChatLieuViewModel listMauSac : listChatLieus) {
            cbbChatLieu.addItem(listMauSac);
            if (sanPham.getChatLieu().getMaChatLieu().equals(listMauSac.getMaChatLieu())) {
                cbbChatLieu.setSelectedItem(listMauSac);
            }
        }

        cbbLoaiSanPham.removeAllItems();
        List<LoaiSanPhamViewModel> listLoaiSanPhams = loaiSanPhamServiceInterface.getAllForCBB();
        for (LoaiSanPhamViewModel listMauSac : listLoaiSanPhams) {
            cbbLoaiSanPham.addItem(listMauSac);
            if (sanPham.getLoaiSanPham().getMaLoaiSanPham().equals(listMauSac.getMaLoaiSanPham())) {
                cbbLoaiSanPham.setSelectedItem(listMauSac);
            }
        }

        if (sanPham.isTinhTrang()) {
            rdoCon.setSelected(true);
            rdoHet.setSelected(false);
        } else {
            rdoCon.setSelected(false);
            rdoHet.setSelected(true);
        }
    }

    public void loadTableOneMauSac(MauSac mauSac) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});

        model.addRow(new Object[]{mauSac.getMaMauSac(), mauSac.getTenMauSac()});

        tblThuocTinhSanPham.setModel(model);
    }

    //load mausac
    public void loadTableMauSac() {
        List<MauSac> listMauSac = mauSacServiceInterface.getAll();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
        for (MauSac ctsp : listMauSac) {
            model.addRow(new Object[]{ctsp.getMaMauSac(), ctsp.getTenMauSac()});
        }
        tblThuocTinhSanPham.setModel(model);
    }

    public void loadTableOneChatLieu(ChatLieu chatLieu) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});

        model.addRow(new Object[]{chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu()});

        tblThuocTinhSanPham.setModel(model);
    }

    //load chatlieu
    public void loadTableChatLieu() {
        List<ChatLieu> listChatLieus = chatLieuServiceInterface.getAll();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
        for (ChatLieu ctsp : listChatLieus) {
            model.addRow(new Object[]{ctsp.getMaChatLieu(), ctsp.getTenChatLieu()});
        }
        tblThuocTinhSanPham.setModel(model);
    }

    public void loadTableOneLoaiSanPham(LoaiSanPham loaiSanPham) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});

        model.addRow(new Object[]{loaiSanPham.getMaLoaiSanPham(), loaiSanPham.getTenLoaiSanPham()});

        tblThuocTinhSanPham.setModel(model);
    }

    //load loaiSP
    public void loadTableLoaiSanPham() {
        List<LoaiSanPham> listLoaiSanPhams = loaiSanPhamServiceInterface.getAll();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
        for (LoaiSanPham ctsp : listLoaiSanPhams) {
            model.addRow(new Object[]{ctsp.getMaLoaiSanPham(), ctsp.getTenLoaiSanPham()});
        }
        tblThuocTinhSanPham.setModel(model);
    }

    public void loadTableOneSize(Size size) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});

        model.addRow(new Object[]{size.getMasize(), size.getTenSize()});

        tblThuocTinhSanPham.setModel(model);
    }

    //load size
    public void loadTableSize() {
        List<Size> listSizes = sizeServiceInterface.getAll();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm",
            "tên thuộc tính sản phẩm"});
        for (Size ctsp : listSizes) {
            model.addRow(new Object[]{ctsp.getMasize(), ctsp.getTenSize()});
        }
        tblThuocTinhSanPham.setModel(model);
    }

    //load san pham
    public void loadTableSanPham() {
        List<SanPham> listSizes = sanPhamServiceInterface.getAll();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Mã sản phẩm", "tên sản phẩm",
            "loại sản phẩm", "đơn giá", "số lượng", "màu sắc", "sire", "chất liệu",
            "Mô tả",
            "trạng thái"});
        for (SanPham ctsp : listSizes) {
            model.addRow(new Object[]{ctsp.getMaSanPham(), ctsp.getTenSanPham(),
                ctsp.getLoaiSanPham().getTenLoaiSanPham(),
                ctsp.getGiaBan(),
                ctsp.getSoLuong(),
                ctsp.getMauSac().getTenMauSac(),
                ctsp.getSize().getTenSize(),
                ctsp.getChatLieu().getTenChatLieu(),
//                ctsp.getMaMay(),
                ctsp.getMoTa(),
                ctsp.isTinhTrang()? "còn" : "hết"});
        }
        tbtSanPham.setModel(model);
    }

    public MauSac getDaTaMauSac() {
        MauSac mauSac = new MauSac();

        if (!"".equals(txtTenThuocTinh.getText().trim())) {
            mauSac.setTenMauSac(txtTenThuocTinh.getText().trim());
            return mauSac;
        } else {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            txtTenThuocTinh.setText("");
        }
        return null;
    }

    public ChatLieu getDaTaChatLieu() {
        ChatLieu chatLieu = new ChatLieu();
        if (!"".equals(txtTenThuocTinh.getText().trim())) {
            chatLieu.setTenChatLieu(txtTenThuocTinh.getText().trim());
            return chatLieu;
        } else {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            txtTenThuocTinh.setText("");
        }
        return null;

    }

    public LoaiSanPham getDaTaLoaiSanPham() {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        if (!"".equals(txtTenThuocTinh.getText().trim())) {
            loaiSanPham.setTenLoaiSanPham(txtTenThuocTinh.getText().trim());
            return loaiSanPham;
        } else {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            txtTenThuocTinh.setText("");
        }
        return null;

    }

    public Size getDaTaSize() {
        Size size = new Size();
        if (!"".equals(txtTenThuocTinh.getText().trim())) {
            size.setTenSize(txtTenThuocTinh.getText().trim());
            return size;
        } else {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            txtTenThuocTinh.setText("");
        }
        return null;

    }

    public SanPham getDaTaSanPham() {
        SanPham sanPhamViewModel = new SanPham();

        if (!"".equals(txtTenSP.getText().trim())) {
            sanPhamViewModel.setTenSanPham(txtTenSP.getText().trim());

            if (!"".equals(txtGiaNhap.getText().trim())) {

                try {
                    Double.parseDouble(txtGiaNhap.getText().trim()); // Sử dụng Double.parseDouble() nếu bạn muốn kiểm tra kiểu số thực
                    if (Double.parseDouble(txtGiaNhap.getText().trim()) > 0) {
                        sanPhamViewModel.setGiaNhap(Double.valueOf(txtGiaNhap.getText().trim()));

                        if (!"".equals(txtGiaBan.getText().trim())) {
                            try {
                                Double.parseDouble(txtGiaBan.getText().trim()); // Sử dụng Double.parseDouble() nếu bạn muốn kiểm tra kiểu số thực
                                if (Double.parseDouble(txtGiaBan.getText().trim()) > 0) {
                                    if (Double.parseDouble(txtGiaBan.getText().trim()) > Double.parseDouble(txtGiaNhap.getText().trim())) {
                                        sanPhamViewModel.setGiaBan(Double.valueOf(txtGiaBan.getText().trim()));

                                        //validate số lượng
                                        if (!"".equals(txtSoLuong.getText().trim())) {
                                            try {
                                                Double.parseDouble(txtSoLuong.getText().trim()); // Sử dụng Double.parseDouble() nếu bạn muốn kiểm tra kiểu số thực
                                                if (Double.parseDouble(txtSoLuong.getText().trim()) > 0) {
                                                    sanPhamViewModel.setSoLuong(Integer.valueOf(txtSoLuong.getText().trim()));

                                                    //validate mã máy
//                                                    if (!"".equals(txtMaMay.getText().trim())) {
//
//                                                        if (txtMaMay.getText().trim().length() == 5) {
//                                                            sanPhamViewModel.setMaMay(txtMaMay.getText().trim());

                                                            //validate mô tả
                                                            if (!"".equals(txtMoTa.getText().trim())) {

                                                                sanPhamViewModel.setMoTa(txtMoTa.getText().trim());

                                                                MauSacViewModel mauSacViewModel = (MauSacViewModel) cbbMauSac.getSelectedItem();
                                                                MauSac mauSac = mauSacServiceInterface.getOne(mauSacViewModel.getMaMauSac());
                                                                sanPhamViewModel.setMauSac(mauSac);

                                                                SizeViewModel sizeViewModel = (SizeViewModel) cbbKichThuoc.getSelectedItem();
                                                                Size size = sizeServiceInterface.getOne(sizeViewModel.getMasize());
                                                                sanPhamViewModel.setSize(size);

                                                                ChatLieuViewModel chatLieuViewModel = (ChatLieuViewModel) cbbChatLieu.getSelectedItem();
                                                                ChatLieu chatLieu = chatLieuServiceInterface.getOne(chatLieuViewModel.getMaChatLieu());
                                                                sanPhamViewModel.setChatLieu(chatLieu);

                                                                LoaiSanPhamViewModel loaiSanPhamViewModel = (LoaiSanPhamViewModel) cbbLoaiSanPham.getSelectedItem();
                                                                LoaiSanPham loaiSanPham = loaiSanPhamServiceInterface.getOne(loaiSanPhamViewModel.getMaLoaiSanPham());
                                                                sanPhamViewModel.setLoaiSanPham(loaiSanPham);

                                                                if (rdoCon.isSelected()) {
                                                                    sanPhamViewModel.setTinhTrang(true);
                                                                } else {
                                                                    sanPhamViewModel.setTinhTrang(false);
                                                                }

                                                                return sanPhamViewModel;

                                                            } else {
                                                                JOptionPane.showMessageDialog(this, "Nhập mô tả sản phẩm");
                                                                txtMoTa.setText("");
                                                            }
//                                                        }
//                                                        else {
//                                                            JOptionPane.showMessageDialog(this, "Mã máy phải có 5 kí tự");
//                                                            txtMaMay.setText("");
//                                                        }

//                                                    }
//                                                    else {
//                                                        JOptionPane.showMessageDialog(this, "Mã máy không được để trống");
//                                                        txtMaMay.setText("");
//                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                                                    txtSoLuong.setText("");
                                                }
                                            } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(this, "Nhập số");
                                                txtSoLuong.setText("");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Số lượng không được để trống");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn giá nhập");
                                        txtGiaBan.setText("");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0");
                                    txtGiaBan.setText("");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(this, "Nhập số");
                                txtGiaBan.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "giá bán không được để trống");
                            txtGiaBan.setText("");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
                        txtGiaNhap.setText("");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Nhập số");
                    txtGiaNhap.setText("");
                }

            } else {
                JOptionPane.showMessageDialog(this, "giá nhập không được để trống");
                txtGiaNhap.setText("");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            txtTenSP.setText("");
        }
        return null;

        //sdfsdfsdf
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbtSanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbKichThuoc = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbLoaiSanPham = new javax.swing.JComboBox<>();
        rdoCon = new javax.swing.JRadioButton();
        rdoHet = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaThuocTinh = new javax.swing.JTextField();
        txtTenThuocTinh = new javax.swing.JTextField();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoKichThuoc = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoLoaiSanPham = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThuocTinhSanPham = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setText("Tìm kiếm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tbtSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá", "Số lượng", "Màu sắc", "Size", "Chất liệu", "Trạng thái"
            }
        ));
        tbtSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbtSanPham);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton7)
                .addGap(124, 124, 124))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Giá nhập");

        jLabel4.setText("Giá bán");

        jLabel5.setText("Số lượng");

        jLabel7.setText("Mô tả");

        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jLabel8.setText("Màu sắc");

        jLabel9.setText("Kích thước");

        jLabel10.setText("Chất liệu");

        jLabel11.setText("Loại sản phẩm");

        jLabel12.setText("Trạng thái");

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<MauSacViewModel>());
        cbbMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSacActionPerformed(evt);
            }
        });

        cbbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<SizeViewModel>());

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<ChatLieuViewModel>());

        cbbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<LoaiSanPhamViewModel>());

        buttonGroup1.add(rdoCon);
        rdoCon.setText("Còn");

        buttonGroup1.add(rdoHet);
        rdoHet.setText("Hết");

        jButton2.setText("Quét mã");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(151, 151, 151)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(rdoCon)
                        .addGap(29, 29, 29)
                        .addComponent(rdoHet))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbLoaiSanPham, 0, 174, Short.MAX_VALUE)
                                .addComponent(cbbChatLieu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbKichThuoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoHet)
                                .addComponent(rdoCon)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin chi tiết", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Mã thuộc tính");

        jLabel14.setText("Tên thuộc tính");

        buttonGroup3.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMauSacMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdoKichThuoc);
        rdoKichThuoc.setText("Kích thước");
        rdoKichThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoKichThuocMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdoChatLieu);
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChatLieuMouseClicked(evt);
            }
        });

        buttonGroup3.add(rdoLoaiSanPham);
        rdoLoaiSanPham.setText("Loại sản phẩm");
        rdoLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoLoaiSanPhamMouseClicked(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton8.setText("Sửa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setText("Mới");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(52, 52, 52)
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(54, 54, 54)
                        .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(rdoMauSac)
                        .addGap(18, 18, 18)
                        .addComponent(rdoKichThuoc)
                        .addGap(18, 18, 18)
                        .addComponent(rdoChatLieu)
                        .addGap(18, 18, 18)
                        .addComponent(rdoLoaiSanPham))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)))
                .addGap(49, 49, 49))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMauSac)
                    .addComponent(rdoKichThuoc)
                    .addComponent(rdoChatLieu)
                    .addComponent(rdoLoaiSanPham))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton8)
                    .addComponent(jButton10))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton11.setText("Tìm kiếm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        tblThuocTinhSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên thuộc tính"
            }
        ));
        tblThuocTinhSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblThuocTinhSanPham);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (rdoMauSac.isSelected() == true) {
            if (getDaTaMauSac() == null) {

            } else {
                JOptionPane.showMessageDialog(this, mauSacServiceInterface.add(getDaTaMauSac()));
                loadTableMauSac();
                loadCombobox();
                clear();
            }

        } else if (rdoKichThuoc.isSelected() == true) {
            if (getDaTaSize() != null) {
                JOptionPane.showMessageDialog(this, sizeServiceInterface.add(getDaTaSize()));
                loadTableSize();
                loadCombobox();
                clear();
            } else {

            }

        } else if (rdoChatLieu.isSelected() == true) {
            if (getDaTaChatLieu() != null) {
                JOptionPane.showMessageDialog(this, chatLieuServiceInterface.add(getDaTaChatLieu()));
                loadTableChatLieu();
                loadCombobox();
                clear();
            } else {

            }

        } else if (rdoLoaiSanPham.isSelected() == true) {
            if (getDaTaLoaiSanPham() != null) {
                JOptionPane.showMessageDialog(this, loaiSanPhamServiceInterface.add(getDaTaLoaiSanPham()));
                loadTableLoaiSanPham();
                loadCombobox();
                clear();
            } else {

            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính sản phẩm để thêm");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblThuocTinhSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhSanPhamMouseClicked
        // TODO add your handling code here:
        loadTextField(tblThuocTinhSanPham.getSelectedRow());
    }//GEN-LAST:event_tblThuocTinhSanPhamMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        if (rdoMauSac.isSelected() == true) {

            if (txtMaThuocTinh.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Chọn bản ghi để sửa");
            } else {
                if (getDaTaMauSac() != null) {
                    Integer maMauSac = Integer.valueOf(txtMaThuocTinh.getText().trim());
                    JOptionPane.showMessageDialog(this, mauSacServiceInterface.update(maMauSac, getDaTaMauSac()));
                    loadTableMauSac();
                    loadCombobox();
                    clear();
                }

            }

        } else if (rdoKichThuoc.isSelected() == true) {

            if (txtMaThuocTinh.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Chọn bản ghi để sửa");
            } else {
                if (getDaTaSize() != null) {
                    Integer maKichThuoc = Integer.valueOf(txtMaThuocTinh.getText().trim());
                    JOptionPane.showMessageDialog(this, sizeServiceInterface.update(maKichThuoc, getDaTaSize()));
                    loadTableSize();
                    loadCombobox();
                    clear();
                }

            }
        } else if (rdoChatLieu.isSelected() == true) {

            if (txtMaThuocTinh.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Chọn bản ghi để sửa");
            } else {
                if (getDaTaChatLieu() != null) {
                    Integer maChatLieu = Integer.valueOf(txtMaThuocTinh.getText().trim());
                    JOptionPane.showMessageDialog(this, chatLieuServiceInterface.update(maChatLieu, getDaTaChatLieu()));
                    loadTableChatLieu();
                    loadCombobox();
                    clear();
                }

            }
        } else if (rdoLoaiSanPham.isSelected() == true) {

            if (txtMaThuocTinh.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Chọn bản ghi để sửa");
            } else {
                if (getDaTaLoaiSanPham() != null) {
                    Integer maLoaiSanPham = Integer.valueOf(txtMaThuocTinh.getText());
                    JOptionPane.showMessageDialog(this, loaiSanPhamServiceInterface.update(maLoaiSanPham, getDaTaLoaiSanPham()));
                    loadTableLoaiSanPham();
                    loadCombobox();
                    clear();
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính sản phẩm để sửa");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        clear();
        
        if(rdoMauSac.isSelected() == true){
            loadTableMauSac();
        }else if(rdoKichThuoc.isSelected() == true) {
            loadTableSize();
        }else if(rdoChatLieu.isSelected() == true){
            loadTableChatLieu();
        }else if(rdoLoaiSanPham.isSelected() == true){
            loadTableLoaiSanPham();
        }
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void rdoMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMauSacMouseClicked
        // TODO add your handling code here:
        loadTableMauSac();
    }//GEN-LAST:event_rdoMauSacMouseClicked

    private void rdoKichThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoKichThuocMouseClicked
        loadTableSize();
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKichThuocMouseClicked

    private void rdoChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChatLieuMouseClicked
        loadTableChatLieu();
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChatLieuMouseClicked

    private void rdoLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoLoaiSanPhamMouseClicked
        loadTableLoaiSanPham();
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoLoaiSanPhamMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        if (rdoMauSac.isSelected() == true) {
            
            if("".equalsIgnoreCase(txtTimKiem.getText().trim())){
                JOptionPane.showMessageDialog(this, "Nhập tên thuộc tính để tìm kiếm");
                clear();
            }else{
                List<MauSac> mauSac = mauSacServiceInterface.getAllForName(txtTimKiem.getText().trim());
                if(mauSac.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Không tìm thầy sản phẩm");
                    clear();
                }else{
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnCount(0);
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
                    for (MauSac ctsp : mauSac) {
                        model.addRow(new Object[]{ctsp.getMaMauSac(), ctsp.getTenMauSac()});
                    }
                    tblThuocTinhSanPham.setModel(model);
                    txtTimKiem.setText("");
                }
            }
            
        } else if (rdoKichThuoc.isSelected() == true) {
            
            if("".equalsIgnoreCase(txtTimKiem.getText().trim())){
                JOptionPane.showMessageDialog(this, "Nhập tên thuộc tính để tìm kiếm");
                clear();
            }else{
                List<Size> mauSac = sizeServiceInterface.getAllForName(txtTimKiem.getText().trim());
                if(mauSac.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Không tìm thầy sản phẩm");
                    clear();
                }else{
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnCount(0);
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
                    for (Size ctsp : mauSac) {
                        model.addRow(new Object[]{ctsp.getMasize(), ctsp.getTenSize()});
                    }
                    tblThuocTinhSanPham.setModel(model);
                    txtTimKiem.setText("");
                }
            }
        } else if (rdoChatLieu.isSelected() == true) {
            
            if("".equalsIgnoreCase(txtTimKiem.getText().trim())){
                JOptionPane.showMessageDialog(this, "Nhập tên thuộc tính để tìm kiếm");
                clear();
            }else{
                List<ChatLieu> mauSac = chatLieuServiceInterface.getAllForName(txtTimKiem.getText().trim());
                if(mauSac.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Không tìm thầy sản phẩm");
                    clear();
                }else{
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnCount(0);
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
                    for (ChatLieu ctsp : mauSac) {
                        model.addRow(new Object[]{ctsp.getMaChatLieu(), ctsp.getTenChatLieu()});
                    }
                    tblThuocTinhSanPham.setModel(model);
                    txtTimKiem.setText("");
                }
            }
            
        } else if (rdoLoaiSanPham.isSelected() == true) {
            
            if("".equalsIgnoreCase(txtTimKiem.getText().trim())){
                JOptionPane.showMessageDialog(this, "Nhập tên thuộc tính để tìm kiếm");
                clear();
            }else{
                List<LoaiSanPham> mauSac = loaiSanPhamServiceInterface.getAllForName(txtTimKiem.getText().trim());
                if(mauSac.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Không tìm thầy sản phẩm");
                    clear();
                }else{
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnCount(0);
                    model.setRowCount(0);
                    model.setColumnIdentifiers(new String[]{"Mã thuộc tính sản phẩm", "tên thuộc tính sản phẩm"});
                    for (LoaiSanPham ctsp : mauSac) {
                        model.addRow(new Object[]{ctsp.getMaLoaiSanPham(), ctsp.getTenLoaiSanPham()});
                    }
                    tblThuocTinhSanPham.setModel(model);
                    txtTimKiem.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính sản phẩm để tìm kiếm");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SanPham sp = getDaTaSanPham();

        if (sp == null) {
            //không làm gì cả
        } else {
            if (!sp.isTinhTrang()) {
                JOptionPane.showMessageDialog(this, "Trạng thái không được chọn hết");
                rdoCon.setSelected(true);
            } else {
                JOptionPane.showMessageDialog(this, sanPhamServiceInterface.add(sp));
                loadTableSanPham();
                clear();
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        if ("".equalsIgnoreCase(txtMaSanPham.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm để sửa");

        } else {
            Integer maSP = Integer.valueOf(txtMaSanPham.getText().trim());
            SanPham sanPham = getDaTaSanPham();
            if (sanPham == null) {
            } else {

                JOptionPane.showMessageDialog(this, sanPhamServiceInterface.update(maSP, sanPham));
                clear();
                loadTableSanPham();

            }
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbtSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tbtSanPham.getSelectedRow();
        int maSanPham = (int) tbtSanPham.getValueAt(index, 0);
        SanPham sanPham = sanPhamServiceInterface.getOne(maSanPham);
        loadTextFieldSanPham(sanPham);
    }//GEN-LAST:event_tbtSanPhamMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        clear();
        loadTableSanPham();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        if ("".equalsIgnoreCase(txtMaSanPham.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        } else {
            Integer maSP = Integer.valueOf(txtMaSanPham.getText());
            JOptionPane.showMessageDialog(this, sanPhamServiceInterface.delete(maSP));
            clear();
            loadTableSanPham();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if("".equalsIgnoreCase(txtTimKiemSanPham.getText().trim())){
            JOptionPane.showMessageDialog(this, "Nhập tên sản phẩm để tìm kiếm");
            txtTimKiemSanPham.setText("");
        }else{
            String tenSanPham = txtTimKiemSanPham.getText().trim();
            List<SanPham> list = sanPhamServiceInterface.getAllForName(tenSanPham);
            
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
                txtTimKiemSanPham.setText("");
            }else{
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnCount(0);
                model.setRowCount(0);
                model.setColumnIdentifiers(new String[]{"Mã sản phẩm", "tên sản phẩm",
                    "loại sản phẩm", "đơn giá", "số lượng", "màu sắc", "sire", "chất liệu",
                    "Mô tả",
                    "trạng thái"});
                for (SanPham ctsp : list) {
                    model.addRow(new Object[]{ctsp.getMaSanPham(), ctsp.getTenSanPham(),
                        ctsp.getLoaiSanPham().getTenLoaiSanPham(),
                        ctsp.getGiaBan(),
                        ctsp.getSoLuong(),
                        ctsp.getMauSac().getTenMauSac(),
                        ctsp.getSize().getTenSize(),
                        ctsp.getChatLieu().getTenChatLieu(),
                       
                        ctsp.getMoTa(),
                        ctsp.isTinhTrang()? "còn" : "hết"});
                }
                tbtSanPham.setModel(model);
                txtTimKiemSanPham.setText("");
            }
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbbMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMauSacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<ChatLieuViewModel> cbbChatLieu;
    private javax.swing.JComboBox<SizeViewModel> cbbKichThuoc;
    private javax.swing.JComboBox<LoaiSanPhamViewModel> cbbLoaiSanPham;
    private javax.swing.JComboBox<MauSacViewModel> cbbMauSac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JRadioButton rdoKichThuoc;
    private javax.swing.JRadioButton rdoLoaiSanPham;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JTable tblThuocTinhSanPham;
    private javax.swing.JTable tbtSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaThuocTinh;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemSanPham;
    // End of variables declaration//GEN-END:variables
}
