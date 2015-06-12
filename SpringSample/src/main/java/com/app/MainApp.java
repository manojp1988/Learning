package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.manoj.Person;

public class MainApp {

  public static void main(String[] args) {

    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
    context.registerShutdownHook();
    Person p = context.getBean("person", Person.class);
    context.close();
  }

}
