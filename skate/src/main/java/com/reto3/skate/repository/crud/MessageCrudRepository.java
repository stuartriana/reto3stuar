package com.reto3.skate.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.reto3.skate.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
