package com.example.hibernatesearchandspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.hibernatesearchandspringboot.repository")
@ComponentScan(basePackages = { "com.example.hibernatesearchandspringboot.configuration",
                                "com.example.hibernatesearchandspringboot.controller",
                                "com.example.hibernatesearchandspringboot.service" })
public class HibernateSearchAndSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateSearchAndSpringBootApplication.class, args);
    }

}
