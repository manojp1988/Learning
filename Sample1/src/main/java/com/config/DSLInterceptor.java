package com.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.messaging.MessageChannel;


@Configuration
@EnableIntegration
public class DSLInterceptor {
  
  @Bean
  public MessageChannel loggerChannel() {
    return MessageChannels.direct()
                          .get();
  }
  
  @Bean public B b(){
    return new B();
  }
  
  @Bean
  @GlobalChannelInterceptor(patterns = "*_EL*", order=3)
  public WireTap wireTap() {
      return new WireTap(loggerChannel());
  }
  
  
  @Bean
  public IntegrationFlow loggerIntFlow() {
    return IntegrationFlows.from(loggerChannel())
                           .handle(new GenericHandler<String>() {
                            public Object handle(String payload, Map<String, Object> headers) {
                              System.out.println("DSL Intercepted" + payload);
                              return null;
                            }})
                           .channel("nullChannel")
                           .get();
  }


}
