package com.bookstore.dtos;


import com.bookstore.domain.Category;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CategoryDto {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo NOME é requerido.")
    @Length(min = 3, max = 100, message = "Campo NOME deve ter entre 100 e 3 caracteres.")
    private String name;
    @NotEmpty(message = "Campo DESCRIÇÃO é requerido.")
    @Length(min = 3, max = 200, message = "Campo DESCRIÇÃO deve ter entre 100 e 3 caracteres.")
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
