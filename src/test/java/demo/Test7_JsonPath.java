package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import static io.restassured.path.json.JsonPath.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test7_JsonPath {

	
	/**
	 * Extract details as String and fetching further details w/o using json path
	 */
	//@Test
	public void testJsonPath1(){
		String responseAsString=
				when().
					get("http://jsonplaceholder.typicode.com/photos").
				then().
				extract().asString();

		List<Integer> albumIds = from(responseAsString).get("id");		
		System.out.println(albumIds.size());
	}

	
	
	
	
	/**
	 * Extract details as String and fetching further details using JSONPath
	 */
	//@Test
	public void testJsonPath2(){
		String json=
				when().
					get("http://services.groupkt.com/country/get/all").
				then().
				extract().asString();
						
		JsonPath jsonPath = new JsonPath(json).setRoot("RestResponse.result");
		
		List<String> list = jsonPath.get("name");
		System.out.println(list.size());
	}

	
}
