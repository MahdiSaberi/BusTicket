package ir.bustick.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

//ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    @Bean
    public EntityManager testConf(){
        System.out.println("Hello");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        return entityManagerFactory.createEntityManager();
    }
}
