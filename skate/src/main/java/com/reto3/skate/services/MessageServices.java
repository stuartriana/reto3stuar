package com.reto3.skate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Message;
import com.reto3.skate.repository.MessageRepository;

@Service
public class MessageServices {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessageAll(){
        return messageRepository.getMessageAll();
    }
    public Optional<Message> getMessageId(Integer id){
        return messageRepository.getMessageId(id);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        } else{
            Optional<Message> message1=messageRepository.getMessageId(message.getIdMessage());
            if (message1.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message updateMessage(Message message){
        if (message.getIdMessage()!= null){
            Optional<Message> message1 = messageRepository.getMessageId(message.getIdMessage());
            if (!message1.isEmpty()){
                if (message.getMessageText()!= null){
                    message1.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(message1.get());
                return message1.get();
            } else{
                return message;
            }
        } else{
            return message;
        }
    }
    public boolean delete(Integer messageId){
        boolean flag = false;
        Optional<Message> message1 = messageRepository.getMessageId(messageId);
        if (message1.isPresent()){
            messageRepository.delete(message1.get());
            flag = true;
        }
        return flag;
    }
}
