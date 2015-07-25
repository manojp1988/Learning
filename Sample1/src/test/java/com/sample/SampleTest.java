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

import com.config.SpringConfiguration;
import com.config.SpringConfiguration.helloService;
import com.model.XmlService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
 //@ContextConfiguration(locations = {"/applicationContext.xml"}),
 @ContextConfiguration(classes = SpringConfiguration.class),
 })
public class SampleTest {

  @Autowired
  helloService hello;

  @Autowired
  XmlService xmlSer;

  @Test
  public void test() {
    // System.out.println(hello.sayHello("Manoj"));

    xmlSer.sayHello("Jeeva");
  }
}
