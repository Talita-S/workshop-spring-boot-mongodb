package com.fatec.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fatec.workshopmongo.domain.User;
import com.fatec.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "Lynnete Scavo", "lynnete@gmail.com");
		User u2 = new User(null, "Rosa Diaz", "rosa@gmail.com");
		User u3 = new User(null, "Jake Peralta", "jake@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}

}
