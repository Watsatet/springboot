package com.entoo.sample.controller;

import com.entoo.sample.entity.User;
import com.entoo.sample.responseStructure.ResponseStructure;
import com.entoo.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@Validated
public class UserController
{
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user)
    {
        return service.saveUser(user);
    }
    @GetMapping
    public List<User> fetchUsers()
    {
        return service.fetchUsers();
    }
    @GetMapping("/{email}")
    public Optional<User> findByEmail(@PathVariable String email)
    {
        return service.findByEmail(email);
    }
    @DeleteMapping("/{email}")
    public void deleteByEmail(@PathVariable String email)
    {
        service.deleteByEmail(email);
    }

}
