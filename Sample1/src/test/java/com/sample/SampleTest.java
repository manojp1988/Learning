package com.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.SpringConfiguration;
import com.config.SpringConfiguration.Gatway;
import com.model.XmlService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({@ContextConfiguration(classes = SpringConfiguration.class),
    @ContextConfiguration(locations = {"/applicationContext.xml"})})
public class SampleTest {


  @Autowired
  Gatway gtwy;
  
  @Autowired
  XmlService xmlGtwy;

  @Test
  public void test() {
   // xmlGtwy.sayHello("Manoj");
    gtwy.sayHello("Manoj");
  }

}
