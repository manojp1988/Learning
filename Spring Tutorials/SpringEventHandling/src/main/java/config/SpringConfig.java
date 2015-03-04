package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.Circle;
import beans.Point;


@Configuration
@ComponentScan(basePackages={"beans"})
public class SpringConfig {
	
	@Bean
	public Point pointA(){
		return new Point(1,3);
	}

	@Bean
	public Point pointB(){
		return new Point(4,6);
	}

}
