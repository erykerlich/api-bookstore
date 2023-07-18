package com.bookstore.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Book implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Campo TITULO é requerido.")
    @Length(min = 3, max = 50, message = "Campo TITULO deve ter entre 50 e 3 caracteres.")
    private String title;
    @NotEmpty(message = "Campo NOME DO AUTOR é requerido.")
    @Length(min = 3, max = 50, message = "Campo NOME DO AUTOR deve ter entre 50 e 3 caracteres.")
    private String nameAuthor;
    @NotEmpty(message = "Campo TEXTO é requerido.")
    @Length(min = 10, max = 2000000, message = "Campo TEXTO deve ter entre 10 e 2.000.000 caracteres.")
    private String text;
    @JsonIgnore
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
