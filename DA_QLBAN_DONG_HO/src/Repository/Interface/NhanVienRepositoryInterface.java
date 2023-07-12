/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.NhanVien;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface NhanVienRepositoryInterface {
       List<NhanVien> findAll();
    

    public boolean Save(NhanVien nhanvien);

    public boolean update(NhanVien nhanvien);

    public List<NhanVien> search(String ten);
    
    Boolean checkEmail(String email);
    Boolean checkPass(String pass);
    NhanVien getAllForName(String email);
    Boolean updateMK(String email, String matKhau);
}
