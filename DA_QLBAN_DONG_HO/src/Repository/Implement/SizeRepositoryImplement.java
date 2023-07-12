/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.Size;
import Repository.Interface.SizeRepositoryInterface;
import Utility.DBContext;
import ViewModel.SizeViewModel;
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
public class SizeRepositoryImplement  implements SizeRepositoryInterface{
    public static Connection connection = DBContext.getConnection();

    @Override
    public List<Size> getAll() {
        try {
            List<Size> dsSizes = new ArrayList();

            String sql = """
                         SELECT [MASIZE]
                               ,[SIZE]
                           FROM [dbo].[SIZE]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                Size size = new Size();

                size.setMasize(ma);
                size.setTenSize(ten);
                dsSizes.add(size);
            }

            return dsSizes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Size size) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         INSERT INTO [dbo].[SIZE]
                                    ([SIZE])
                              VALUES
                                    (?)""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, size.getTenSize());

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(Integer maSize, Size size) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         UPDATE [dbo].[SIZE]
                            SET [SIZE] = ?
                          WHERE [MASIZE] = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, size.getTenSize());
            ps.setInt(2, maSize);

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Size getOne(Integer maSize) {
        String sql = "SELECT [MASIZE]\n"
                + "      ,[SIZE]\n"
                + "  FROM [dbo].[SIZE]\n"
                + "  WHERE [dbo].[SIZE].MASIZE = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, maSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size size = new Size();
                size.setMasize(rs.getInt("MASIZE"));
                size.setTenSize(rs.getString("SIZE"));

//                sanPham1.setTrangThai(rs.getInt("TrangThai"));
//                products.add(sanPham1);
                return size;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        return (BHSanPhamVM) products;
        return null;
    }

    @Override
    public List<SizeViewModel> getAllForCBB() {
        try {
            List<SizeViewModel> dsSizes = new ArrayList();

            String sql = """
                         SELECT [MASIZE]
                               ,[SIZE]
                           FROM [dbo].[SIZE]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                SizeViewModel size = new SizeViewModel();

                size.setMasize(ma);
                size.setTenSize(ten);
                dsSizes.add(size);
            }

            return dsSizes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Size> getAllForName(String tenSize) {
        try {
            List<Size> dsSizes = new ArrayList();

            String sql = """
                         SELECT [MASIZE]
                               ,[SIZE]
                           FROM [dbo].[SIZE]
                           WHERE SIZE LIKE ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+tenSize+"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                Size size = new Size();

                size.setMasize(ma);
                size.setTenSize(ten);
                dsSizes.add(size);
            }

            return dsSizes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
