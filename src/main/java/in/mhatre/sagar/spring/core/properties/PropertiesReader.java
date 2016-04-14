package in.mhatre.sagar.spring.core.properties;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesReader {

	MessageSource msgSrc;

	public MessageSource getMsgSrc() {
		return msgSrc;
	}

	@Autowired 
	//byType since there is only one bean of type ResourceBundleMessageSource which implements MessageSource
	// Also, requires <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/> 
	// OR  <context:annotation-config/>
	public void setMsgSrc(MessageSource msgSrc) {
		this.msgSrc = msgSrc;
	}

	public void displayProperties() {
		System.out.println("displayProperties using private variable ");
		System.out.println(msgSrc.getMessage("basicProperty1", null, "default value 1", Locale.US));
		System.out.println(msgSrc.getMessage("basicProperty1", null, "default value 1", null)); 
		System.out.println(msgSrc.getMessage("basicProperty1", null, "default value 1", Locale.GERMAN));
		System.out.println(msgSrc.getMessage("basicProperty1", null, "default value 1", Locale.FRANCE));
		System.out.println(msgSrc.getMessage("basicProperty2", null, "default value 2", Locale.getDefault()));
		System.out.println(msgSrc.getMessage("basicProperty3", null, "default value 3", Locale.getDefault()));
		System.out.println(msgSrc.getMessage("advanceProperty", new Object[] { "such", "beautiful" },
				"default value for advanceProperty", Locale.US));

	}

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("properties.xml");	
		
		PropertiesReader propertiesReader = applicationContext.getBean("propertiesReader", PropertiesReader.class);
		propertiesReader.displayProperties();

		// ApplicationContext & ResourceBundleMessageSource both implement MessageSource which has the getMessage method
				
		System.out.println("using applicationContext ");

		System.out.println(applicationContext.getMessage("basicProperty1", null, "default value 1", Locale.US)); 
			// hello in default
		System.out.println(applicationContext.getMessage("basicProperty1", null, "default value 1", null)); 
			// hello in default		
		System.out.println(applicationContext.getMessage("basicProperty1", null, "default value 1", Locale.GERMAN));
			// hello in default
		System.out.println(applicationContext.getMessage("basicProperty1", null, "default value 1", Locale.FRANCE));
			// hello  in _FR
		System.out.println(applicationContext.getMessage("basicProperty2", null, "default value 2", Locale.getDefault()));
			// world in default
		System.out.println(applicationContext.getMessage("basicProperty3", null, "default value 3", Locale.getDefault()));
			// default value 3
		System.out.println(applicationContext.getMessage("advanceProperty", new Object[] { "such", "beautiful" },
				"default value for advanceProperty", Locale.US));
			// This is {0} a {1} day & a {1} morning => This is such a beautiful day & a beautiful morning
	}

}
