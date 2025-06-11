package dev.sample.productservice;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StartUpLogger {

    @Autowired
    private Environment environment;



    @PostConstruct
    public void logSecrets(){
        String username = environment.getProperty("spring.datasource.username");
        System.out.println("Database Username is : "+username);
    }
}
