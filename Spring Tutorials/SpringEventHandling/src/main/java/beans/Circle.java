package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class Circle implements ApplicationEventPublisherAware{
	
	ApplicationEventPublisher publisher;
	
	@Autowired
	@Qualifier(value="pointA")
	Point center;
	
	public void draw(){
		System.out.println("Drawing.. ");
		publisher.publishEvent(new MyAppEvent(this));
		
		System.out.println("X= "+center.getX());
		System.out.println("Y= "+center.getY());
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher =  arg0;
	}
	
}
