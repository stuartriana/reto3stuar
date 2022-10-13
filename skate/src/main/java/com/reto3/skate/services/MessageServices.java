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
}
