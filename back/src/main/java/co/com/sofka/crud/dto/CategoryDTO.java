package co.com.sofka.crud.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp="^[a-zA-Z\\s]*$", message = "Invalid Input")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
