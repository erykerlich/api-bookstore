package com.bookstore.dtos;

import com.bookstore.domain.Book;


import java.io.Serial;
import java.io.Serializable;

public class BookDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    public BookDto() {
    }
    public BookDto(Book obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
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
}
