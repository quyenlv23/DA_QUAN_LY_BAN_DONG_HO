/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.NhanVien;

/**
 *
 * @author mr.quyen
 */
public interface NhanVienRepositoryInterface {
    public NhanVien getNhanVien(String email, String matKhau);
}
