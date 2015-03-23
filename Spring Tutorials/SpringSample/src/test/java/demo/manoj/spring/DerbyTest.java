package demo.manoj.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derby.Person;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/META-INF/spring/app-context.xml" }) 
public class DerbyTest  {

	@Autowired
	Person person;
	
	@Test
	public void test() {
		System.out.println("Person="+person);
	}

}