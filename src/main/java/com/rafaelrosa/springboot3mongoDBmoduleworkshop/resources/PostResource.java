package com.rafaelrosa.springboot3mongoDBmoduleworkshop.resources;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.Post;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
