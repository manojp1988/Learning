package com.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.SmartContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DelegatingSmartContextLoader;

import com.config.DSLInterceptor;
import com.config.SpringConfiguration;
import com.config.SpringConfiguration.helloService;
import com.model.XmlService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
  @ContextConfiguration(classes = DSLInterceptor.class),
  @ContextConfiguration(classes = SpringConfiguration.class),
 })
public class SampleTest {

  @Autowired
  helloService hello;



  @Test
  public void test() {
    System.out.println(hello.sayHello("Manoj")); 
  }
}
