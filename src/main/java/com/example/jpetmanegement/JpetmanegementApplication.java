package com.example.jpetmanegement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.jpetmanegement.persistence")
public class JpetmanegementApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpetmanegementApplication.class, args);
    }

}
