package com.charles.crudspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.charles.crudspring.enums.Category;
import com.charles.crudspring.model.Course;
import com.charles.crudspring.model.Lesson;
import com.charles.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			List<Course> courses = new ArrayList<Course>();

			for (int i = 0; i < 20; i++) {
				Course c = new Course();
				c.setName("Angular com Spring " + i);
				c.setCategory(Category.FRONT_END);

				Lesson l = new Lesson();
				l.setName("Introdução");
				l.setYoutubeUrl("watch?v=30");
				l.setCourse(c);

				c.getLessons().add(l);

				Lesson l3 = new Lesson();
				l3.setName("Introdução");
				l3.setYoutubeUrl("watch?v=20");
				l3.setCourse(c);

				c.getLessons().add(l3);
				courses.add(c);
			}

			courseRepository.saveAll(courses);

		};
	}
}
