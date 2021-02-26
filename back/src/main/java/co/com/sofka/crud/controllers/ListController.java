package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.Group;
import co.com.sofka.crud.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListController {

    @Autowired
    private GroupService service;

    @GetMapping(value = "api/groups")
    public Iterable<Group> list(){
        return service.list();
    }

    @PostMapping(value = "api/group")
    public Group save(@RequestBody Group group){
        return service.save(group);
    }

    @PutMapping(value = "api/group")
    public Group update(@RequestBody Group group){
        if(group.getId() != null){
            return service.save(group);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/group")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/group")
    public Group get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
