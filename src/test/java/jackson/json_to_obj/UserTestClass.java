package jackson.json_to_obj;

import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Jackson Library:
 * Populating POJOs classes with Json Files
 * 
 * Deserialization Json -> Java Obj
 * @author Sheetal_Singh
 */

public class UserTestClass {

	
	@Test
	public void testApiAttributes() throws IOException{
		String path = "./src/test/java/jackson/json_to_obj/user.json";
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(new File(path), User.class);
		
		//user.getAddress().getCity()
		
		Assert.assertEquals(user.getAge().intValue(), 25,"User age is wrong");
		
		assert user.getphoneNumbers().size() == 3 : "User has more or less phone numbers";
		System.out.println("Done");
	}
}
