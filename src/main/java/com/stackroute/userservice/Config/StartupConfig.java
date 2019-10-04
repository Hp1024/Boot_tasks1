package com.stackroute.userservice.Config;

import com.stackroute.userservice.LogicOnStartup.UsingApplicationListener;
import com.stackroute.userservice.LogicOnStartup.UsingCommandLineRunner;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class StartupConfig {
    @Autowired
    private MovieService movieService;
    @Bean
    public UsingApplicationListener applicationListener(){
        UsingApplicationListener usingApplicationListener=new UsingApplicationListener(movieService);
        return usingApplicationListener;
    }
    @Bean
    public UsingCommandLineRunner commandLineRunner(){
        UsingCommandLineRunner usingCommandLineRunner=new UsingCommandLineRunner(movieService);
        return usingCommandLineRunner;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
