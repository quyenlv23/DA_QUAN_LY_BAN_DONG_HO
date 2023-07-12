/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.SanPham;
import Repository.Interface.*;
import ViewModel.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface SanPhamServiceInterface {

    public List<SanPhamViewModel> getListSP();

    public List<SanPhamViewModel> locMauSac(Integer id);

    public List<SanPhamViewModel> locLoai(String tenloai);

    public Boolean updateSoLuong(Integer maSP, Integer soLuong);

    List<SanPham> getAll();

    String add(SanPham sanPham);

    String update(Integer maSanPham, SanPham sanPham);

    SanPham getOne(Integer maSanPham);

    String delete(Integer maSanPham);

    List<SanPham> getAllForName(String tenSanPham);

    public List<SanPhamViewModel> TimKiemSanPhamBH(String tenSP);
}
