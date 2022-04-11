package jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class VideouniverseappApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideouniverseappApplication.class, args);
	}

}
