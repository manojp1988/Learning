package beans;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class Circle implements ApplicationEventPublisherAware{
	
	ApplicationEventPublisher publisher;
	
	public void draw(){
		System.out.println("Drawing.. ");
		publisher.publishEvent(new MyAppEvent(this));
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher =  arg0;
	}
	
}
