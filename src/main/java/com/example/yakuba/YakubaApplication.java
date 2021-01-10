package com.example.yakuba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author HiromuneMochida
 *
 * https://github.com/HiromuneMochida/yakuba.git
 */
@SpringBootApplication
@ComponentScan("com.example.yakuba")
@EntityScan("com.example.yakuba.entity")
@EnableJpaRepositories("com.example.yakuba.repository")
public class YakubaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YakubaApplication.class, args);
    }

}
