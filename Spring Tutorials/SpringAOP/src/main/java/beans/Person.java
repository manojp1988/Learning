package beans;

import org.springframework.stereotype.Component;


@Component
public class Person implements IPerson {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Name="+ name);
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hekko";
	}
	
	

}
