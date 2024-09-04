package com.entoo.sample.service;

import com.entoo.sample.dao.UserDao;
import com.entoo.sample.entity.User;
import com.entoo.sample.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
        ResponseStructure<User> structure = new ResponseStructure<>();

        Optional<User> optional = dao.findByEmail(user.getEmail());

        if (optional.isEmpty()) {
            // Save the user if it does not exist

            structure.setHttpStatus(HttpStatus.CREATED.value());
            structure.setMessage("User created successfully");
            structure.setBody(dao.saveUser(user)); // Set the newly created user as the body

            // Return a ResponseEntity with CREATED status
            return new ResponseEntity<>(structure, HttpStatus.CREATED);
        } else {
            structure.setHttpStatus(HttpStatus.BAD_REQUEST.value());
            structure.setMessage("User already exists");
            structure.setBody(null);

            return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
        }
    }

    public List<User> fetchUsers() {
        return dao.fetchUser();
    }

    public Optional<User> findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public void deleteByEmail(String email) {
        Optional<User> user = dao.findByEmail(email);
        if (user.isPresent()) {
            dao.deleteByEmail(email);
        }
    }
}
