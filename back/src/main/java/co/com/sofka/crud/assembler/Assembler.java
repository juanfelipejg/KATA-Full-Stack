package co.com.sofka.crud.assembler;

import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.CategoryTodoDTO;
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

    public static Todo makeTodo(CategoryTodoDTO categoryTodoDTO){
        Todo todo = new Todo();
        todo.setName(categoryTodoDTO.getNameTodo());
        todo.setCompleted(categoryTodoDTO.isCompleted());

        return todo;
    }

    public static CategoryDTO makeGroupDTO(Category category){

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: category.getTodos()){

            todosDTO.add(makeTodoDTO(todo));
        }

        categoryDTO.setTodos(todosDTO);

        return categoryDTO;
    }
}
