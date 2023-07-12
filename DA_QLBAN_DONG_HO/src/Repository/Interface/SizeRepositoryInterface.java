/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.Size;
import ViewModel.SizeViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface SizeRepositoryInterface {
    List<Size> getAll();
    
    boolean add(Size size);
    
    boolean update(Integer maSize, Size size);
    
    Size getOne(Integer maSize);
    
    List<SizeViewModel> getAllForCBB();
    
    List<Size> getAllForName(String tenSize);
}
