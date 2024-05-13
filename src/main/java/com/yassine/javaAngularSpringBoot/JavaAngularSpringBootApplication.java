package com.yassine.javaAngularSpringBoot;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.yassine.entities.User;
import com.yassine.repositories.UserRepository;

@Configuration
@SpringBootApplication
@EnableJpaRepositories("com.yassine.repositories")
@EntityScan("com.yassine.entities")   
public class JavaAngularSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaAngularSpringBootApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
