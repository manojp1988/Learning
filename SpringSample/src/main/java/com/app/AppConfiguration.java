package com.app;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.Manoj")
public class AppConfiguration {

  
 @Bean
 public PropertyPlaceholderConfigurer properties(){
   return new PropertyPlaceholderConfigurer();
 }
}
