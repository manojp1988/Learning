package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import beans.PersonExtra;
import beans.PersonExtraInterface;

@Aspect
@Component
public class PersonAspect{ 

	@Pointcut("execution(* beans.Person.setName(String))")
	public void allSetters(){}
	
	@Before("allSetters()")
	public void logEntry(){
		System.out.println("Before method reached !!");
	}
	
	@DeclareParents(defaultImpl=PersonExtra.class,value="beans.Person")
	public static PersonExtraInterface pExtra;
	

}
