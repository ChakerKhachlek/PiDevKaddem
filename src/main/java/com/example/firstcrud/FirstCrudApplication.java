package com.example.firstcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
//@EnableAspectJAutoProxy
public class FirstCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstCrudApplication.class, args);
    }

}
