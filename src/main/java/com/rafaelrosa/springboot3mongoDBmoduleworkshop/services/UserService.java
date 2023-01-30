package com.rafaelrosa.springboot3mongoDBmoduleworkshop.services;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.User;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.dto.UserDTO;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories.UserRepository;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        try {
            Optional<User> newUser = repo.findById(obj.getId());
            User user = newUser.get();
            updateData(user, obj);
            return repo.save(user);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Object not found.");
        }
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
    }
}
