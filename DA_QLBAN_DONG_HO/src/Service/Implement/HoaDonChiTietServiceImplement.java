/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.HoaDonChiTiet;
import Repository.Implement.HoaDonChiTietRepositoryImplement;
import Repository.Interface.HoaDonChiTietRepositoryInterface;
import Service.Interface.HoaDonChiTietServiceInterface;
import Service.Interface.HoaDonServiceInterface;
import ViewModel.HoaDonChiTietViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class HoaDonChiTietServiceImplement implements HoaDonChiTietServiceInterface {

    private HoaDonChiTietRepositoryInterface hoaDonChiTietRepositoryImplement
            = new HoaDonChiTietRepositoryImplement();

    @Override
    public List<HoaDonChiTietViewModel> getHDCT(String mahd) {
        List<HoaDonChiTiet> listhdct = hoaDonChiTietRepositoryImplement.getHDCT(mahd);
        List<HoaDonChiTietViewModel> listview = new ArrayList<>();
        for (HoaDonChiTiet hdct : listhdct) {
            HoaDonChiTietViewModel hdctvm = new HoaDonChiTietViewModel();
            hdctvm.setMaHoaDon(String.valueOf(hdct.getHoaDon()));
            hdctvm.setMaSanPham(String.valueOf(hdct.getSanPham().getMaSanPham()));
            hdctvm.setTenSP(hdct.getSanPham().getTenSanPham());
            hdctvm.setSoLuong(hdct.getSoLuong());
            hdctvm.setDonGia(hdct.getDonGia());
            listview.add(hdctvm);
        }
        return listview;
    }

    @Override
    public Boolean addHDCT(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepositoryImplement.addHDCT(hoaDonChiTiet);
    }

    @Override
    public Boolean removeHDCT(String mahd) {
        return hoaDonChiTietRepositoryImplement.removeHDCT(mahd);

    }

}
