package co.com.sofka.crud.services;

import co.com.sofka.crud.assembler.Assembler;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(Todo todo){return repository.save(todo);}

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
