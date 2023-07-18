package com.bookstore.services;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.repositories.BookRepository;
import com.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException
                ("Objeto não encontrado! Id: " + id + ", Tipo: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_cat) {
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);

    }

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateDate(newObj, obj);
        return bookRepository.save(newObj);
    }

    private void updateDate(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setNameAuthor(obj.getNameAuthor());
        newObj.setText(obj.getText());
    }

    public Book create(Integer id_cat, Book obj) {
        obj.setId(null);
        Category cat = categoryService.findById(id_cat);
        obj.setCategory(cat);
        return bookRepository.save(obj);
    }

    public void delete(Integer id) {
        Book obj = findById(id);
        bookRepository.delete(obj);
    }
}
