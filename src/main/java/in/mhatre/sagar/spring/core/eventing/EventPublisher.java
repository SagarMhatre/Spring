package in.mhatre.sagar.spring.core.eventing;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Imports required if implementing ApplicationContext
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;



@Component
public class EventPublisher implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;		
	}
	
	public boolean sendEvent(ApplicationEvent applicationEvent){
		applicationEventPublisher.publishEvent(applicationEvent);
		return true;
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("event.xml");
		
		EventPublisher eventPublisher = applicationContext.getBean("eventPublisher", EventPublisher.class);
		
		for(int i=0,j=20; i<10; i++,j--){
			//MyCustomEvent myCustomEvent = new MyCustomEvent(null); 
							//java.lang.IllegalArgumentException: null source			
			MyCustomEvent myCustomEvent = new MyCustomEvent(new ComplexNumber(i,j));
							// Send Any object
			myCustomEvent.setMyData("This is my Custom Event " + i);			
			eventPublisher.sendEvent(myCustomEvent);		
			// ApplicationContext also extends ApplicationEventPublisher. But better use the interface
			myCustomEvent.setMyData("Sending through  applicationContext " + i);
			applicationContext.publishEvent(myCustomEvent);
		}
		
		
	}

	
}
