package com.rafaelrosa.springboot3mongoDBmoduleworkshop.services;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.Post;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories.PostRepository;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

    }
}