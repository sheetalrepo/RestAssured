package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.parsing.Parser;


/**
 * CSRF authentication | https://en.wikipedia.org/wiki/Cross-site_request_forgery
 * 
 * CSRF is a type of malicious exploit of a website where unauthorized commands are transmitted from a user that the website trusts
 * 
 * Server generally send CSRF token along with response to prevent these kind of attack 
 * 
 * REST Assured has support for automatically parsing & supplying the CSRF token to server.
 * 
 * To handle CSRF, REST Assured must make an additional request and parse (parts) of the website
 * 
 * todo: to run cases need proper url

 */
public class Test22_CSRF_OAuth {

	
	//Cases will not run as we don't have proper URL
	//@Test
	public void testCSRF(){
		given().
			auth().form("John", "Doe", FormAuthConfig.formAuthConfig().withAutoDetectionOfCsrf()).
		when().
        	get("/formAuth").
		then().
        	statusCode(200);
		
	}
	
	
	/**
	 * Here we help Rest assured by giving CSRF filed name i.e. _csrf
	 * 
	 * This case will be faster than previous one as we have already given field name
	 * 
	 * By default CSRF token value sent as Form Parameter
	 * 
	 * Note: can be used in case we are using spring security default values
	 */
	//@Test
	public void testWithSpringSecurityAsFormParameter(){
		given().
			auth().form("John", "Doe", FormAuthConfig.springSecurity().withCsrfFieldName("_csrf")).
		when().
        	get("/formAuth").
		then().
        	statusCode(200);
		
	}
	
	/**
	 * To send CSRF token as header value rather default form parameter
	 * 
	 */
	//@Test
	public void testCSRFWithSpringSecurityAsHeader(){
		given().
			auth().form("John", "Doe", FormAuthConfig.springSecurity().withCsrfFieldName("_csrf").sendCsrfTokenAsHeader()).
		when().
        	get("/formAuth").
		then().
        	statusCode(200);
		
	}
	
	
	
	//-------------------------------------------- OAuth Authentication -------------------------------------------------------//
	
	//@Test
	public void testOAuth(){
		given().
			auth().oauth("", "", "", "").
		when().
        	get("/formAuth").
		then().
        	statusCode(200);
		
	}
	
	
	/**
	 * OAuth 2
	 * This is preemptive in nature i.e. credentials is passed to server in first call itself
	 * In challenge approach credential passed in second call when server ask for it
	 */
	//@Test
	public void testOAuth2(){
		given().
			auth().oauth2("access token").
		when().
        	get("/formAuth").
		then().
        	statusCode(200);
		
		
		given().
			auth().preemptive().oauth2("accessToken").
		when().
        	get("/formAuth").
		then().
        	statusCode(200);
			
	}
	
	
	
}