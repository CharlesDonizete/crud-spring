package com.charles.crudspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			List<Course> courses = new ArrayList<Course>();

			Course c = new Course();
			c.setName("Angular com Spring ");
			c.setCategory(Category.FRONT_END);

			Lesson l = new Lesson();
			l.setName("Introdução");
			l.setYoutubeUrl("watch?v=1");
			l.setCourse(c);

			c.getLessons().add(l);

			Lesson l3 = new Lesson();
			l3.setName("Introdução");
			l3.setYoutubeUrl("watch?v=2");
			l3.setCourse(c);

			c.getLessons().add(l3);

			courses.add(c);

			Course c1 = new Course();
			c1.setName("Spring");
			c1.setCategory(Category.BACK_END);

			Lesson l1 = new Lesson();
			l1.setName("Introdução 2");
			l1.setYoutubeUrl("watch?v=1");
			l1.setCourse(c1);

			c1.getLessons().add(l1);

			courses.add(c1);

			Course c2 = new Course();
			c2.setName("ExtJS");
			c2.setCategory(Category.FRONT_END);

			Lesson l2 = new Lesson();
			l2.setName("Introdução 3");
			l2.setYoutubeUrl("watch?v=1");
			l2.setCourse(c2);

			c2.getLessons().add(l2);

			courses.add(c2);

			courseRepository.saveAll(courses);

		};
	}
}
