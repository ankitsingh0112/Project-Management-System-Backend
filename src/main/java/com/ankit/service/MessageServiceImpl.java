package com.ankit.service;

import com.ankit.modal.Chat;
import com.ankit.modal.Message;
import com.ankit.modal.User;
import com.ankit.repository.MessageRepo;
import com.ankit.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectService projectService;


    @Override
    public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {
        User sender = userRepo.findById(senderId)
                .orElseThrow(()->new Exception("User not found with id : " + senderId));

        Chat chat = projectService.getProjectById(projectId).getChat();

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);

        Message savedMessage = messageRepo.save(message);

        chat.getMessages().add(savedMessage);

        return savedMessage;
    }

    @Override
    public List<Message> getMessageByProjectId(Long projectId) throws Exception {
        Chat chat = projectService.getChatByProjectId(projectId);
        List<Message> findByChatIdOrderByCreatedAtAsc = messageRepo.findByChatIdOrderByCreatedAtAsc(chat.getId());

        return findByChatIdOrderByCreatedAtAsc;
    }
}
