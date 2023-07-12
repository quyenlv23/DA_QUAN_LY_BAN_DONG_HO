/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.MauSac;
import ViewModel.MauSacViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface MauSacRepositoryInterface {
     List<MauSac> getAll();
    
    boolean add(MauSac mauSac);
    
    boolean update(Integer maMauSac, MauSac mauSac);
    
    MauSac getOne(Integer maMauSac);
    
    List<MauSacViewModel> getAllForCBB();
    
    List<MauSac> getAllForName(String tenMauSac);
}
