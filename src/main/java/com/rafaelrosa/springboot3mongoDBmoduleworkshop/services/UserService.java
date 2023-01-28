package com.rafaelrosa.springboot3mongoDBmoduleworkshop.services;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.User;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories.UserRepository;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

    }
}
