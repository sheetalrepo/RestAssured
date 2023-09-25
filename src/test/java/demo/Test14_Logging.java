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
 * 
 * @author sheetalsingh
 *
 */
public class Test14_Logging {
	
	
	//@Test
	public void testLogging1(){
		given().
	    	get("http://services.groupkt.com/country/search?text=states").
	    then()
	    	//.log().headers();
    		//.log().body();
	    	//.log().cookies();
	    	.log().all();

	}
	
	
	/**
	 * Logs only in case of errors
	 */
	//@Test
	public void testLogging2(){
		given().
			//get("http://services.groupkt.com/country/get/iso2code/gb").
	    	get("http://api.fonts.com/rest/json/Domains/").
	    then().
	    	log().ifError();
	}
	
	
	
	
	/**
	 * Conditional Logging
	 */
	@Test
	public void testLogging3(){
		given().
	    	get("http://api.fonts.com/rest/json/Domains/").
	    then().
	    	log().ifStatusCodeIsEqualTo(400);
	}

}
