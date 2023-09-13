package com.charles.crudspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.charles.crudspring.enums.Category;
import com.charles.crudspring.model.Course;
import com.charles.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();			

			List<Course> courses = new ArrayList<Course>();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory(Category.FRONT_END);

			courses.add(c);

			Course c1 = new Course();
			c1.setName("Spring");
			c1.setCategory(Category.BACK_END);

			courses.add(c1);

			Course c2 = new Course();
			c2.setName("ExtJS");
			c2.setCategory(Category.FRONT_END);

			courses.add(c2);

			courseRepository.saveAll(courses);

		};
	}
}
