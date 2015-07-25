package com.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;


/**
 * Created by manojperiathambi on 7/15/15.
 */
@Configuration
@ComponentScan(basePackages = "com.model")
@EnableIntegration
@IntegrationComponentScan
@ImportResource(value="/applicationContext.xml")
public class SpringConfiguration {

  @Bean
  public MessageChannel traceChannel() {
    return MessageChannels.direct("TRACE_EL_CHANL")
                          .interceptor(new WireTap(loggerChannel()))
                          .get();
  }

  @Bean
  public MessageChannel loggerChannel() {
    return MessageChannels.queue()
                          .get();
  }

  @Bean
  public IntegrationFlow sayHelloFlow() {
    return IntegrationFlows.from("say_EL_Hello")
                           .handle(new GenericHandler<String>() {

                             public String handle(String payload, Map headers) {
                               // TODO Auto-generated method stub
                               return "Hello " + payload;
                             }
                           })
                           .get();
  }

  @Bean(name = PollerMetadata.DEFAULT_POLLER)
  public PollerMetadata poller() { // 12
    return Pollers.fixedDelay(1000)
                  .get();
  }

  @MessagingGateway
  public interface helloService {
    @Gateway(requestChannel = "say_EL_Hello")
    public String sayHello(String msg);
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
