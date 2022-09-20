package ir.bustick.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ir.bustick"})
public class WebConfig implements WebMvcConfigurer {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    @Bean
    public EntityManager connectToDB(){
        return entityManagerFactory.createEntityManager();
    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactoryBean(){
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager(){
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public InternalResourceViewResolver resolver() {
//
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//
//        return resolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("resources/");
//
//    }
}
