package it.bit.academy.corsopiu;

import it.bit.academy.corsopiu.entities.Gender;
import it.bit.academy.corsopiu.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorsopiuApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsopiuApplication.class, args);
	}

}
