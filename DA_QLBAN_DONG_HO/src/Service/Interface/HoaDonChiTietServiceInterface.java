/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.HoaDonChiTiet;
import ViewModel.HoaDonChiTietViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface HoaDonChiTietServiceInterface {
    public  List<HoaDonChiTietViewModel> getHDCT(String mahd);
    public Boolean addHDCT(HoaDonChiTiet hoaDonChiTiet);
    public  Boolean removeHDCT(String mahd);
}
