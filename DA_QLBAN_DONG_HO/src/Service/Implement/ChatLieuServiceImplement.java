/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModel.ChatLieu;
import Repository.Implement.ChatLieuRepositoryImplement;
import Repository.Interface.ChatLieuRepositoryInterface;
import Service.Interface.ChatLieuServiceInterface;
import ViewModel.ChatLieuViewModel;
import java.util.List;




/**
 *
 * @author mr.quyen
 */
public class ChatLieuServiceImplement  implements ChatLieuServiceInterface{
 private ChatLieuRepositoryInterface chatLieuRepositoryInterface = new ChatLieuRepositoryImplement();

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepositoryInterface.getAll();
    }

    @Override
    public String add(ChatLieu chatLieu) {
        boolean add = chatLieuRepositoryInterface.add(chatLieu);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(Integer maChatLieu, ChatLieu chatLieu) {
        boolean update = chatLieuRepositoryInterface.update(maChatLieu, chatLieu);
        if (update) {
            return "Sửa thành công mã Chất liệu:" + maChatLieu;
        }
        return "Sửa thất bại";
    }

    @Override
    public ChatLieu getOne(Integer maChatLieu) {
        return chatLieuRepositoryInterface.getOne(maChatLieu);
    }

    @Override
    public List<ChatLieuViewModel> getAllForCBB() {
        return chatLieuRepositoryInterface.getAllForCBB();
    }

    @Override
    public List<ChatLieu> getAllForName(String tenChatLieu) {
        return chatLieuRepositoryInterface.getAllForName(tenChatLieu);
    }
   
}
