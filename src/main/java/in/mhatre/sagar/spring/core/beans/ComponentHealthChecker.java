package in.mhatre.sagar.spring.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
//import org.springframework.context.ApplicationContext;
//AbstractApplicationContext provides the registerShutdownHook() method . Else, the @PreDestroy method is not being called 
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ComponentHealthChecker {
	private Connector connector;
	private DBConnector dbConnector;

	public Connector getConnector() {
		return connector;
	}

	public DBConnector getDbConnector() {
		return dbConnector;
	}

	@Override
	public String toString() {
		return "ComponentHealthChecker [connector=" + connector + ", dbConnector=" + dbConnector + "]";
	}

	@Resource
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	@Resource(name = "restConnector")
	public void setConnector(Connector connector) {
		this.connector = connector;
	}
	
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("component.xml");
		ComponentHealthChecker componentHealthChecker = appContext.getBean("componentHealthChecker",
				ComponentHealthChecker.class);
		System.out.println(componentHealthChecker);
		//appContext.close();
		appContext.registerShutdownHook();
	}
	
	@PostConstruct
	public void thisMethodIsCalledAfterBeanIsCreated(){
		System.out.println("Bean Created : " + this);
	}
	
	@PreDestroy
	public void thisMethodIsCalledBeforeBeanIsDestroyed(){
		System.out.println("Bean will be Destroyed : " + this);
	}
}
