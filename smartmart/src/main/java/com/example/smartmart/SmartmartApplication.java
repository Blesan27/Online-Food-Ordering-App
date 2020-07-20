package com.example.smartmart;

import com.example.smartmart.File.FIleProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FIleProperties.class
})
public class SmartmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartmartApplication.class, args);
    }

}
