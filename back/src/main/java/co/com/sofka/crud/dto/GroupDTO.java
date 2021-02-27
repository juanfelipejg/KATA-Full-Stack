package co.com.sofka.crud.dto;

import java.util.ArrayList;
import java.util.List;

public class GroupDTO {

    private String name;
    private Long id;

    List<TodoDTO> todos = new ArrayList<>();

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

    public List<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDTO> todos) {
        this.todos = todos;
    }
}
