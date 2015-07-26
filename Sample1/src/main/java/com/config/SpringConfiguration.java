package com.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.GenericHandler;


/**
 * Created by manojperiathambi on 7/15/15.
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan(basePackages="com.config")
public class SpringConfiguration {

  @Autowired B b;
  
  @Autowired WireTap wireTap;
  
  @Bean
  public IntegrationFlow sayHelloFlow() {
    return IntegrationFlows.from("say_EL_Hello")
                           .handle(new GenericHandler<String>() {
                             public String handle(String payload, Map headers) {
                               System.out.println(b.getName());
                               System.out.println(wireTap.hashCode());
                               return "Hello " + payload;
                             }
                           })
                           .get();
  }

  @MessagingGateway
  public interface helloService {
    @Gateway(requestChannel = "say_EL_Hello")
    public String sayHello(String msg);
  }



}
