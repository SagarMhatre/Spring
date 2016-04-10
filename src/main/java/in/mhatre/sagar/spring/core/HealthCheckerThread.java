package in.mhatre.sagar.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import in.mhatre.sagar.spring.core.beans.HealthChecker;

public class HealthCheckerThread implements ApplicationContextAware, BeanNameAware, Runnable{	
	
	//@Autowired // or @Inject   
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}	

	@Override
	public void run() {
		//HealthChecker healthChecker= applicationContext.getBean("healthChecker", HealthChecker.class);
		HealthChecker healthChecker =  applicationContext.getBean(HealthChecker.class);
		//Since there is only one bean of type HealthChecker, we are getting it by type
		for(int i=0;i<3;i++ ){
			System.out.println(beanName + " performing Health check using : " +healthChecker.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

	private String beanName;
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;		
	}
	
}
