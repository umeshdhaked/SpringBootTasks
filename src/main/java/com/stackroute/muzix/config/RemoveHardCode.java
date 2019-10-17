package com.stackroute.muzix.config;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@PropertySource(value = "classpath:data.properties")
public class RemoveHardCode {
    @Value("${track.id}")
    public int id;

    @Value("${track.name}")
    public String name;

    @Value("${track.comment}")
    public String comment;

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public void Print(){
        System.out.println(name);
    }

}
