package com.rafaelrosa.springboot3mongoDBmoduleworkshop.config;


import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.Post;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.domain.User;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.dto.AuthorDTO;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories.PostRepository;
import com.rafaelrosa.springboot3mongoDBmoduleworkshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, "Trip!!", "Trip to rio!", sdf.parse("21/01/2018"),new AuthorDTO(maria));
        Post post2 = new Post(null, "Good Morning!!", "Arrived!", sdf.parse("22/01/2018"), new AuthorDTO(maria));

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
