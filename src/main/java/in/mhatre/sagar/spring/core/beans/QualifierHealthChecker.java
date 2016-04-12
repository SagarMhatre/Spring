package in.mhatre.sagar.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierHealthChecker {

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
		return "HealthChecker [connector=" + connector + ", dbConnector=" + dbConnector + "]";
	}

	@Autowired
	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	@Autowired
	@Qualifier("useThisQualifiedConnector")
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("qualifier.xml");
		QualifierHealthChecker qualifierHealthChecker = appContext.getBean("qualifierHealthChecker",
				QualifierHealthChecker.class);
		System.out.println(qualifierHealthChecker);
	}

}
