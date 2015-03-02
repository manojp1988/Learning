package beans;

import org.springframework.stereotype.Component;

@Component
public class Audii implements Car{
	
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getNoOfGears() {
		return 4;
	}
	
	

}
