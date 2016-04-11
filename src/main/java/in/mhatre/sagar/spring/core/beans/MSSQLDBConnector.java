package in.mhatre.sagar.spring.core.beans;

public class MSSQLDBConnector implements DBConnector {

	private String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public String toString() {
		return "MSSQLDBConnector [connectionString=" + connectionString + "]";
	}

}
