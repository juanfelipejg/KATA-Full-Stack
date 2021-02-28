package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.CategoryTodoDTO;
import co.com.sofka.crud.dto.MainDTO;
import co.com.sofka.crud.models.Category;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "api/categories")
    public Iterable<CategoryDTO> list(){
        return service.list();
    }

    @PostMapping(value = "api/category")
    public Category save(@Valid @RequestBody CategoryDTO categoryDTO){
        return service.save(categoryDTO);
    }

    @PutMapping(value = "api/category")
    public Category update(@RequestBody CategoryDTO categoryDTO){
        if(categoryDTO.getId() != null){
            return service.save(categoryDTO);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/category")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/category")
    public CategoryDTO get(@PathVariable("id") Long id){
        return service.getDTO(id);
    }

    @GetMapping("api/showAll")
    public MainDTO listInterfaz(){return service.showAll();}

    @PostMapping(value = "api/{id}/addTodo")
    public Todo addTodo(@Valid @RequestBody CategoryTodoDTO categoryTodoDTO){
        return service.addTodo(categoryTodoDTO);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}
