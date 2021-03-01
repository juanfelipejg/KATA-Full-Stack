package co.com.sofka.crud.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TodoDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp="^[a-zA-Z\\s]*$",message = "Invalid Input")
    private String name;

    private boolean completed;
    private Long categoryId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getCategoryId() {return categoryId;}

    public void setCategoryId(Long categoryId) {this.categoryId = categoryId;}

}
