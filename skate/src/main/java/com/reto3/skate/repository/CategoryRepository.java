package com.reto3.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.skate.model.Category;
import com.reto3.skate.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getCategoryAll(){
        return (List<Category>) categoryCrudRepository.findAll();        
    }
    public Optional<Category> getCategoryId(Integer id){
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
   
    public void deleteCategory (Category category){
        categoryCrudRepository.delete(category);
    }
}
