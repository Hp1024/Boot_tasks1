package com.stackroute.userservice.config;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    public ServletRegistrationBean h2console(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console");
        return registrationBean;
    }
}
