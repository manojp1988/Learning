package demo.manoj.app.si.filters;

import org.springframework.messaging.Message;

import demo.manoj.app.si.Person;

public class AgeFilter {

	public boolean ageFilter(Message<Person> message) throws Exception {
		Person person = (Person) message.getPayload();
		//if(true) throw new Exception("Exception occured");
		return person.getAge() > 18;
	}

}
