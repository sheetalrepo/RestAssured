package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;


/**
 * Basic + Digestive authentication
 * 
 * @author sheetalsingh
 *
 */
public class Test20_BasicAndDigestiveAuthentications {



	/**
	 * Challenged Basic Authentication
	 * (minimum two req-resp pair required to process a call)
	 * 
	 * Rest Assured will not send credential to server initially. When server explicitly asked for it only then 
	 * credentials passed to server in headers along with rest of the details
	 * 
	 */
	//@Test
	public void testBasicChallengedAuthentication(){
		given().auth().basic("username", "password").when().get("http://services.groupkt.com/country/get/all").then().statusCode(200);
	}
	
	
	
	
	
	
	/**
	 * Preemptive Basic Authentication : credential will be passed to server before it ask 
	 */
	//@Test
	public void testBasicPreemptiveAuthentication1(){
		given().auth().preemptive().basic("username", "password").when().get("http://services.groupkt.com/country/get/all").then().statusCode(200);		
	}
	
	
	
	
	
	
	

	/**
	 * Authentication can be set for all calls 
	 */
	//@Test
	public void testBasicAuthentication(){
		RestAssured.authentication = basic("username", "password");
		given().get("http://services.groupkt.com/country/get/all").then().statusCode(200);
				
				
	}
	
	
	
	
	

	/**
	 * challenged digest authentication i.e. min two req response combination required
	 * No Preemptive digest authentication is supported as of 3.0.2 version
	 * 
	 * Digest Authentication is more secure than Basic Authentication as it involve a new Digestive key
	 * 
	 * To know more there is lot of content available in Google
	 */
	//@Test
	public void testDigestiveAuthentication(){
		given().auth().digest("username", "password").when().get("http://services.groupkt.com/country/get/all").then().statusCode(200);
		
	}


}


























