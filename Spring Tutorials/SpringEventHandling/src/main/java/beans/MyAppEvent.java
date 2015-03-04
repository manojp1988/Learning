package beans;

import org.springframework.context.ApplicationEvent;

public class MyAppEvent extends ApplicationEvent {

	public MyAppEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "My new event..";
	}
}
