package in.mhatre.sagar.spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import in.mhatre.sagar.spring.core.beans.Connector;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		//usingSpringBeanFactory();
		usingApplicationContext();
	}
	
	@Deprecated
	public static void usingSpringBeanFactory(){
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		// It is unable to read from \src\main\resources\spring.xml
		Connector connector  = (Connector) beanFactory.getBean("connector");		
		//<bean id="connector" class=" "></bean>
		// By changing the class name in the XML, we can return a different subtype
		System.out.println(connector.toString());
	}
	
	public static void usingApplicationContext(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		// Connector connector  = (Connector) applicationContext.getBean("connector");
		Connector connector  = applicationContext.getBean("connector", Connector.class);		
		// <bean id="connector" class=" "></bean>
		// By changing the class name in the XML, we can return a different subtype
		System.out.println(connector.toString());		
	}	
}
