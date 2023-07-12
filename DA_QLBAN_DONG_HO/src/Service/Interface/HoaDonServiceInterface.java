/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.HoaDon;
import ViewModel.HoaDonViewModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface HoaDonServiceInterface {

    List<HoaDonViewModel> getAllHD();

    public Boolean addHD(HoaDon hoaDon);

    public boolean ThanhToan(String mahd ,int trangThai , Double TongTien, Double tienKhachTra, Double tienThua, Date ngayThanhToan);

    public List<HoaDonViewModel> getHDChuaThanhToan(Integer trangThai);

    public List<HoaDonViewModel> getHDThanhToan(Integer trangThai);
    
    public boolean HuyThanhToan(String mahd,int trangThai);
    
    public List<HoaDonViewModel> getHDdaThanhToan();
}
