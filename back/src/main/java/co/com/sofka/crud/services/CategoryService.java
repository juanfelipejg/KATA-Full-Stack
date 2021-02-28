package co.com.sofka.crud.services;

import co.com.sofka.crud.assembler.Assembler;
import co.com.sofka.crud.dto.CategoryTodoDTO;
import co.com.sofka.crud.models.Category;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.CategoryRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Category> list(){
        return repository.findAll();
    }

    public Category save(@Valid Category category){return repository.save(category);}

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Category get(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Todo addTodo (CategoryTodoDTO categoryTodoDTO){
        Todo todo = Assembler.makeTodo(categoryTodoDTO);
        todo.setCategory(get(categoryTodoDTO.getIdCategory()));
        return todoRepository.save(todo);
    }
}
