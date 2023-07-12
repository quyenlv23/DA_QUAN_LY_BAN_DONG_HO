/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.LoaiSanPham;
import ViewModel.LoaiSanPhamViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface LoaiSanPhamRepositoryInterface {
      List<LoaiSanPham> getAll();
    
    boolean add(LoaiSanPham loaiSanPham);
    
    boolean update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham);
    
    LoaiSanPham getOne(Integer maLoaiSanPham);
    
    List<LoaiSanPhamViewModel> getAllForCBB();
    
    List<LoaiSanPham> getAllForName(String tenLoaiSanPham);
}
