package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;
/**
 * 
 * We can defined few mandatory check in RequestSpecBuilder
 * 
 * then it can be used in multiple test
 * 
 * @author sheetalsingh
 *
 */
public class Test13_RequestSpecBuilder {
	
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void setup(){
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addParam("parameter1", "parameterValue");
		builder.addHeader("header1", "headerValue");
		requestSpec = builder.build();
	}
	
	
	
	@Test
	public void testRequest1(){
		given().
			spec(requestSpec).
		when().
	    	get("https://api.fonts.com/rest/json/Accounts/").
	    then().
			statusCode(400).
			log().all();
	}
	

	
	
	@Test
	public void testRequest2(){
		given().
	    	spec(requestSpec).
	    when().
	    	get("https://api.fonts.com/rest/json/Accounts/").
	    then().
			statusCode(400);
	}

}