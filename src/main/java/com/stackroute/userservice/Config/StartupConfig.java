package com.stackroute.userservice.Config;

import com.stackroute.userservice.LogicOnStartup.UsingApplicationListener;
import com.stackroute.userservice.LogicOnStartup.UsingCommandLineRunner;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
