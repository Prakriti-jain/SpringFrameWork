package org.example.iocDi;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration - ye spring ko batata hai ki is class ke andar bean banane ka code hai
it is a replacement to beans.xml
iss class ke andar @Bean wale methods hote hai

@Bean - Ye spring ko batata hai iss method se jo object banega, usko Spring manage kare
Method ka return object - Spring Bean
Method name - bean id
Default scope - Singleton
 */

@Configuration
class Bus {
    @Bean
    @Qualifier("toyotaBean")
    public ToyotaEngine engineBean(){
        return new ToyotaEngine();
    }
}

class MEngine {

}

public class ConfigurationsAndBeans {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Bus.class);
        ToyotaEngine bus = context.getBean("engineBean", ToyotaEngine.class);
        bus.start();
    }

}


