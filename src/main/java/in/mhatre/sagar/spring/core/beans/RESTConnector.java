package in.mhatre.sagar.spring.core.beans;

public class RESTConnector implements Connector {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RESTConnector [url=" + url + "]";
	}

}
