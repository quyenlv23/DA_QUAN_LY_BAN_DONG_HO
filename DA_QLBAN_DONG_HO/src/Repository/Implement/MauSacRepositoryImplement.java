/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.MauSac;
import Repository.Interface.MauSacRepositoryInterface;
import Utility.DBContext;
import ViewModel.MauSacViewModel;
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
public class MauSacRepositoryImplement implements MauSacRepositoryInterface{
     public static Connection connection = DBContext.getConnection();

    @Override
    public List<MauSac> getAll() {
        try {
            List<MauSac> dsMauSac = new ArrayList();

            String sql = """
                         SELECT [MAMAU]
                               ,[MAU]
                           FROM [dbo].[MAUSAC]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                MauSac mauSac = new MauSac();

                mauSac.setMaMauSac(ma);
                mauSac.setTenMauSac(ten);
                dsMauSac.add(mauSac);
            }

            return dsMauSac;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(MauSac mauSac) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = "INSERT INTO [dbo].[MAUSAC]\n"
                    + "                       ([MAU])\n"
                    + "                       VALUES\n"
                    + "                       (?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, mauSac.getTenMauSac());

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(Integer maMauSac, MauSac mauSac) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         UPDATE [dbo].[MAUSAC]
                             SET [MAU] = ?
                           WHERE MAMAU = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mauSac.getTenMauSac());
            ps.setInt(2, maMauSac);

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public MauSac getOne(Integer maMauSac) {
        String sql = "SELECT [MAMAU]\n"
                + "      ,[MAU]\n"
                + "  FROM [dbo].[MAUSAC]\n"
                + "  WHERE [dbo].[MAUSAC].MAMAU = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, maMauSac);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac mauSac = new MauSac();
                mauSac.setMaMauSac(rs.getInt("MAMAU"));
                mauSac.setTenMauSac(rs.getString("MAU"));

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
    public List<MauSacViewModel> getAllForCBB() {
        try {
            List<MauSacViewModel> dsMauSac = new ArrayList();

            String sql = """
                         SELECT [MAMAU]
                               ,[MAU]
                           FROM [dbo].[MAUSAC]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                MauSacViewModel mauSac = new MauSacViewModel();

                mauSac.setMaMauSac(ma);
                mauSac.setTenMauSac(ten);
                dsMauSac.add(mauSac);
            }

            return dsMauSac;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MauSac> getAllForName(String tenMauSac) {
        try {
            List<MauSac> dsMauSac = new ArrayList();

            String sql = """
                         SELECT [MAMAU]
                                 ,[MAU]
                             FROM [dbo].[MAUSAC]
                             WHERE MAU like ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+tenMauSac+"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                MauSac mauSac = new MauSac();

                mauSac.setMaMauSac(ma);
                mauSac.setTenMauSac(ten);
                dsMauSac.add(mauSac);
            }

            return dsMauSac;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
