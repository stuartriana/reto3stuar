package com.reto3.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.skate.model.Message;
import com.reto3.skate.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> getMessageAll(){
        return (List<Message>) messageCrudRepository.findAll();        
    }
    public Optional<Message> getMessageId(Integer id){
        return messageCrudRepository.findById(id);
    }
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    public void delete(Message message){
        messageCrudRepository.delete(message);
    } 
    public void deleteMessage(Message message){
        messageCrudRepository.delete(message);
    }
}
