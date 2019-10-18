package com.stackroute.muzix;

import com.stackroute.muzix.config.RemoveHardCode;
import com.stackroute.muzix.controller.MyPropertiesTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.stackroute.muzix")
@SpringBootApplication
@EnableConfigurationProperties(MyPropertiesTest.class)
public class MuzixApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MuzixApplication.class, args);
    }


    @Value("${my-properties.name}")
    public String name;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("my-properties.name="+name);
    }

    @Bean
    ApplicationRunner applicationRunner(MyPropertiesTest myPropertiesTest){
        return args -> {
            System.out.println(myPropertiesTest);
        };

    }


}
