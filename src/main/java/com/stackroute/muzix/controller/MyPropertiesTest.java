package com.stackroute.muzix.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ConfigurationProperties("my-properties")
public class MyPropertiesTest {

    private int id;
    private String name;
    private String comment;

}
