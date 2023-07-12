/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;


import DomainModel.MauSac;
import Repository.Implement.MauSacRepositoryImplement;
import Repository.Interface.MauSacRepositoryInterface;
import Service.Interface.MauSacServiceInterface;
import ViewModel.MauSacViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public class MauSacServiceImplement implements MauSacServiceInterface{
    private MauSacRepositoryInterface mauSacRepositoryInterface = new MauSacRepositoryImplement();
    
    @Override
    public List<MauSac> getAll() {
        return mauSacRepositoryInterface.getAll();
    }

    @Override
    public String add(MauSac mauSac) {
        boolean add = mauSacRepositoryInterface.add(mauSac);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(Integer maMauSac, MauSac mauSac) {
        boolean update = mauSacRepositoryInterface.update(maMauSac, mauSac);
        if (update) {
            return "Sửa thành công mã màu:" + maMauSac;
        }
        return "Sửa thất bại";
    }

    @Override
    public MauSac getOne(Integer maMauSac) {
        return mauSacRepositoryInterface.getOne(maMauSac);
    }

    @Override
    public List<MauSacViewModel> getAllForCBB() {
        return mauSacRepositoryInterface.getAllForCBB();
    }

    @Override
    public List<MauSac> getAllForName(String tenMauSac) {
        return mauSacRepositoryInterface.getAllForName(tenMauSac);
    }
    
}
