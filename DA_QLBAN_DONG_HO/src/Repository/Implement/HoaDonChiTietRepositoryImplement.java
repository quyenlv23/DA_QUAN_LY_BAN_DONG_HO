/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.HoaDon;
import DomainModel.HoaDonChiTiet;
import DomainModel.NhanVien;
import DomainModel.SanPham;
import Repository.Interface.HoaDonChiTietRepositoryInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mr.quyen
 */
public class HoaDonChiTietRepositoryImplement implements HoaDonChiTietRepositoryInterface {

    private static Connection con = Utility.DBContext.getConnection();

    @Override
    public List<HoaDonChiTiet> getHDCT(String mahd) {
        List<HoaDonChiTiet> listhdct = new ArrayList<>();
        String query = "SELECT      sp.TENSANPHAM , hdct.MAHOADONCHITIET, hd.MAHOADON, sp.MASANPHAM, hdct.SOLUONG, hdct.THANHTIEN\n"
                + "FROM            dbo.HOADONCHITIET hdct INNER JOIN\n"
                + "                         dbo.SANPHAM sp ON hdct.MASANPHAM =sp.MASANPHAM INNER JOIN\n"
                + "                         dbo.HOADON hd  ON hdct.MAHOADON = hd.MAHOADON\n"
                + "WHERE hd.MAHOADON=?";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, String.valueOf(mahd));
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(Integer.parseInt(rs.getString("MAHOADON")));
                hdct.setHoaDon(hoaDon);

                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(Integer.parseInt(rs.getString("MASANPHAM")));
                sanPham.setTenSanPham(rs.getString("TENSANPHAM"));
                hdct.setSanPham(sanPham);

                hdct.setSoLuong(Integer.parseInt(rs.getString("SOLUONG")));
                hdct.setDonGia(Double.parseDouble(rs.getString("THANHTIEN")));
                listhdct.add(hdct);

                System.out.println(hdct.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listhdct;
    }

    @Override
    public Boolean addHDCT(HoaDonChiTiet hoaDonChiTiet) {
        String sql = "INSERT INTO [dbo].[HOADONCHITIET]\n"
                + "           ([MAHOADON]\n"
                + "           ,[MASANPHAM]\n"
                + "           ,[SOLUONG]\n"
                + "           ,[THANHTIEN])\n"
                + "     VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, hoaDonChiTiet.getHoaDon().getMaHoaDon());
            pr.setInt(2, hoaDonChiTiet.getSanPham().getMaSanPham());
            pr.setInt(3, hoaDonChiTiet.getSoLuong());
            pr.setDouble(4, hoaDonChiTiet.getDonGia());

            pr.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean removeHDCT(String mahd) {
        String query = "DELETE FROM [dbo].[HOADONCHITIET]\n"
                + "      WHERE MAHOADON = (?)";
        try {
            PreparedStatement pr =  con.prepareStatement(query);
            pr.setString(1, mahd);
            pr.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
             
        }
        return false;
    }

}
