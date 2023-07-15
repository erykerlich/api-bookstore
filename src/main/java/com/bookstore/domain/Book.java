package com.bookstore.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Books")
public class Book implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String nameAuthor;
    private String text;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;


    public Book() {
    }

    public Book(Integer id, String title, String nameAuthor, String text, Category category) {
        this.id = id;
        this.title = title;
        this.nameAuthor = nameAuthor;
        this.text = text;
        this.category = category;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
