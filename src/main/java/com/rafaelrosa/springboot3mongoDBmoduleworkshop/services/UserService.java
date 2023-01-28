package com.rafaelrosa.springboot3mongoDBmoduleworkshop.services;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.User;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
