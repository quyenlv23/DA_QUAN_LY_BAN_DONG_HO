/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.HoaDon;
import ViewModel.HoaDonViewModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface HoaDonRepositoryInterface {

    List<HoaDon> getAllHD();

    public Boolean addHD(HoaDon hoaDon);

    public boolean ThanhToan(String mahd,int trangThai , Double TongTien, Double tienKhachTra , Double tienThua, Date ngayThanhToan);

    public List<HoaDon> getHDChuaThanhToan(Integer trangThai);

    public List<HoaDon> getHDThanhToan(Integer trangThai);

    public boolean HuyThanhToan(String mahd,int trangThai);

    public boolean Delete(int id);
    public List<HoaDonViewModel> getHDdaThanhToan();
}
