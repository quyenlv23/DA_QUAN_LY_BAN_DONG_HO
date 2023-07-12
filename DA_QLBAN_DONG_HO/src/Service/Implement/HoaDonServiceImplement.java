/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.HoaDon;
import Repository.Implement.HoaDonRepositoryImplement;
import Repository.Interface.HoaDonRepositoryInterface;
import Service.Interface.HoaDonServiceInterface;
import ViewModel.HoaDonViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class HoaDonServiceImplement implements HoaDonServiceInterface {

    private HoaDonRepositoryInterface hoaDonReposiory = new HoaDonRepositoryImplement();

    @Override
    public List<HoaDonViewModel> getAllHD() {
        List<HoaDon> listHD = hoaDonReposiory.getAllHD();
        List<HoaDonViewModel> listHDView = new ArrayList<>();
        for (HoaDon hd : listHD) {
            HoaDonViewModel hdView = new HoaDonViewModel();
            hdView.setMaHoaDon(hd.getMaHoaDon());
            hdView.setNhanVien(String.valueOf(hd.getNhanVien().getMaNhanVien()));
            hdView.setNgayTao(hd.getNgayTao());
            hdView.setTrangThai(hd.getTrangThai());
            listHDView.add(hdView);
        }
        return listHDView;
    }

    public static void main(String[] args) {
        HoaDonServiceInterface hdsv = new HoaDonServiceImplement();
        System.out.println(hdsv.getAllHD());

    }

    @Override
    public Boolean addHD(HoaDon hoaDon) {
        return hoaDonReposiory.addHD(hoaDon);
    }
 
    @Override
    public List<HoaDonViewModel> getHDChuaThanhToan(Integer trangThai) {
        List<HoaDon> listHD = hoaDonReposiory.getHDChuaThanhToan(trangThai);
        List<HoaDonViewModel> listHDView = new ArrayList<>();
        for (HoaDon hd : listHD) {
            HoaDonViewModel hdView = new HoaDonViewModel();
            hdView.setMaHoaDon(hd.getMaHoaDon());
            hdView.setNhanVien(String.valueOf(hd.getNhanVien().getMaNhanVien()));
            hdView.setNgayTao(hd.getNgayTao());
            hdView.setTrangThai(hd.getTrangThai());
            listHDView.add(hdView);
        }
        return listHDView;
    }

    @Override
    public List<HoaDonViewModel> getHDThanhToan(Integer trangThai) {
  List<HoaDon> listHD = hoaDonReposiory.getHDChuaThanhToan(trangThai);
        List<HoaDonViewModel> listHDView = new ArrayList<>();
        for (HoaDon hd : listHD) {
            HoaDonViewModel hdView = new HoaDonViewModel();
            hdView.setMaHoaDon(hd.getMaHoaDon());
            hdView.setNhanVien(String.valueOf(hd.getNhanVien().getMaNhanVien()));
            hdView.setNgayTao(hd.getNgayTao());
            hdView.setTrangThai(hd.getTrangThai());
            listHDView.add(hdView);
        }
        return listHDView;  
    }

    @Override
    public boolean ThanhToan(String mahd ,int trangThai , Double TongTien, Double tienKhachTra, Double tienThua, Date ngayThanhToan) {
  
        
        return hoaDonReposiory.ThanhToan(mahd, trangThai, TongTien, tienKhachTra, tienThua, ngayThanhToan);
    }

    @Override
    public boolean HuyThanhToan(String mahd, int trangThai) {
     return hoaDonReposiory.HuyThanhToan(mahd, trangThai);
     }

    @Override
    public List<HoaDonViewModel> getHDdaThanhToan() {
    return hoaDonReposiory.getHDdaThanhToan();
    }

}
