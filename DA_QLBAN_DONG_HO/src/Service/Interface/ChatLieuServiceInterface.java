/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.ChatLieu;
import ViewModel.ChatLieuViewModel;
import java.util.List;

/**
 *
 * @author mr.quyen
 */
public interface ChatLieuServiceInterface {
      List<ChatLieu> getAll();
    
    String add(ChatLieu chatLieu);
    
    String update(Integer maChatLieu, ChatLieu chatLieu);
    
    ChatLieu getOne(Integer maChatLieu);
    
    List<ChatLieuViewModel> getAllForCBB();
    
    List<ChatLieu> getAllForName(String tenChatLieu);
}
