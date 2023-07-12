/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.LoaiSanPham;
import Repository.Interface.*;
import ViewModel.LoaiSanPhamViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface LoaiSanPhamServiceInterface {
    List<LoaiSanPham> getAll();

    String add(LoaiSanPham loaiSanPham);

    String update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham);
    
    LoaiSanPham getOne(Integer maLoaiSanPham);
    
    List<LoaiSanPhamViewModel> getAllForCBB();
    
    List<LoaiSanPham> getAllForName(String tenLoaiSanPham);
}
