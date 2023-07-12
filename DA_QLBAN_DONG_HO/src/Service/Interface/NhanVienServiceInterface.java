/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.NhanVien;
import Repository.Interface.*;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface NhanVienServiceInterface {
      public List<NhanVienViewModel> getAll();
    public List<NhanVien> search(String ten);
    public boolean insert(NhanVien nhanvien);
    public boolean update(NhanVien nhanvien , String MANHANVIEN);
    public boolean delete(String MAKHACHHANG);
    
     Boolean checkEmail(String email);
    Boolean checkPass(String pass);
    NhanVien getAllForName(String email);
    String updateMatKhau(String email, String maKhau);
}
