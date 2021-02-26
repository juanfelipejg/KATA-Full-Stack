package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Group;
import co.com.sofka.crud.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repository;

    public Iterable<Group> list(){
        return repository.findAll();
    }

    public Group save(@Valid Group group){return repository.save(group);}

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Group get(Long id){
        return repository.findById(id).orElseThrow();
    }
}
