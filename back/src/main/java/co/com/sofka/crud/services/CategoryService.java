package co.com.sofka.crud.services;

import co.com.sofka.crud.assembler.Assembler;
import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.CategoryTodoDTO;
import co.com.sofka.crud.dto.MainDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.models.Category;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.CategoryRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<CategoryDTO> list(){

        Iterable<Category> categories= repository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for(Category category: categories){

            categoryDTOS.add(Assembler.makeCategoryDTO(category));
        }

        return categoryDTOS;
    }
    public Category save(@Valid CategoryDTO categoryDTO){
        Category category = Assembler.makeCategory(categoryDTO);
        return repository.save(category);}

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Category get(Long id){
        return repository.findById(id).orElseThrow();
    }

    public CategoryDTO getDTO(Long id){
        Category category = get(id);
        return Assembler.makeCategoryDTO(category);
    }

    public MainDTO showAll(){

        MainDTO mainDTO = new MainDTO();

        mainDTO.setCategories(list());
        Iterable<Todo> todos = todoRepository.findAll();
        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: todos){
            todosDTO.add(Assembler.makeTodoDTO(todo));
        }
        mainDTO.setTodos(todosDTO);

        return mainDTO;
    }

    public Todo addTodo (CategoryTodoDTO categoryTodoDTO){
        Todo todo = Assembler.makeTodo(categoryTodoDTO);
        todo.setCategory(get(categoryTodoDTO.getIdCategory()));
        return todoRepository.save(todo);
    }

}
