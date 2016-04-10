package in.mhatre.sagar.spring.core.beans;

import java.util.Collection;

public class ServersStore {
	private Collection<Server> servers;

	public Collection<Server> getServers() {
		return servers;
	}

	public void setServers(Collection<Server> servers) {
		this.servers = servers;
	}

	@Override
	public String toString() {
		return "ServersStore [servers=" + servers + "]";
	}	
	
}
