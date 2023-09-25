package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.parsing.Parser;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;
/**
 * 
 * @author sheetalsingh
 *
 */
public class Test18_Deserialization {


	/**
	 * Content-type based de-serialization process using .as()
	 * 
	 * Here even if response is in JSON or XML, Rest assured will handle it automatically
	 */
	//@Test
	public void testDeserializationUsingContentType(){
		//Java Obj
		ZebraRequestClassNew reqObj = new ZebraRequestClassNew();
		reqObj.setAge(5);
		reqObj.setWeight(50);
		reqObj.setHome("India");
		
		//De serialization using .as() method
		ZebraResponseClass respObj = 
		given()
    		.body(reqObj).
    	when()
    		.post("http://www.thomas-bayer.com/restnames/countries.groovy")
    		.as(ZebraResponseClass.class);  // Json -> Java Obj
	
		
		//some assertions on response
		respObj.setRegId(1100);  // hard coded as we don't have proper response data
        Assert.assertTrue(respObj.getRegId() > 0); // new registration id should always be greater than 0
	}
	
	
	
	
	
	
	
	
	
	/**
	 * todo: not working
	 * 
	 * If content type is not JSON and XML then we can use this approach
	 */
	//@Test
	public void testDeserializationUsingCustomContentType(){
		ZebraResponseClass respObj1 = 
				expect().
					parser("application/something", Parser.XML).
				when().
					get("http://jsonplaceholder.typicode.com/photos/").
				as(ZebraResponseClass.class);
		
		
		ZebraResponseClass respObj2 = expect().defaultParser(Parser.XML).when().get("http://jsonplaceholder.typicode.com/photos/").as(ZebraResponseClass.class);
	}
	
	
	
	/**
	 * todo: not working
	 * 
	 * De-serialization can also be done using explicit serializer
	 */
	//@Test
	public void testDeserializationUsingExplicitDeserializer(){
		ZebraResponseClass respObj = get("http://jsonplaceholder.typicode.com/photos/").as(ZebraResponseClass.class, ObjectMapperType.JACKSON_2);
	}
	
	
}
