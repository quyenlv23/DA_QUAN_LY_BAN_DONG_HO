/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.ChatLieu;
import java.util.List;
import Repository.Interface.ChatLieuRepositoryInterface;
import Utility.DBContext;
import ViewModel.ChatLieuViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mr.quyen
 */
public class ChatLieuRepositoryImplement  implements ChatLieuRepositoryInterface{
 public static Connection connection = DBContext.getConnection();

    @Override
    public List<ChatLieu> getAll() {
        try {
            List<ChatLieu> dsChatLieus = new ArrayList();

            String sql = """
                         SELECT [MACHATLIEU]
                               ,[CHATLIEU]
                           FROM [dbo].[CHATLIEU]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                ChatLieu chatLieu = new ChatLieu();

                chatLieu.setMaChatLieu(ma);
                chatLieu.setTenChatLieu(ten);
                dsChatLieus.add(chatLieu);
            }

            return dsChatLieus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(ChatLieu chatLieu) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = "INSERT INTO [dbo].[CHATLIEU]\n"
                    + "           ([CHATLIEU])\n"
                    + "     VALUES\n"
                    + "           (?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, chatLieu.getTenChatLieu());

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(Integer maChatLieu, ChatLieu chatLieu) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         UPDATE [dbo].[CHATLIEU]
                            SET [CHATLIEU] = ?
                          WHERE [MACHATLIEU] = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, chatLieu.getTenChatLieu());
            ps.setInt(2, maChatLieu);

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public ChatLieu getOne(Integer maChatLieu) {
        String sql = "SELECT [MACHATLIEU]\n"
                + "      ,[CHATLIEU]\n"
                + "  FROM [dbo].[CHATLIEU]\n"
                + "  WHERE [dbo].[CHATLIEU].MACHATLIEU = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, maChatLieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setMaChatLieu(rs.getInt("MACHATLIEU"));
                chatLieu.setTenChatLieu(rs.getString("CHATLIEU"));

//                sanPham1.setTrangThai(rs.getInt("TrangThai"));
//                products.add(sanPham1);
                return chatLieu;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        return (BHSanPhamVM) products;
        return null;
    }

    @Override
    public List<ChatLieuViewModel> getAllForCBB() {
        try {
            List<ChatLieuViewModel> dsChatLieus = new ArrayList();

            String sql = """
                         SELECT [MACHATLIEU]
                               ,[CHATLIEU]
                           FROM [dbo].[CHATLIEU]""";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                ChatLieuViewModel chatLieu = new ChatLieuViewModel();

                chatLieu.setMaChatLieu(ma);
                chatLieu.setTenChatLieu(ten);
                dsChatLieus.add(chatLieu);
            }

            return dsChatLieus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChatLieu> getAllForName(String tenChatLieu) {
        try {
            List<ChatLieu> dsChatLieus = new ArrayList();

            String sql = """
                         SELECT [MACHATLIEU]
                               ,[CHATLIEU]
                           FROM [dbo].[CHATLIEU]
                           WHERE CHATLIEU LIKE ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+tenChatLieu+"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Integer ma = rs.getInt(1);
                String ten = rs.getString(2);

                ChatLieu chatLieu = new ChatLieu();

                chatLieu.setMaChatLieu(ma);
                chatLieu.setTenChatLieu(ten);
                dsChatLieus.add(chatLieu);
            }

            return dsChatLieus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   
}
