package gson.obj_to_json;

public class UserNested {  
    String name;
    String email;
    boolean isDeveloper;
    int age;
    UserAddress userAddress;

	public UserNested(String name, String email, boolean isDeveloper, int age,
			UserAddress userAddress) {
		super();
		this.name = name;
		this.email = email;
		this.isDeveloper = isDeveloper;
		this.age = age;
		this.userAddress = userAddress;
	}
    
}