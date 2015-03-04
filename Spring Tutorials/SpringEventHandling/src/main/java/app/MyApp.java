package app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Circle;
import config.SpringConfig;

public class MyApp {

	public static void main(String[] args) {

		BeanFactory ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		Circle circle = ctx.getBean("circle", Circle.class);
		circle.draw();
		
	}

}
