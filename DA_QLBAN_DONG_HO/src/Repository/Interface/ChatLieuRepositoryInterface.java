/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Interface;

import DomainModel.ChatLieu;
import ViewModel.ChatLieuViewModel;
import java.util.List;


public interface ChatLieuRepositoryInterface {
      List<ChatLieu> getAll();
    
    boolean add(ChatLieu chatLieu);
    
    boolean update(Integer maChatLieu, ChatLieu chatLieu);
    
    ChatLieu getOne(Integer maChatLieu);
    
    List<ChatLieuViewModel> getAllForCBB();
    
    List<ChatLieu> getAllForName(String tenChatLieu);
}
