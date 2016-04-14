package in.mhatre.sagar.spring.core.eventing;

import org.json.JSONObject;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent appEvent) {
		JSONObject jsonObject = new JSONObject(appEvent);
		System.out.println("  onApplicationEvent : " + jsonObject.toString());
		
	}

}
