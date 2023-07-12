/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.LoaiSanPham;
import Repository.Implement.LoaiSanPhamRepositoryImplement;
import Repository.Interface.LoaiSanPhamRepositoryInterface;
import Service.Interface.LoaiSanPhamServiceInterface;
import ViewModel.LoaiSanPhamViewModel;
import java.util.List;



/**
 *
 * @author mr.quyen
 */
public class LoaiSanPhamServiceImplement implements LoaiSanPhamServiceInterface{
      private LoaiSanPhamRepositoryInterface loaiSanPhamRepositoryInterface = new LoaiSanPhamRepositoryImplement();
    
    @Override
    public List<LoaiSanPham> getAll() {
        return loaiSanPhamRepositoryInterface.getAll();
    }

    @Override
    public String add(LoaiSanPham loaiSanPham) {
        boolean add = loaiSanPhamRepositoryInterface.add(loaiSanPham);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham) {
        boolean update = loaiSanPhamRepositoryInterface.update(maLoaiSanPham, loaiSanPham);
        if (update) {
            return "Sửa thành công mã loại:" + maLoaiSanPham;
        }
        return "Sửa thất bại";
    }

    @Override
    public LoaiSanPham getOne(Integer maLoaiSanPham) {
        return loaiSanPhamRepositoryInterface.getOne(maLoaiSanPham);
    }

    @Override
    public List<LoaiSanPhamViewModel> getAllForCBB() {
        return loaiSanPhamRepositoryInterface.getAllForCBB();
    }

    @Override
    public List<LoaiSanPham> getAllForName(String tenLoaiSanPham) {
        return loaiSanPhamRepositoryInterface.getAllForName(tenLoaiSanPham);
    }
    
}
