package com.todo.list.mytodolist;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MytodolistApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MytodolistApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MytodolistApplication.class);
    }
}
