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
public class Test2_SettingRoot {
	
	/**
	 * Basic way to test all parameters
	 */
	@Test
	public void testWithoutRoot(){
		System.out.println("******************Setting Root: Test 3****************************");
		given().
	    	get("http://services.groupkt.com/country/get/iso3code/ITA").
	    then().
	    	body("RestResponse.result.name", is("Italy")).
	    	body("RestResponse.result.alpha2_code", is("IT")).
	    	body("RestResponse.result.alpha3_code", is("ITA"));
	}
	
	
	
	/**
	 * Recommended way to test all parameters using root feature
	 */
	@Test
	public void testWithRoot(){
		System.out.println("******************Setting Root: Test 4 ****************************");
		given().
	    	get("http://services.groupkt.com/country/get/iso3code/ITA").
	    then().
	    	root("RestResponse.result").
	    	body("name", is("Italy")).
	    	body("alpha2_code", is("IT")).
	    	body("alpha3_code", is("ITA"));
	}
	
	
	
	/**
	 * We can detach root path in between
	 */
	//@Test
	public void testDetachRoot(){
		given().
	    	get("http://services.groupkt.com/country/get/iso3code/ITA").
	    then().
	    	root("RestResponse.result").
	    	body("name", is("Italy")).
	    	body("alpha2_code", is("IT")).
	    	detachRoot("result").
	    	body("result.alpha3_code", is("ITA"));
	}
	
	
	


}


























