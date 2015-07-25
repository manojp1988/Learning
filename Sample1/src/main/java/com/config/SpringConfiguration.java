package com.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.messaging.MessageChannel;


/**
 * Created by manojperiathambi on 7/15/15.
 */
@Configuration
@ComponentScan(basePackages = "com.model")
@EnableIntegration
@IntegrationComponentScan
public class SpringConfiguration {

  @MessagingGateway
  public interface Gatway {

    @Gateway(requestChannel = "service_EL_Chnl")
    public String sayHello(String name);
  }

  @Bean
  public IntegrationFlow sayHelloIntFlow() {
    return IntegrationFlows.from("service_EL_Chnl")
                           .handle(new GenericHandler<String>() {

                             public Object handle(String payload, Map<String, Object> headers) {

                               return "Hello " + payload;
                             }
                           })
                           .get();
  }

  @Bean
  public MessageChannel bar() {
    return new DirectChannel();
  }

  @Bean
  @GlobalChannelInterceptor(patterns = "*_EL_*")
  public WireTap baz() {
    return new WireTap(this.bar());
  }

  @Bean
  public IntegrationFlow interceptFlow() {
    return IntegrationFlows.from(bar())
                           .handle(new GenericHandler<String>() {

                             public Object handle(String payload, Map<String, Object> headers) {
                               System.out.println("Intercepted Payload " + payload);
                               return "Intercepted Payload " + payload;
                             }
                           })
                           .get();
  }

}
