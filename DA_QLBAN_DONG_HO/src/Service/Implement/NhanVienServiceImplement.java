/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.NhanVien;
import Repository.Implement.NhanVienRepositoryImplement;
import Repository.Interface.NhanVienRepositoryInterface;
import Service.Interface.NhanVienServiceInterface;
import Utility.DBContext;
import ViewModel.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author mr.quyen
 */
public class NhanVienServiceImplement implements NhanVienServiceInterface{
  private NhanVienRepositoryInterface repo = new NhanVienRepositoryImplement();
    private List<NhanVienViewModel> listNVModel;
   
    {
    }
    @Override
    public List<NhanVienViewModel> getAll() {
        listNVModel = new ArrayList<>();
        List<NhanVien> list = repo.findAll();
        for(NhanVien nhanVien : list){
            NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();
            nhanVienViewModel.setMaNhanVien(nhanVien.getMaNhanVien());
            nhanVienViewModel.setHoTen(nhanVien.getHoTen());
            nhanVienViewModel.setEmail(nhanVien.getEmail());
            nhanVienViewModel.setDiaChi(nhanVien.getDiaChi());
            nhanVienViewModel.setChucVu(nhanVien.getChucVu());
            nhanVienViewModel.setGioiTinh(nhanVien.getGioiTinh());
            nhanVienViewModel.setTrangThai(nhanVien.getTrangThai());
            nhanVienViewModel.setSoDienThoai(nhanVien.getSoDienThoai());
            nhanVienViewModel.setMatKhau(nhanVien.getMatKhau());
            listNVModel.add(nhanVienViewModel);
        }
        return listNVModel;
            
    }

    @Override
    public List<NhanVien> search(String ten) {
        return repo.search(ten);
    }

    @Override
    public boolean insert(NhanVien nhanvien) {
        return repo.Save(nhanvien); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(NhanVien nhanvien, String MANHANVIEN) {
        return repo.update(nhanvien);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String MAKHACHHANG) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     private NhanVienRepositoryInterface nhanVienRepositoryInterface = new NhanVienRepositoryImplement();
    
    @Override
    public Boolean checkEmail(String email) {
        boolean update = nhanVienRepositoryInterface.checkEmail(email);
        if (update) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkPass(String pass) {
        boolean update = nhanVienRepositoryInterface.checkPass(pass);
        if (update) {
            return true;
        }
        return false;
    }

    @Override
    public NhanVien getAllForName(String email) {
        return nhanVienRepositoryInterface.getAllForName(email);
    }

    @Override
    public String updateMatKhau(String email, String maKhau) {
        boolean update = nhanVienRepositoryInterface.updateMK(email, maKhau);
        if (update) {
            return "đổi mật khẩu thành công" ;
        }
        return "đổi mật khẩu thất bại thất bại";
    }
}
