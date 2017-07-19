package test.automobili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class AutoApplication 
	extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		 SpringApplication.run(AutoApplication.class, args);
	}

}
