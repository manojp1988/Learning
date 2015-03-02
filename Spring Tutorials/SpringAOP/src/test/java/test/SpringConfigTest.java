package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import beans.IPerson;
import beans.PersonExtraInterface;
import config.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class SpringConfigTest {

	@Autowired
	IPerson person;
	
	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void testSpringConfig(){
		
		assertNotNull(person);
		assertEquals("Hekko",person.sayHello());
		PersonExtraInterface extra = (PersonExtraInterface)person;
		assertEquals("Jeeva", extra.getWifeName());
		
	}
	
	
}
