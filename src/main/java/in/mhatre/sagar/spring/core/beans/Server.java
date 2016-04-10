package in.mhatre.sagar.spring.core.beans;

import org.springframework.beans.factory.BeanNameAware;

public class Server implements BeanNameAware{
	private String url;
	private Connector connector;
	private String serverName;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Connector getConnector() {
		return connector;
	}
	public void setConnector(Connector connector) {
		this.connector = connector;
	}
	
	@Override
	public String toString() {
		return serverName + " Server [url=" + url + ", connector=" + connector + "]";
	}
	@Override
	public void setBeanName(String beanName) {
		this.serverName = beanName;
		
	}
	
}
