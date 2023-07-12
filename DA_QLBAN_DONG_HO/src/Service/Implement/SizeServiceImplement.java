/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.Size;
import Repository.Implement.*;
import Repository.Interface.SizeRepositoryInterface;
import Service.Interface.SizeServiceInterface;
import ViewModel.SizeViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class SizeServiceImplement  implements SizeServiceInterface{
     private SizeRepositoryInterface sizeRepositoryInterface = new SizeRepositoryImplement();
    
    @Override
    public List<Size> getAll() {
        return sizeRepositoryInterface.getAll();
    }

    @Override
    public String add(Size size) {
        boolean add = sizeRepositoryInterface.add(size);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(Integer maSize, Size size) {
        boolean update = sizeRepositoryInterface.update(maSize, size);
        if (update) {
            return "Sửa thành công mã Size:" + maSize;
        }
        return "Sửa thất bại";
    }

    @Override
    public Size getOne(Integer maSize) {
        return sizeRepositoryInterface.getOne(maSize);
    }

    @Override
    public List<SizeViewModel> getAllForCBB() {
        return sizeRepositoryInterface.getAllForCBB();
    }

    @Override
    public List<Size> getAllForName(String tenSize) {
        return sizeRepositoryInterface.getAllForName(tenSize);
    }
}
