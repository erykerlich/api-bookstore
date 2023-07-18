package com.bookstore.services;

import com.bookstore.domain.Category;
import com.bookstore.dtos.CategoryDto;
import com.bookstore.repositories.CategoryRepository;
import com.bookstore.services.exceptions.DataIntegtrityViolationException;
import com.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException
                ("Objeto não encontrado ! Id: " + id + ", Tipo " + Category.class.getName()));
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category create(Category obj){
        obj.setId(null);
        return categoryRepository.save(obj);
    }

    public Category update(Integer id, CategoryDto objDto) {
        Category obj = findById(id);
        obj.setName(objDto.getName());
        obj.setDescription(objDto.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegtrityViolationException("Categoria não pode ser deletada! Possui livros associados.");
        }
        categoryRepository.deleteById(id);
    }
}
