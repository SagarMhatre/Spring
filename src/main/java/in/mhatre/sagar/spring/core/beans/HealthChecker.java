package in.mhatre.sagar.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class HealthChecker {

	private Connector connector;
	private DBConnector dbConnector;

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	@Override
	public String toString() {
		return "HealthChecker [connector=" + connector + ", dbConnector=" + dbConnector + "]";
	}

	public DBConnector getDbConnector() {
		return dbConnector;
	}

	@Autowired
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	

}
