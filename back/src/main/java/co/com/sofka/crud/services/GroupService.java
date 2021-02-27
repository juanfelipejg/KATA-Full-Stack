package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Category;
import co.com.sofka.crud.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repository;

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
}
