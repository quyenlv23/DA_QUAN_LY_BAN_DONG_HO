/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.Size;
import Repository.Interface.*;
import ViewModel.SizeViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface SizeServiceInterface {
    List<Size> getAll();

    String add(Size size);

    String update(Integer maSize, Size size);
    
    Size getOne(Integer maSize);
    
    List<SizeViewModel> getAllForCBB();
    
    List<Size> getAllForName(String tenSize);
}
