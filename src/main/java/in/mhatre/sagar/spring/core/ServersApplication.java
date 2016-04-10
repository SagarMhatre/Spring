package in.mhatre.sagar.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.mhatre.sagar.spring.core.beans.ServersStore;

public class ServersApplication {
	
	static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext("servers-spring.xml");
		usingBeanInheritance();		
	}

	
	public static void usingBeanInheritance(){
		ServersStore serversStore= applicationContext.getBean("allServers", ServersStore.class);
		System.out.println(serversStore.toString());
	}
}
