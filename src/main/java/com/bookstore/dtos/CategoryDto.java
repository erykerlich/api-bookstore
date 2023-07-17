package com.bookstore.dtos;


import com.bookstore.domain.Category;

public class CategoryDto {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;

    public CategoryDto() {
    }

    public CategoryDto(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
