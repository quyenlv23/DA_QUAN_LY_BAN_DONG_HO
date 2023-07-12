/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.SanPham;
import Repository.Implement.SanPhamRepositoryImplement;
import Repository.Interface.SanPhamRepositoryInterface;
import Service.Interface.SanPhamServiceInterface;
import ViewModel.SanPhamViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class SanPhamServiceImplement implements SanPhamServiceInterface {

    SanPhamRepositoryInterface sanPhamRepository = new SanPhamRepositoryImplement();

    @Override
    public List<SanPhamViewModel> getListSP() {
        List<SanPhamViewModel> listspview = new ArrayList<>();
        List<SanPham> sp = sanPhamRepository.getListSP();
        for (SanPham sanPham : sp) {
            SanPhamViewModel spView = new SanPhamViewModel();
            spView.setMaSanPham(sanPham.getMaSanPham());
            spView.setTenSanPham(sanPham.getTenSanPham());
            spView.setMauSac(sanPham.getMauSac().getTenMauSac());
            spView.setChatLieu(sanPham.getChatLieu().getTenChatLieu());
            spView.setLoaiSanPham(sanPham.getLoaiSanPham().getTenLoaiSanPham());
            spView.setSize(sanPham.getSize().getTenSize());
            spView.setSoLuong(sanPham.getSoLuong());
            spView.setGiaBan(sanPham.getGiaBan());
            spView.setTinhTrang(sanPham.isTinhTrang());

            listspview.add(spView);
        }
        return listspview;
    }

    private SanPhamRepositoryInterface sanPhamRepositoryInterface = new SanPhamRepositoryImplement();

    @Override
    public String add(SanPham sanPham) {
        boolean add = sanPhamRepositoryInterface.add(sanPham);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepositoryInterface.getAll();
    }

    @Override
    public String update(Integer maSanPham, SanPham sanPham) {
        boolean update = sanPhamRepositoryInterface.update(maSanPham, sanPham);
        if (update) {
            return "Sửa thành công Mã Sản Phẩm:" + maSanPham;
        }
        return "Sửa thất bại";
    }

    @Override
    public SanPham getOne(Integer maSanPham) {
        return sanPhamRepositoryInterface.getOne(maSanPham);
    }

    @Override
    public String delete(Integer maSanPham) {
        if (sanPhamRepositoryInterface.delete(maSanPham) < 0) {
            return "Xóa thất bại";
        } else {
            return "Xóa thành công";
        }
    }

    @Override
    public List<SanPham> getAllForName(String tenSanPham) {
        return sanPhamRepositoryInterface.getAllForName(tenSanPham);
    }

    @Override
    public List<SanPhamViewModel> TimKiemSanPhamBH(String tenSP) {
        List<SanPhamViewModel> listspview = new ArrayList<>();
        List<SanPham> sp = sanPhamRepository.getAllForName(tenSP);
        for (SanPham sanPham : sp) {
            SanPhamViewModel spView = new SanPhamViewModel();
            spView.setMaSanPham(sanPham.getMaSanPham());
            spView.setTenSanPham(sanPham.getTenSanPham());
            spView.setMauSac(sanPham.getMauSac().getTenMauSac());
            spView.setChatLieu(sanPham.getChatLieu().getTenChatLieu());
            spView.setLoaiSanPham(sanPham.getLoaiSanPham().getTenLoaiSanPham());
            spView.setSize(sanPham.getSize().getTenSize());
            spView.setSoLuong(sanPham.getSoLuong());
            spView.setGiaBan(sanPham.getGiaBan());
            spView.setTinhTrang(sanPham.isTinhTrang());

            listspview.add(spView);
        }
        return listspview;

    }

    @Override
    public List<SanPhamViewModel> locMauSac(Integer id) {
        List<SanPhamViewModel> listspview = new ArrayList<>();
        List<SanPham> sp = sanPhamRepository.locMauSac(id);
        for (SanPham sanPham : sp) {
            SanPhamViewModel spView = new SanPhamViewModel();
            spView.setMaSanPham(sanPham.getMaSanPham());
            spView.setTenSanPham(sanPham.getTenSanPham());
            spView.setMauSac(sanPham.getMauSac().getTenMauSac());
            spView.setChatLieu(sanPham.getChatLieu().getTenChatLieu());
            spView.setLoaiSanPham(sanPham.getLoaiSanPham().getTenLoaiSanPham());
            spView.setSize(sanPham.getSize().getTenSize());
            spView.setSoLuong(sanPham.getSoLuong());
            spView.setGiaBan(sanPham.getGiaBan());
            spView.setTinhTrang(sanPham.isTinhTrang());

            listspview.add(spView);
        }
        return listspview;

    }

    @Override
    public List<SanPhamViewModel> locLoai(String tenloai) {
        List<SanPhamViewModel> listspview = new ArrayList<>();
        List<SanPham> sp = sanPhamRepository.locLoai(tenloai);
        for (SanPham sanPham : sp) {
            SanPhamViewModel spView = new SanPhamViewModel();
            spView.setMaSanPham(sanPham.getMaSanPham());
            spView.setTenSanPham(sanPham.getTenSanPham());
            spView.setMauSac(sanPham.getMauSac().getTenMauSac());
            spView.setChatLieu(sanPham.getChatLieu().getTenChatLieu());
            spView.setLoaiSanPham(sanPham.getLoaiSanPham().getTenLoaiSanPham());
            spView.setSize(sanPham.getSize().getTenSize());
            spView.setSoLuong(sanPham.getSoLuong());
            spView.setGiaBan(sanPham.getGiaBan());
            spView.setTinhTrang(sanPham.isTinhTrang());

            listspview.add(spView);
        }
        return listspview;
    }

    @Override
    public Boolean updateSoLuong(Integer maSP, Integer soLuong) {
        return sanPhamRepository.updateSoLuong(maSP, soLuong);
    }

}
