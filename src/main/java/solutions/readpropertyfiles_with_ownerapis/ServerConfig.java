package solutions.readpropertyfiles_with_ownerapis;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:solutions/readpropertyfiles_with_ownerapis/User.properties"})
public interface ServerConfig extends Config {

	//matching exactly with properties key val, hence no mapping req
	int port();
	String hostname();

	//in case some properties missing 
	@DefaultValue("42")
	int maxThreads();
	
	@DefaultValue("false")
	boolean autoRefresh();
	
	//to map properties
	@Key("org.root.user")
	String rootUser();
	
	@Key("new.user.server")
	String newServer();

	
	//Custome obj
	@DefaultValue("John")
	Employee getDefaultEmp(); 

	@DefaultValue("Hello %s")
	Employee wishEmp(String s); 
}