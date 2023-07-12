/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.SanPham;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface SanPhamRepositoryInterface {

    public List<SanPham> getListSP();

    public List<SanPham> locMauSac(Integer id);

    public List<SanPham> locLoai(String  tenloai);
    
    public Boolean updateSoLuong(Integer maSP, Integer soLuong);

    boolean add(SanPham sanPham);

    List<SanPham> getAll();

    boolean update(Integer maSanPham, SanPham sanPham);

    SanPham getOne(Integer maSanPham);

    Integer delete(Integer maSanPham);

    List<SanPham> getAllForName(String tenSanPham);

}
