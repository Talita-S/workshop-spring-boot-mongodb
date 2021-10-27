package com.fatec.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fatec.workshopmongo.domain.Post;
import com.fatec.workshopmongo.domain.User;
import com.fatec.workshopmongo.dto.AuthorDTO;
import com.fatec.workshopmongo.repository.PostRepository;
import com.fatec.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Raymond Holt", "raymond@gmail.com");
		User u2 = new User(null, "Rosa Diaz", "rosa@gmail.com");
		User u3 = new User(null, "Jake Peralta", "jake@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post post1 = new Post(null, sdf.parse("19/03/2021"), "I've already setup my Twitter account", "You can find me on @5261796d6e6420", new AuthorDTO(u1));
		Post post2 = new Post(null, sdf.parse("21/10/2021"), "I am retiring from the NYPD", "I need to spend more time with my husband and Cheddar", new AuthorDTO(u1));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
