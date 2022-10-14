package com.reto3.skate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Category;
import com.reto3.skate.repository.CategoryRepository;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryAll() {
        return categoryRepository.getCategoryAll();
    }

    public Optional<Category> getCategoryId(Integer id) {
        return categoryRepository.getCategoryId(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategoryId(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
    public Category updateCategory(Category category){
        if (category.getId()!= null){
            Optional<Category> category1 = categoryRepository.getCategoryId(category.getId());
            if (!category1.isEmpty()){
                if (category.getDescription()!= null){
                    category1.get().setDescription(category.getDescription());
                }
                if (category.getName()!= null){
                    category1.get().setName(category.getName());
                }
                return categoryRepository.save(category1.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(Integer id){
        boolean flag = false;
        Optional<Category> category1 = categoryRepository.getCategoryId(id);
        if (category1.isPresent()){
            categoryRepository.deleteCategory(category1.get());
            flag = true;
        }
        return flag;
    }
}
