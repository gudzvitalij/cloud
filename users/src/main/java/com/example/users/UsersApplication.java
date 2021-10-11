package com.example.users;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication {
    private final Log logger = LogFactory.getLog(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}
