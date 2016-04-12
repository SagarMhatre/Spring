package in.mhatre.sagar.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
	@Qualifier("useThisQualifiedConnector")
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	

}
