package com.app.springsecurity.services;

import com.app.springsecurity.entities.Category;
import com.app.springsecurity.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    //crear y guardar categoria
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    //Listar todas las categorias
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }
    //obtener categoria por id
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    //actualizar categoria
    public Category updateCategory(Integer id, Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(updatedCategory.getName());
            return categoryRepository.save(category);
        } else {
            return null;
        }
    }
    //eliminar categoria
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

}
