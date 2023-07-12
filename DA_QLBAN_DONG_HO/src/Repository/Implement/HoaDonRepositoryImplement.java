/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.HoaDon;
import DomainModel.KhachHang;
import DomainModel.NhanVien;
import Repository.Interface.HoaDonRepositoryInterface;
import Utility.DBContext;
import ViewModel.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class HoaDonRepositoryImplement implements HoaDonRepositoryInterface {

    private static Connection con = Utility.DBContext.getConnection();

    @Override
    public List<HoaDon> getAllHD() {
        List<HoaDon> listHD = new ArrayList<>();
        String query = "SELECT   hd.MAHOADON, hd.MANHANVIEN,  hd.NGAYTAO,hd.TRANGTHAI\n"
                + "FROM      dbo.HOADON hd INNER JOIN\n"
                + "                         dbo.NHANVIEN nv ON hd.MANHANVIEN = nv.MANHANVIEN\n"
                + "			WHERE hd.TRANGTHAI =0 OR hd.TRANGTHAI=1 ";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(Integer.parseInt(rs.getString("maHoaDon")));
                //
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(Integer.parseInt(rs.getString(2)));
                hoaDon.setNhanVien(nv);
                //
                hoaDon.setNgayTao(rs.getDate(3));
                //
                //
                hoaDon.setTrangThai(rs.getInt(4));
                listHD.add(hoaDon);
                System.out.println(hoaDon.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    @Override
    public Boolean addHD(HoaDon hoaDon) {
        String sql = "INSERT INTO [dbo].[HOADON]\n"
                + "           ([MANHANVIEN]\n"
                + "           ,[NGAYTAO]\n"
                + "           ,[TRANGTHAI]\n"
                + "		   )\n"
                + "\n"
                + "     VALUES (?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, hoaDon.getNhanVien().getMaNhanVien());
            pr.setDate(2, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            pr.setInt(3, hoaDon.getTrangThai());
            pr.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<HoaDon> getHDChuaThanhToan(Integer trangThai) {
        List<HoaDon> list = new ArrayList<>();
        String query = "SELECT   hd.MAHOADON, hd.MANHANVIEN,  hd.NGAYTAO,hd.TRANGTHAI\n"
                + "FROM      dbo.HOADON hd INNER JOIN\n"
                + "                         dbo.NHANVIEN nv ON hd.MANHANVIEN = nv.MANHANVIEN\n"
                + "						 Where hd.TRANGTHAI=?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, trangThai);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(Integer.parseInt(rs.getString("maHoaDon")));
                //
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(Integer.parseInt(rs.getString(2)));
                hoaDon.setNhanVien(nv);
                //
                hoaDon.setNgayTao(rs.getDate(3));
                //
                //
                hoaDon.setTrangThai(rs.getInt(4));
                list.add(hoaDon);
                System.out.println(hoaDon.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HoaDon> getHDThanhToan(Integer trangThai) {
        List<HoaDon> list = new ArrayList<>();
        String query = "SELECT   hd.MAHOADON, hd.MANHANVIEN,  hd.NGAYTAO,hd.TRANGTHAI\n"
                + "FROM      dbo.HOADON hd INNER JOIN\n"
                + "                         dbo.NHANVIEN nv ON hd.MANHANVIEN = nv.MANHANVIEN\n"
                + "						 Where hd.TRANGTHAI=?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, trangThai);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(Integer.parseInt(rs.getString("maHoaDon")));
                //
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(Integer.parseInt(rs.getString(2)));
                hoaDon.setNhanVien(nv);
                //
                hoaDon.setNgayTao(rs.getDate(3));
                //
                //
                hoaDon.setTrangThai(rs.getInt(4));
                list.add(hoaDon);
                System.out.println(hoaDon.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean HuyThanhToan(String mahd, int trangThai) {
        List<HoaDon> list = new ArrayList<>();
        String query = "UPDATE [dbo].[HOADON]\n"
                + "   SET\n"
                + "      [TRANGTHAI] = (?)\n"
                + " WHERE HOADON.MAHOADON = (?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, trangThai);
            pr.setString(2, mahd);
            ResultSet rs = pr.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ThanhToan(String mahd, int trangThai, Double TongTien, Double tienKhachTra, Double tienThua, Date ngayThanhToan) {
        List<HoaDon> list = new ArrayList<>();
        String query = "UPDATE [dbo].[HOADON]\n"
                + "   SET\n"
                + "      [TONGTIEN] = (?)\n"
                + "      ,[TRANGTHAI] = (?)\n"
                + "      ,[TIENKHACHTRA] = (?)\n"
                + "      ,[TIENTHUA] = (?)\n"
                + "      ,[NGAYTHANHTOAN] = (?)\n"
                + " WHERE HOADON.MAHOADON = (?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setDouble(1, TongTien);
            pr.setInt(2, trangThai);
            pr.setDouble(3, tienKhachTra);
            pr.setDouble(4, tienThua);
            pr.setDate(5, new java.sql.Date(ngayThanhToan.getTime()));
            pr.setString(6, mahd);
            ResultSet rs = pr.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<HoaDonViewModel> getHDdaThanhToan() {
        List<HoaDonViewModel> listHD = new ArrayList<>();
        String query = "SELECT    HOADON.MAHOADON, HOADON.MANHANVIEN, NHANVIEN.HOTEN,  HOADON.NGAYTAO, HOADON.TONGTIEN,HOADON.TRANGTHAI, HOADON.NGAYTHANHTOAN\n"
                + "FROM            dbo.HOADON INNER JOIN\n"
                + "                         dbo.NHANVIEN ON dbo.HOADON.MANHANVIEN = dbo.NHANVIEN.MANHANVIEN\n"
                + "WHERE HOADON.TRANGTHAI = 2 ";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hoaDon = new HoaDonViewModel();
                hoaDon.setMaHoaDon(Integer.parseInt(rs.getString(1)));
                //
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(Integer.parseInt(rs.getString(2)));
                hoaDon.setNhanVien(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                //
                hoaDon.setNgayTao(rs.getDate(4));
                //
                //
                hoaDon.setTongTien(Double.parseDouble(rs.getString("TONGTIEN")));
                hoaDon.setTrangThai(rs.getInt("TRANGTHAI"));
                hoaDon.setNgayTao(rs.getDate(7));
                listHD.add(hoaDon);
                System.out.println(hoaDon.toString());
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

}
