package com.entoo.sample.dao;

import com.entoo.sample.entity.User;
import com.entoo.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDao
{
    @Autowired
    private UserRepository repository;
    public User saveUser(User user)
    {
        return repository.save(user);
    }

    public List<User> fetchUser()
    {
        return repository.findAll();
    }

    public Optional<User> findByEmail(String email)
    {
        return repository.findByEmail(email);
    }

    public void deleteByEmail(String email)
    {
        repository.deleteByEmail(email);
    }
}
