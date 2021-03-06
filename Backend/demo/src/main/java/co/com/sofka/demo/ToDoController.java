package co.com.sofka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    private  ToDoService service;

    @GetMapping(value = "api/todos")
    public Iterable <ToDo> list(){
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public  ToDo save (@RequestBody ToDo todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public  ToDo update (@RequestBody ToDo todo){
        if(todo.getId() != null) {
            return service.save(todo);
        }
        throw  new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public  ToDo get(@PathVariable("id") Long id){
        return service.get(id);
    }
}

