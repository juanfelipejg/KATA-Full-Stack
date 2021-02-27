package co.com.sofka.crud.assembler;

import co.com.sofka.crud.dto.GroupDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.models.Category;
import co.com.sofka.crud.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    public static TodoDTO makeTodoDTO (Todo todo){
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setIdTodo(todo.getId());
        todoDTO.setNameTodo(todo.getName());
        todoDTO.setCompleted(todo.isCompleted());
        /*todoDTO.setGroupId(todo.getGroup().getId());
        todoDTO.setGroupName(todo.getGroup().getName());*/

        return todoDTO;
    }

    public static GroupDTO makeGroupDTO(Category category){

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId(category.getId());
        groupDTO.setName(category.getName());
        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: category.getTodos()){

            todosDTO.add(makeTodoDTO(todo));
        }

        groupDTO.setTodos(todosDTO);

        return groupDTO;
    }
}
