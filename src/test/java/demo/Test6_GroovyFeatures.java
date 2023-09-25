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

public class Test6_GroovyFeatures {

	/**
	 * Verify is some expected name present in response or not
	 */
	//@Test
	public void testPresenceOfElements(){
		given().
			get("http://services.groupkt.com/country/search?text=lands").
		then().
			body("RestResponse.result.name", hasItems("Cayman Islands","Cook Islands")).log().all();
	}
	
	
	
	/**
	 * RestAssured implemented in Groovy and hence Groovy advantages can be taken
	 * 
	 * Here we are adding length of all "alpha2_code" code coming in response
	 */
	//@Test
	public void testLengthOfResponse(){
		when().
	       get("http://services.groupkt.com/country/search?text=islands").
		then().
	       body("RestResponse.result.alpha3_code*.length().sum()", greaterThan(40));
	}
	

	
	
	/**
	 * To get all attribute as List
	 */
	//@Test
	public void testGetResponseAsList(){
		String response = get("http://services.groupkt.com/country/search?text=lands").asString();

		List<String> ls = from(response).getList("RestResponse.result.name");
		
		System.out.println("ListSize: "+ls.size());
		for(String country: ls){
			if(country.equals("Solomon Islands"))
				System.out.println("Found my place");
		}
	}
	
	
	
	
	
	/**
	 * To get response as List and apply some conditions on it
	 * 
	 * The groovy has an implicit variable called 'it' which represents the current item in the list
	 * 
	 */
	//@Test
	public void testConditionsOnList(){
		String response = get("http://services.groupkt.com/country/search?text=lands").asString();
		List<String> ls = from(response).getList("RestResponse.result.findAll { it.name.length() > 30 }.name");
		System.out.println(ls);  //[South Georgia and the South Sandwich Islands]
	}
	
}
