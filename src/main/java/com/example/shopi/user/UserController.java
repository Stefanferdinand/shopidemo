package com.example.shopi.user;

import com.example.shopi.log.LOGSTATE;
import com.example.shopi.utils.ItemNotFoundException;
import com.example.shopi.utils.ShopiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    public UserRepository repository;
    public ShopiLogger logger;

    @Autowired
    public UserController(UserRepository repository, ShopiLogger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        logger.log(LOGSTATE.INFO, "Success getting all " + User.class.getName(), UserController.class.getName());
        System.out.println("DSDSAD");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable long id){
        User result = repository.findById(id).orElseThrow(ItemNotFoundException::new);
        logger.log(LOGSTATE.INFO, "Success getting " + User.class.getName() + " with id: " + id, UserController.class.getName());
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){
        user.setPassword("bca123");
        User result = repository.save(user);
        logger.log(LOGSTATE.INFO, "Success creating " + User.class.getName(), UserController.class.getName());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        repository.deleteById(id);
        logger.log(LOGSTATE.INFO, "Success deleting " + User.class.getName(), UserController.class.getName());
        return ResponseEntity.noContent().build();
    }
}
