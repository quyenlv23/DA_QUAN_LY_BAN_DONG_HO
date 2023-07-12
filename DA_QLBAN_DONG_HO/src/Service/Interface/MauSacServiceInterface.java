/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.MauSac;
import Repository.Interface.*;
import ViewModel.MauSacViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface MauSacServiceInterface {
     List<MauSac> getAll();

    String add(MauSac mauSac);

    String update(Integer maMauSac, MauSac mauSac);

    MauSac getOne(Integer maMauSac);
    
    List<MauSacViewModel> getAllForCBB();
    
    List<MauSac> getAllForName(String tenMauSac);
}
