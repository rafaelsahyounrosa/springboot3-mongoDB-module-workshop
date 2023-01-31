package com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories;


import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
