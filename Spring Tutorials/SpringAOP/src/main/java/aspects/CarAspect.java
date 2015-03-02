package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import beans.AudiiExtraImpl;
import beans.IAudiiExtra;

@Aspect
@Component
public class CarAspect {
	
	@DeclareParents(defaultImpl=AudiiExtraImpl.class, value="beans.Audii")
	private static IAudiiExtra audiiExtra;

	
}
