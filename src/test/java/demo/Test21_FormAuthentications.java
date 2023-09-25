package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.parsing.Parser;


/**
 * Form authentication
 * 
 * todo: to run cases need proper url
 * 
 * @author sheetalsingh
 *
 */
public class Test21_FormAuthentications {


	/**
	 * Rest Assured will try to load and parse web page to find username and password field 
	 * If able to find then code will work else it will fail
	 * 
	 * Rest assured need to make additional call to parse page
	 * 
 	 * This case may or may not work based upon web page complexity
	 */
	//@Test
	public void testFormAuthenticationByParsingWebPage(){
		given().
        	auth().form("John", "Smith").
        when().
        	get("/test-form-url").
		then().
        	statusCode(200);
	}
	
	
	
	

	/**
	 * Here we are providing form details when setting up form authentications 
	 * 
	 * No additional call would be made by Rest Assured to parse page 
	 */
	//@Test
	public void testFormAuthenticationUsingFormAuthConfig(){
		given().
        	auth().form("John", "Smith", new FormAuthConfig("/j_spring_security_check", "j_username", "j_password")).
        when().
        	get("/test-form-url").
		then().
        	statusCode(200);
		
	}
	
	
	
	

	/**
	 * Used in case we are using default Spring Security properties
	 */
	//@Test
	public void testFormAuthenticationUsingSpringSecurity(){
		given().
        	auth().form("John", "Smith", FormAuthConfig.springSecurity()).
        when().
        	get("/test-form-url").
        then().
        	statusCode(200);
	
	
	}	
	
}
