package co.com.sofka.crud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    private String name;

    private boolean completed;

    @ManyToOne()
    private Category category;

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

    public Category getGroup() {return category;}

    public void setGroup(Category category) {this.category = category;}
}
