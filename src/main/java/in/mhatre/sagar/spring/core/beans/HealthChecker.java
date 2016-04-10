package in.mhatre.sagar.spring.core.beans;

public class HealthChecker {

	private Connector connector;

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	@Override
	public String toString() {
		return "HealthChecker [connector=" + connector + "]";
	}

}
