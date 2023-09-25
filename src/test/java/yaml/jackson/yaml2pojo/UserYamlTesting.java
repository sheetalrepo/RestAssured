package yaml.jackson.yaml2pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
	
import java.io.File;


public class UserYamlTesting {

	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		User user = null;
		try {
			File file = new File(".\\src\\test\\java\\yaml\\jackson\\yaml2pojo\\read_user.yaml");
			user = objectMapper.readValue(file, User.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(user.getName());
		System.out.println(user.getRoles());
		System.out.println(user.getAddress());

	}

}
