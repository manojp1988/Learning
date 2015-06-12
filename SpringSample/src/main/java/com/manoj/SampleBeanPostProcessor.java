package com.manoj;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SampleBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
    System.out.println("postProcessAfterInitialization");
    return null;
  }

  @Override
  public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
    System.out.println("postProcessBeforeInitialization");
    return null;
  }

}
