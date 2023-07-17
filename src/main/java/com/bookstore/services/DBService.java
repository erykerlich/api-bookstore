package com.bookstore.services;

import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.repositories.BookRepository;
import com.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public void instanceDataBase(){

        Category cat1 = new Category(null, "Informatica", "Livros de Ti");
        Category cat2 = new Category(null, "Livros de Suspense", "Suspense");
        Category cat3 = new Category(null, "Livros de Terror", "Terror");

        Book book1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book book2 = new Book(null, "Jogos Vorazes", "Suzane Colins", "Lorem ipsum", cat1);
        Book book3 = new Book(null, "It a Coisa", "Stephen King", "Lorem ipsum", cat1);
        Book book4 = new Book(null, "O Iluminado", "Stephen King", "Lorem ipsum", cat1);
        Book book5 = new Book(null, "Doutor Sono", "Stephen King", "Lorem ipsum", cat1);

        cat1.getBookList().addAll(Arrays.asList(book1, book2));
        cat2.getBookList().addAll(Arrays.asList(book2));
        cat3.getBookList().addAll(Arrays.asList(book3, book4, book5));


        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5));

    }

}
