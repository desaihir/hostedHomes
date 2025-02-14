package com.example.trial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example"})
@ComponentScan({"com.example.*"})
//@EntityScan("com.example.pojo")
public class Trial01Application {

    public static void main(String[] args) {
        SpringApplication.run(Trial01Application.class, args);
    }
}
