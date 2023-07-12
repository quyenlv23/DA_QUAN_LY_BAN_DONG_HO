/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.LoaiSanPham;
import Repository.Interface.LoaiSanPhamRepositoryInterface;
import Utility.DBContext;
import ViewModel.LoaiSanPhamViewModel;
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
public class LoaiSanPhamRepositoryImplement implements LoaiSanPhamRepositoryInterface{
     public static Connection connection = DBContext.getConnection();

    @Override
    public List<LoaiSanPham> getAll() {
        try {
            List<LoaiSanPham> dsLoaiSanPhams = new ArrayList();

            String sql = """
                         SELECT [MALOAISANPHAM]
                               ,[LOAI]
                           FROM [dbo].[LOAISANPHAM]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                LoaiSanPham loaiSanPham = new LoaiSanPham();

                loaiSanPham.setMaLoaiSanPham(ma);
                loaiSanPham.setTenLoaiSanPham(ten);
                dsLoaiSanPhams.add(loaiSanPham);
            }

            return dsLoaiSanPhams;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(LoaiSanPham loaiSanPham) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = "INSERT INTO [dbo].[LOAISANPHAM]\n"
                    + "           ([LOAI])\n"
                    + "     VALUES\n"
                    + "           (?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, loaiSanPham.getTenLoaiSanPham());

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         UPDATE [dbo].[LOAISANPHAM]
                              SET [LOAI] = ?
                            WHERE [MALOAISANPHAM] = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, loaiSanPham.getTenLoaiSanPham());
            ps.setInt(2, maLoaiSanPham);

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public LoaiSanPham getOne(Integer maLoaiSanPham) {
        String sql = "SELECT [MALOAISANPHAM]\n"
                + "      ,[LOAI]\n"
                + "  FROM [dbo].[LOAISANPHAM]\n"
                + "  WHERE [dbo].[LOAISANPHAM].MALOAISANPHAM = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, maLoaiSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(rs.getInt("MALOAISANPHAM"));
                loaiSanPham.setTenLoaiSanPham(rs.getString("LOAI"));

//                sanPham1.setTrangThai(rs.getInt("TrangThai"));
//                products.add(sanPham1);
                return loaiSanPham;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        return (BHSanPhamVM) products;
        return null;
    }

    @Override
    public List<LoaiSanPhamViewModel> getAllForCBB() {
        try {
            List<LoaiSanPhamViewModel> dsLoaiSanPhams = new ArrayList();

            String sql = """
                         SELECT [MALOAISANPHAM]
                               ,[LOAI]
                           FROM [dbo].[LOAISANPHAM]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                LoaiSanPhamViewModel loaiSanPham = new LoaiSanPhamViewModel();

                loaiSanPham.setMaLoaiSanPham(ma);
                loaiSanPham.setTenLoaiSanPham(ten);
                dsLoaiSanPhams.add(loaiSanPham);
            }

            return dsLoaiSanPhams;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LoaiSanPham> getAllForName(String tenLoaiSanPham) {
        try {
            List<LoaiSanPham> dsLoaiSanPhams = new ArrayList();

            String sql = """
                         SELECT [MALOAISANPHAM]
                               ,[LOAI]
                           FROM [dbo].[LOAISANPHAM]
                           WHERE LOAI LIKE ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+tenLoaiSanPham+"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                LoaiSanPham loaiSanPham = new LoaiSanPham();

                loaiSanPham.setMaLoaiSanPham(ma);
                loaiSanPham.setTenLoaiSanPham(ten);
                dsLoaiSanPhams.add(loaiSanPham);
            }

            return dsLoaiSanPhams;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
