package org.example.Annotations;

/*
Profile - define different configurations for different environments - dev, prod, test.
Conditional bean loading
Environment-based configuration
Safe deployment
Clean architecture

- it is used for - Classes, @Configuration Classes, @Bean methods
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

interface DataSource {
    String getData();
}
@Component
@Profile("dev")
class DevDataSource implements DataSource {

    @Override
    public String getData() {
        return "this is dev";
    }
}

@Component
@Profile("prod")
class ProdDataSource implements DataSource {

    @Override
    public String getData() {
        return "this is prod";
    }
}

@SpringBootApplication
public class ProfileClass {
    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(ProfileClass.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(ProfileClass.class);
        DataSource ds = context.getBean(DataSource.class);
        System.out.println(ds.getData());

    }
}
