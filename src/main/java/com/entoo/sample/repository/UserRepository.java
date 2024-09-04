package com.entoo.sample.repository;

import com.entoo.sample.entity.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String>
{
    @Aggregation(value = {
            "{$match:{email:?0}}"
    })
    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);
}
