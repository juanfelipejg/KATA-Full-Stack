package co.com.sofka.crud.assembler;

import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.CategoryTodoDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.models.Category;
import co.com.sofka.crud.models.Todo;

public class Assembler {

    public static TodoDTO makeTodoDTO (Todo todo){
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setId(todo.getId());
        todoDTO.setName(todo.getName());
        todoDTO.setCompleted(todo.isCompleted());
        todoDTO.setCategoryId(todo.getCategory().getId());

        return todoDTO;
    }

    public static Todo makeTodo(CategoryTodoDTO categoryTodoDTO){
        Todo todo = new Todo();
        todo.setName(categoryTodoDTO.getNameTodo());
        todo.setCompleted(categoryTodoDTO.isCompleted());

        return todo;
    }

    public static Todo makeTodo(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;
    }

    public static Category makeCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        return category;
    }

    public static CategoryDTO makeCategoryDTO(Category category){

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }
}
