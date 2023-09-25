package yaml.jackson.yaml2pojo;

import java.util.List;
import java.util.Map;

public class User {

	private String name;
	private int age;
	private Map<String, String> address;
	private List<String> roles;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, String> getAddress() {
		return address;
	}
	public void setAddress(Map<String, String> address) {
		this.address = address;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", address=" + address + ", roles=" + roles + "]";
	}
}