package in.mhatre.sagar.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.mhatre.sagar.spring.core.beans.ResourcedHealthChecker;
import in.mhatre.sagar.spring.core.beans.ServersStore;

public class ResourceApplication {
	
	static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext("resource.xml");
		usingBeanInheritance();
	}
	
	public static void usingBeanInheritance(){
		ResourcedHealthChecker resourcedHealthChecker= applicationContext.getBean("resourcedHealthChecker", ResourcedHealthChecker.class);
		System.out.println(resourcedHealthChecker.toString());
	}
}
