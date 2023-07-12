/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Implement;

import DomainModel.NhanVien;
import Repository.Interface.NhanVienRepositoryInterface;
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
public class NhanVienRepositoryImplement implements NhanVienRepositoryInterface{
      @Override
    public List<NhanVien> findAll() {
        
       
          List<NhanVien> listNV = new ArrayList<>();
          
        
        try  {
             Connection conn=DBContext.getConnection();
            String sql="SELECT * FROM NHANVIEN";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {          
                Integer ma=Integer.parseInt(rs.getString(1));                
                String hoTen=rs.getString(2);
                int gioiTinh=Integer.parseInt(rs.getString(3));
                
                String diaChi=rs.getString(4);
                String sdt=rs.getString(5);
                String email=rs.getString(6);
                String matkhau =rs.getString(7);
                int trangthai =rs.getInt(8);
                String chucvu =rs.getString(9);
                NhanVien nv = new NhanVien(ma, hoTen, gioiTinh, diaChi, sdt, email, matkhau, trangthai, chucvu);
                listNV.add(nv);
            } 
        return listNV;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
        
        
        
    }

    @Override
    public boolean Save(NhanVien nhanvien) {
        try {
            Connection conn=DBContext.getConnection();
            String sql="insert into NHANVIEN(HOTEN,GIOITINH,DIACHI,SDT,EMAIL,MATKHAU,TRANGTHAI,CHUCVU) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1,nhanvien.getHoTen());
            ps.setInt(2,nhanvien.getGioiTinh());
           
            ps.setString(3,nhanvien.getDiaChi());
             ps.setString(4,nhanvien.getSoDienThoai());
             ps.setString(5,nhanvien.getEmail());
             ps.setString(6, nhanvien.getMatKhau());
             ps.setInt(7, nhanvien.getTrangThai());
             ps.setString(8, nhanvien.getChucVu());
             
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean update(NhanVien nhanvien) {
        try {
             Connection conn=DBContext.getConnection();
             String sql="UPDATE NHANVIEN SET HOTEN=? ,GIOITINH=?,DIACHI=?,SDT=?,EMAIL=?,MATKHAU=?,TRANGTHAI=?,CHUCVU=?\n"+"WHERE MANHANVIEN=?";
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setObject(9, nhanvien.getMaNhanVien());
             ps.setString(1,nhanvien.getHoTen());
            ps.setInt(2,nhanvien.getGioiTinh());         
            ps.setString(3,nhanvien.getDiaChi());
             ps.setString(4,nhanvien.getSoDienThoai());
             ps.setString(5,nhanvien.getEmail());
             ps.setString(6, nhanvien.getMatKhau());
             ps.setInt(7, nhanvien.getTrangThai());
             ps.setString(8, nhanvien.getChucVu());
            
             ps.executeUpdate();
             return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public NhanVien findById(String MANHANVIEN) {
//        ArrayList<NhanVien> listNV=new ArrayList<>();
//        try {
//            Connection conn=DBContext.getConnection();
//            String sql="SELECT * FROM KHACHHANG WHERE MANHANVIEN like '%"+MANHANVIEN+"%'";
//           
//            PreparedStatement ps=conn.prepareStatement(sql);
//            ps.execute();
//            ResultSet rs=ps.getResultSet();
//            while (rs.next()) {                
//                 Integer ma=Integer.parseInt(rs.getString(1));
//                String hoTen=rs.getString(2);
//                int gioiTinh=Integer.parseInt(rs.getString(3));
//                
//                String diaChi=rs.getString(4);
//                String sdt=rs.getString(5);
//                String email=rs.getString(6);
//                String matkhau =rs.getString(7);
//                int trangthai =rs.getInt(8);
//                String chucvu =rs.getString(9);
//                NhanVien nv = new NhanVien(ma, hoTen, gioiTinh, diaChi, sdt, email, matkhau, trangthai, chucvu);
//                listNV.add(nv);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listNV;
//    }

    @Override
    public List<NhanVien> search(String ten) {
        ArrayList<NhanVien> listNV=new ArrayList<>();
        try {
            Connection conn=DBContext.getConnection();
            String sql = "SELECT * FROM NHANVIEN WHERE HOTEN LIKE '%" + ten + "%'";
           
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {       
                Integer ma=Integer.parseInt(rs.getString(1));
                
                String hoTen=rs.getString(2);
                int gioiTinh=Integer.parseInt(rs.getString(3));
                
                String diaChi=rs.getString(4);
                String sdt=rs.getString(5);
                String email=rs.getString(6);
                String matkhau =rs.getString(7);
                int trangthai =rs.getInt(8);
                String chucvu =rs.getString(9);
                NhanVien nv = new NhanVien(ma, hoTen, gioiTinh, diaChi, sdt, email, matkhau, trangthai, chucvu);
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    
     public static Connection connection = DBContext.getConnection();

    @Override
    public Boolean checkEmail(String email) {
        int check = 0;
        try {

            String sql = """
                         SELECT [MANHANVIEN]
                               ,[HOTEN]
                               ,[GIOITINH]
                               ,[DIACHI]
                               ,[SDT]
                               ,[EMAIL]
                               ,[MATKHAU]
                               ,[TRANGTHAI]
                               ,[CHUCVU]
                           FROM [dbo].[NHANVIEN]
                           WHERE EMAIL = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                check = 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean checkPass(String pass) {
        int check = 0;
        try {

            String sql = """
                         SELECT [MANHANVIEN]
                               ,[HOTEN]
                               ,[GIOITINH]
                               ,[DIACHI]
                               ,[SDT]
                               ,[EMAIL]
                               ,[MATKHAU]
                               ,[TRANGTHAI]
                               ,[CHUCVU]
                           FROM [dbo].[NHANVIEN]
                           WHERE MATKHAU = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                check = 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public NhanVien getAllForName(String email) {
        try {

            NhanVien nhanVien = new NhanVien();
            String sql = """
                         SELECT [MANHANVIEN]
                               ,[HOTEN]
                               ,[GIOITINH]
                               ,[DIACHI]
                               ,[SDT]
                               ,[EMAIL]
                               ,[MATKHAU]
                               ,[TRANGTHAI]
                               ,[CHUCVU]
                           FROM [dbo].[NHANVIEN]
                           WHERE EMAIL = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer maNhanVien = rs.getInt("MANHANVIEN");
                String ten = rs.getString("HOTEN");
                String diaChi =rs.getString("DIACHI");
                String sdt = rs.getString("SDT");
                String emaill = rs.getString("EMAIL");
                String matKhau = rs.getString("MATKHAU");
                Integer trangThai = rs.getInt("TRANGTHAI");
                
                Integer gioiTinh = rs.getInt("GIOITINH");
                String chucVu = rs.getString("CHUCVU");

                nhanVien.setChucVu(chucVu);
                nhanVien.setMaNhanVien(maNhanVien);
                nhanVien.setHoTen(ten);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setSoDienThoai(sdt);
                nhanVien.setEmail(email);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setTrangThai(trangThai);
            }

            return nhanVien;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updateMK(String email, String matKhau) {
        int check = 0;
        try {
            Connection connection = DBContext.getConnection();

            String sql = """
                         UPDATE [dbo].[NHANVIEN]
                            SET 
                               [MATKHAU] = ?
                          WHERE EMAIL = ?""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, matKhau);
            ps.setString(2, email);

            check = ps.executeUpdate();

//            ps.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
