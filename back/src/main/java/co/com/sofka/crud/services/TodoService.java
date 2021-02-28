package co.com.sofka.crud.services;

import co.com.sofka.crud.assembler.Assembler;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.CategoryRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<TodoDTO> list(){

        Iterable<Todo> todos = repository.findAll();
        List<TodoDTO> todoDTOS = new ArrayList<>();
        for(Todo todo: todos){
            todoDTOS.add(Assembler.makeTodoDTO(todo));
        }
        return todoDTOS;
    }

    public Todo save(TodoDTO todoDTO){
        Todo todo = Assembler.makeTodo(todoDTO);
        todo.setCategory(categoryRepository.findById(todoDTO.getCategoryId()).orElseThrow());
        return repository.save(todo);}

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

    public TodoDTO getDTO(Long id){
        Todo todo = get(id);
        return Assembler.makeTodoDTO(todo);
    }

}
