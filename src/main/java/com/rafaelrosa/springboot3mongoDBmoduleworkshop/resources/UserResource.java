package com.rafaelrosa.springboot3mongoDBmoduleworkshop.resources;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.Post;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.User;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.dto.UserDTO;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id){
        User obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

}
