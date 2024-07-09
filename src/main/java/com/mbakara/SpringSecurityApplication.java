package com.mbakara;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityApplication {

    @Bean
    public ModelMapper modelMapper(){
         return new ModelMapper(); // ModelMapper is a library that maps objects to objects.


    }


    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
