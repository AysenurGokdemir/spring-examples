package com.aysenur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories //mongo repositorylerini devreye almasını soyluyoruz dependncyInjection'a
public class Application {
public static void main(String[] args) {
    SpringApplication.run(Application.class,args);

    }
}
