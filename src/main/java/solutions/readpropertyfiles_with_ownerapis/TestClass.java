package solutions.readpropertyfiles_with_ownerapis;

import org.aeonbits.owner.ConfigFactory;

public class TestClass {

	public static void basics() {
		ServerConfig obj = ConfigFactory.create(ServerConfig.class);
		System.out.println("Server: " + obj.hostname());
		System.out.println("Port: " + obj.port());
		System.out.println("Max Thread: " + obj.maxThreads());
		System.out.println("Auto Refresh: " + obj.autoRefresh());
		System.out.println("Root User: " + obj.rootUser());
	}
	
	public static void readFromDifferentProperttFile() {
		ServerConfig obj = ConfigFactory.create(ServerConfig.class);
		System.out.println("New Server: " + obj.newServer());
	}

	public static void readCustomClasses() {
		ServerConfig obj = ConfigFactory.create(ServerConfig.class);
		System.out.println("Default Emp: " + obj.getDefaultEmp().getName());
		System.out.println("Wish Emp: " + obj.wishEmp("Bob").getName());
	}

	
	public static void main(String[] args) {
		//TestClass.basics();
		//TestClass.readFromDifferentProperttFile();
		
		TestClass.readCustomClasses();
		
	}

}
