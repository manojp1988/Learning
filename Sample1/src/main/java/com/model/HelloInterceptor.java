package com.model;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

public class HelloInterceptor extends ChannelInterceptorAdapter {

  @Override
  public Message<?> preSend(Message<?> message, MessageChannel channel) {
    System.out.println("Success");
    return message;
  }

}
