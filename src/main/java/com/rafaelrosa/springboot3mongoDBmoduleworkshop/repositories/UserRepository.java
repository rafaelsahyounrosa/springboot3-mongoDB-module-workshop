package com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories;


import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
