/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.ChatLieu;
import DomainModel.LoaiSanPham;
import DomainModel.MauSac;
import DomainModel.SanPham;
import DomainModel.Size;
import Repository.Interface.SanPhamRepositoryInterface;
import Service.Implement.ChatLieuServiceImplement;
import Service.Implement.LoaiSanPhamServiceImplement;
import Service.Implement.MauSacServiceImplement;
import Service.Implement.SizeServiceImplement;
import Service.Interface.ChatLieuServiceInterface;
import Service.Interface.LoaiSanPhamServiceInterface;
import Service.Interface.MauSacServiceInterface;
import Service.Interface.SizeServiceInterface;
import Utility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class SanPhamRepositoryImplement implements SanPhamRepositoryInterface {

    private static Connection con = Utility.DBContext.getConnection();
    final MauSacServiceInterface mauSacServiceInterface = new MauSacServiceImplement();
    final ChatLieuServiceInterface chatLieuServiceInterface = new ChatLieuServiceImplement();
    final LoaiSanPhamServiceInterface loaiSanPhamServiceInterface = new LoaiSanPhamServiceImplement();
    final SizeServiceInterface sizeServiceInterface = new SizeServiceImplement();

    @Override
    public List<SanPham> getListSP() {
        List<SanPham> listsp = new ArrayList<>();
        String query = "SELECT sp.MASANPHAM , sp.TENSANPHAM ,  sp.MAMAU,mau.MAU, sp.MACHATLIEU,cl.CHATLIEU, sp.MALOAISANPHAM,loai.LOAI, sp.MASIZE , size.SIZE , sp.SOLUONG , sp.TINHTRANG, sp.GIABAN \n"
                + "FROM            dbo.SANPHAM sp INNER JOIN\n"
                + "                         dbo.SIZE size ON sp.MASIZE = size.MASIZE INNER JOIN\n"
                + "                         dbo.CHATLIEU cl ON sp.MACHATLIEU = cl.MACHATLIEU INNER JOIN\n"
                + "                         dbo.LOAISANPHAM  loai ON sp.MALOAISANPHAM = loai.MALOAISANPHAM INNER JOIN\n"
                + "                         dbo.MAUSAC mau ON sp.MAMAU = mau.MAMAU "
                + "                      WHERE sp.TINHTRANG ='true'";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(Integer.parseInt(rs.getString("MASANPHAM")));
                sp.setTenSanPham(rs.getString("TENSANPHAM"));
                MauSac mauSac = new MauSac();
                mauSac.setMaMauSac(Integer.parseInt(rs.getString("MAMAU")));
                mauSac.setTenMauSac(rs.getString("MAU"));
                sp.setMauSac(mauSac);

                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setMaChatLieu(Integer.parseInt(rs.getString("MACHATLIEU")));
                chatLieu.setTenChatLieu(rs.getString("CHATLIEU"));
                sp.setChatLieu(chatLieu);

                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(Integer.parseInt(rs.getString("MALOAISANPHAM")));
                loaiSanPham.setTenLoaiSanPham(rs.getString("LOAI"));
                sp.setLoaiSanPham(loaiSanPham);

                Size size = new Size();
                size.setMasize(Integer.parseInt(rs.getString("MASIZE")));
                size.setTenSize(rs.getString("SIZE"));
                sp.setSize(size);

                sp.setSoLuong(Integer.parseInt(rs.getString("SOLUONG")));
                sp.setGiaBan(Double.parseDouble(rs.getString("GIABAN")));
                sp.setTinhTrang(Boolean.parseBoolean(rs.getString("TINHTRANG")));

                listsp.add(sp);
                System.out.println(sp.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsp;
    }

    @Override
    public boolean add(SanPham sanPham) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         INSERT INTO [dbo].[SANPHAM]
                                    ([MAMAU]
                                    ,[MACHATLIEU]
                                    ,[MALOAISANPHAM]
                                    ,[MASIZE]
                                    ,[MAMAY]
                                    ,[GIANHAP]
                                    ,[GIABAN]
                                    ,[TINHTRANG]
                                    ,[SOLUONG]
                                    ,[MOTA]
                                    ,[TENSANPHAM])
                              VALUES
                                    (?
                                    ,?
                                    ,?
                                    ,?
                                    ,?
                                    ,?
                                    ,?
                                    ,?
                                    ,?
                                    ,?
                                    ,?)""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, sanPham.getMauSac().getMaMauSac());
            ps.setInt(2, sanPham.getChatLieu().getMaChatLieu());
            ps.setInt(3, sanPham.getLoaiSanPham().getMaLoaiSanPham());
            ps.setInt(4, sanPham.getSize().getMasize());
            ps.setString(5, sanPham.getMaMay());
            ps.setDouble(6, sanPham.getGiaNhap());
            ps.setDouble(7, sanPham.getGiaBan());
            ps.setString(8, String.valueOf(sanPham.isTinhTrang()));
            ps.setInt(9, sanPham.getSoLuong());
            ps.setString(10, sanPham.getMoTa());
            ps.setString(11, sanPham.getTenSanPham());

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public List<SanPham> getAll() {
        try {
            List<SanPham> dsMauSac = new ArrayList();

            String sql = """
                         SELECT [MASANPHAM]
                                 ,[MAMAU]
                                 ,[MACHATLIEU]
                                 ,[MALOAISANPHAM]
                                 ,[MASIZE]
                                 ,[MAMAY]
                                 ,[GIANHAP]
                                 ,[GIABAN]
                                 ,[TINHTRANG]
                                 ,[SOLUONG]
                                 ,[MOTA]
                                 ,[TENSANPHAM]
                             FROM [dbo].[SANPHAM]""";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer maSP = rs.getInt(1);

                Integer maMau = rs.getInt(2);
                Integer maChatLieu = rs.getInt(3);
                Integer maLoai = rs.getInt(4);
                Integer maSize = rs.getInt(5);

                String maMay = rs.getString(6);

                Double giaNhap = rs.getDouble(7);
                Double giaBan = rs.getDouble(8);

                String tinhTrang = rs.getString(9);

                Integer soLuong = rs.getInt(10);

                String moTa = rs.getString(11);

                String tenSP = rs.getString(12);

                SanPham mauSac = new SanPham();

                //tạo đối tượng
                mauSac.setMaSanPham(maSP);

                MauSac mauSac1 = mauSacServiceInterface.getOne(maMau);
                mauSac.setMauSac(mauSac1);

                ChatLieu chatLieu = chatLieuServiceInterface.getOne(maChatLieu);
                mauSac.setChatLieu(chatLieu);

                LoaiSanPham loaiSanPham = loaiSanPhamServiceInterface.getOne(maLoai);
                mauSac.setLoaiSanPham(loaiSanPham);

                Size size = sizeServiceInterface.getOne(maSize);
                mauSac.setSize(size);

                mauSac.setMaMay(maMay);

                mauSac.setGiaNhap(giaNhap);
                mauSac.setGiaBan(giaBan);
                mauSac.setTinhTrang(Boolean.parseBoolean(tinhTrang));
                mauSac.setSoLuong(soLuong);
                mauSac.setMoTa(moTa);
                mauSac.setTenSanPham(tenSP);

                //add sp vào danh sách
                dsMauSac.add(mauSac);
            }

            return dsMauSac;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Integer maSanPham, SanPham sanPham) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         UPDATE [dbo].[SANPHAM]
                            SET [MAMAU] = ?
                               ,[MACHATLIEU] = ?
                               ,[MALOAISANPHAM] = ?
                               ,[MASIZE] = ?
                               ,[MAMAY] = ?
                               ,[GIANHAP] = ?
                               ,[GIABAN] = ?
                               ,[TINHTRANG] = ?
                               ,[SOLUONG] = ?
                               ,[MOTA] = ?
                               ,[TENSANPHAM] = ?
                          WHERE MASANPHAM = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, sanPham.getMauSac().getMaMauSac());
            ps.setInt(2, sanPham.getChatLieu().getMaChatLieu());
            ps.setInt(3, sanPham.getLoaiSanPham().getMaLoaiSanPham());
            ps.setInt(4, sanPham.getSize().getMasize());
            ps.setString(5, sanPham.getMaMay());
            ps.setDouble(6, sanPham.getGiaNhap());
            ps.setDouble(7, sanPham.getGiaBan());
            ps.setString(8, String.valueOf(sanPham.isTinhTrang()));
            ps.setInt(9, sanPham.getSoLuong());
            ps.setString(10, sanPham.getMoTa());
            ps.setString(11, sanPham.getTenSanPham());
            ps.setInt(12, maSanPham);

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public SanPham getOne(Integer maSanPham) {
        String sql = """
                     SELECT [MASANPHAM]
                           ,[MAMAU]
                           ,[MACHATLIEU]
                           ,[MALOAISANPHAM]
                           ,[MASIZE]
                           ,[MAMAY]
                           ,[GIANHAP]
                           ,[GIABAN]
                           ,[TINHTRANG]
                           ,[SOLUONG]
                           ,[MOTA]
                           ,[TENSANPHAM]
                       FROM [dbo].[SANPHAM]
                       WHERE MASANPHAM = ?""";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, maSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer maSP = rs.getInt(1);

                Integer maMau = rs.getInt(2);
                Integer maChatLieu = rs.getInt(3);
                Integer maLoai = rs.getInt(4);
                Integer maSize = rs.getInt(5);

                String maMay = rs.getString(6);

                Double giaNhap = rs.getDouble(7);
                Double giaBan = rs.getDouble(8);

                String tinhTrang = rs.getString(9);

                Integer soLuong = rs.getInt(10);

                String moTa = rs.getString(11);

                String tenSP = rs.getString(12);

                SanPham mauSac = new SanPham();

                mauSac.setMaSanPham(maSP);

                MauSac mauSac1 = mauSacServiceInterface.getOne(maMau);
                mauSac.setMauSac(mauSac1);

                ChatLieu chatLieu = chatLieuServiceInterface.getOne(maChatLieu);
                mauSac.setChatLieu(chatLieu);

                LoaiSanPham loaiSanPham = loaiSanPhamServiceInterface.getOne(maLoai);
                mauSac.setLoaiSanPham(loaiSanPham);

                Size size = sizeServiceInterface.getOne(maSize);
                mauSac.setSize(size);

                mauSac.setMaMay(maMay);

                mauSac.setGiaNhap(giaNhap);
                mauSac.setGiaBan(giaBan);
                mauSac.setTinhTrang(Boolean.parseBoolean(tinhTrang));
                mauSac.setSoLuong(soLuong);
                mauSac.setMoTa(moTa);
                mauSac.setTenSanPham(tenSP);

//                sanPham1.setTrangThai(rs.getInt("TrangThai"));
//                products.add(sanPham1);
                return mauSac;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        return (BHSanPhamVM) products;
        return null;
    }

    @Override
    public Integer delete(Integer maSanPham) {
        String sql = """
                     UPDATE [dbo].[SANPHAM]
                        SET [TINHTRANG] = N'false'
                      WHERE MASANPHAM = ? """;
        try {
            Connection connection = DBContext.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maSanPham);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<SanPham> getAllForName(String tenSanPham) {
        try {
            List<SanPham> dsMauSac = new ArrayList();

            String sql = """
                         SELECT [MASANPHAM]
                                   ,[MAMAU]
                                   ,[MACHATLIEU]
                                   ,[MALOAISANPHAM]
                                   ,[MASIZE]
                                   ,[MAMAY]
                                   ,[GIANHAP]
                                   ,[GIABAN]
                                   ,[TINHTRANG]
                                   ,[SOLUONG]
                                   ,[MOTA]
                                   ,[TENSANPHAM]
                               FROM [dbo].[SANPHAM]
                               WHERE TENSANPHAM like ?""";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tenSanPham + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer maSP = rs.getInt(1);

                Integer maMau = rs.getInt(2);
                Integer maChatLieu = rs.getInt(3);
                Integer maLoai = rs.getInt(4);
                Integer maSize = rs.getInt(5);

                String maMay = rs.getString(6);

                Double giaNhap = rs.getDouble(7);
                Double giaBan = rs.getDouble(8);

                String tinhTrang = rs.getString(9);

                Integer soLuong = rs.getInt(10);

                String moTa = rs.getString(11);

                String tenSP = rs.getString(12);

                SanPham mauSac = new SanPham();

                //tạo đối tượng
                mauSac.setMaSanPham(maSP);

                MauSac mauSac1 = mauSacServiceInterface.getOne(maMau);
                mauSac.setMauSac(mauSac1);

                ChatLieu chatLieu = chatLieuServiceInterface.getOne(maChatLieu);
                mauSac.setChatLieu(chatLieu);

                LoaiSanPham loaiSanPham = loaiSanPhamServiceInterface.getOne(maLoai);
                mauSac.setLoaiSanPham(loaiSanPham);

                Size size = sizeServiceInterface.getOne(maSize);
                mauSac.setSize(size);

                mauSac.setMaMay(maMay);

                mauSac.setGiaNhap(giaNhap);
                mauSac.setGiaBan(giaBan);
                mauSac.setTinhTrang(Boolean.parseBoolean(tinhTrang));
                mauSac.setSoLuong(soLuong);
                mauSac.setMoTa(moTa);
                mauSac.setTenSanPham(tenSP);

                //add sp vào danh sách
                dsMauSac.add(mauSac);
            }

            return dsMauSac;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPham> locMauSac(Integer id) {

        List<SanPham> listsp = new ArrayList<>();
        String query = "SELECT sp.MASANPHAM , sp.TENSANPHAM ,  sp.MAMAU,mau.MAU, sp.MACHATLIEU,cl.CHATLIEU, sp.MALOAISANPHAM,loai.LOAI, sp.MASIZE , size.SIZE , sp.SOLUONG , sp.TINHTRANG, sp.GIABAN \n"
                + "FROM            dbo.SANPHAM sp INNER JOIN\n"
                + "                         dbo.SIZE size ON sp.MASIZE = size.MASIZE INNER JOIN\n"
                + "                         dbo.CHATLIEU cl ON sp.MACHATLIEU = cl.MACHATLIEU INNER JOIN\n"
                + "                         dbo.LOAISANPHAM  loai ON sp.MALOAISANPHAM = loai.MALOAISANPHAM INNER JOIN\n"
                + "                         dbo.MAUSAC mau ON sp.MAMAU = mau.MAMAU "
                + "                      WHERE sp.TINHTRANG ='true' and sp.MAMAU =(?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(Integer.parseInt(rs.getString("MASANPHAM")));
                sp.setTenSanPham(rs.getString("TENSANPHAM"));
                MauSac mauSac = new MauSac();
                mauSac.setMaMauSac(Integer.parseInt(rs.getString("MAMAU")));
                mauSac.setTenMauSac(rs.getString("MAU"));
                sp.setMauSac(mauSac);

                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setMaChatLieu(Integer.parseInt(rs.getString("MACHATLIEU")));
                chatLieu.setTenChatLieu(rs.getString("CHATLIEU"));
                sp.setChatLieu(chatLieu);

                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(Integer.parseInt(rs.getString("MALOAISANPHAM")));
                loaiSanPham.setTenLoaiSanPham(rs.getString("LOAI"));
                sp.setLoaiSanPham(loaiSanPham);

                Size size = new Size();
                size.setMasize(Integer.parseInt(rs.getString("MASIZE")));
                size.setTenSize(rs.getString("SIZE"));
                sp.setSize(size);

                sp.setSoLuong(Integer.parseInt(rs.getString("SOLUONG")));
                sp.setGiaBan(Double.parseDouble(rs.getString("GIABAN")));
                sp.setTinhTrang(Boolean.parseBoolean(rs.getString("TINHTRANG")));

                listsp.add(sp);
                System.out.println(sp.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsp;
    }

    @Override
    public List<SanPham> locLoai(String tenloai) {
        List<SanPham> listsp = new ArrayList<>();
        String query = "SELECT sp.MASANPHAM , sp.TENSANPHAM ,  sp.MAMAU,mau.MAU, sp.MACHATLIEU,cl.CHATLIEU, sp.MALOAISANPHAM,loai.LOAI, sp.MASIZE , size.SIZE , sp.SOLUONG , sp.TINHTRANG, sp.GIABAN \n"
                + "FROM            dbo.SANPHAM sp INNER JOIN\n"
                + "                         dbo.SIZE size ON sp.MASIZE = size.MASIZE INNER JOIN\n"
                + "                         dbo.CHATLIEU cl ON sp.MACHATLIEU = cl.MACHATLIEU INNER JOIN\n"
                + "                         dbo.LOAISANPHAM  loai ON sp.MALOAISANPHAM = loai.MALOAISANPHAM INNER JOIN\n"
                + "                         dbo.MAUSAC mau ON sp.MAMAU = mau.MAMAU "
                + "                      WHERE sp.TINHTRANG ='true' and loai.LOAI=(?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, tenloai);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(Integer.parseInt(rs.getString("MASANPHAM")));
                sp.setTenSanPham(rs.getString("TENSANPHAM"));
                MauSac mauSac = new MauSac();
                mauSac.setMaMauSac(Integer.parseInt(rs.getString("MAMAU")));
                mauSac.setTenMauSac(rs.getString("MAU"));
                sp.setMauSac(mauSac);

                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setMaChatLieu(Integer.parseInt(rs.getString("MACHATLIEU")));
                chatLieu.setTenChatLieu(rs.getString("CHATLIEU"));
                sp.setChatLieu(chatLieu);

                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(Integer.parseInt(rs.getString("MALOAISANPHAM")));
                loaiSanPham.setTenLoaiSanPham(rs.getString("LOAI"));
                sp.setLoaiSanPham(loaiSanPham);

                Size size = new Size();
                size.setMasize(Integer.parseInt(rs.getString("MASIZE")));
                size.setTenSize(rs.getString("SIZE"));
                sp.setSize(size);

                sp.setSoLuong(Integer.parseInt(rs.getString("SOLUONG")));
                sp.setGiaBan(Double.parseDouble(rs.getString("GIABAN")));
                sp.setTinhTrang(Boolean.parseBoolean(rs.getString("TINHTRANG")));

                listsp.add(sp);
                System.out.println(sp.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsp;
    }

    @Override
    public Boolean updateSoLuong(Integer maSP, Integer soLuong) {
        String query = "UPDATE [dbo].[SANPHAM]\n"
                + "   SET\n"
                + "      [SOLUONG] = (?)\n"
                + " WHERE SANPHAM.MASANPHAM = (?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, soLuong);
            pr.setInt(2, maSP);
            ResultSet rs = pr.executeQuery();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    return updateSoLuong(maSP, soLuong);
    }

}
