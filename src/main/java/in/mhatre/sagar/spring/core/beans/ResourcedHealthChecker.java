package in.mhatre.sagar.spring.core.beans;

import javax.annotation.Resource;

public class ResourcedHealthChecker {
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
		return "ResourcedHealthChecker [connector=" + connector + ", dbConnector=" + dbConnector + "]";
	}

	@Resource
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	@Resource(name = "restConnector")
	public void setConnector(Connector connector) {
		this.connector = connector;
	}
}
