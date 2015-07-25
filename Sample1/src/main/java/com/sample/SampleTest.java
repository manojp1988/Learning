package com.sample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.SpringConfiguration;
import com.config.SpringConfiguration.Gatway;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({@ContextConfiguration(classes = SpringConfiguration.class),
    @ContextConfiguration(locations = {"applicationContext.xml"})})
public class SampleTest {


  @Autowired
  Gatway gtwy;

  @Test
  public void test() {
    System.out.println(gtwy.sayHello("Manoj"));
  }

}
