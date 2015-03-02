package com.jonam.spring.datasupport.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jonam.spring.datasupport.dao.PersonDAO;
import com.jonam.spring.datasupport.model.Person;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonDAO personModel = context.getBean("personDAO", PersonDAO.class);
	//	personModel.addPerson(new Person(2, "Bhar"));
		System.out.println(personModel.getTotalNoofPerson());
		System.out.println(personModel.getSinglePerson(123).getName());
		System.out.println(personModel.getAllPerson().size());
	}

}
