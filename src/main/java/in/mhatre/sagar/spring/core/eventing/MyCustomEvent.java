package in.mhatre.sagar.spring.core.eventing;

import org.springframework.context.ApplicationEvent;

public class MyCustomEvent extends ApplicationEvent {

	private String myData;
	
	public MyCustomEvent(Object source) {
		super(source);		
	}

	public String getMyData() {
		return myData;
	}

	public void setMyData(String myData) {
		this.myData = myData;
	}	
	

}
