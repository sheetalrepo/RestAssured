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
import io.restassured.matcher.ResponseAwareMatcherComposer.*;

/**
 * Serialization can be done in different ways in Rest Assured
 * 
 * Java Obj -> File/String
 * 
 * @author sheetalsingh
 *
 *
 *		Given: A post service expect input data in JSON format
	 	Problem Statement: We need a way to send input data as JSON in POST request
   	  	{ "firstName":"A","LastName":"B","Age":"30" }

	 
	 	Content type is set to JSON in request, so RestAssured will use following library to Serialize Java object(Map) into JSON
	 	#Library Priority Order
    	1. JSON using Jackson 2 (Faster Jackson (databind))			| used if found in classpath
    	2. JSON using Jackson (databind)							| used if above lib is not present in classpath
    	3. JSON using Gson											| same as above
    	
    	#In case of XML
    	1. XML using JAXB
 *
 */
public class Test17_Serialization {

	
	/**
	 * contentType() is converting HashMap object into Json
	 */
	//@Test
	public void testSerializationUsingHashMap() {
		//Java Object
        Map<String,String> inputJson = new HashMap<>();
        inputJson.put("firstName", "A");
        inputJson.put("LastName", "B");
        inputJson.put("Age", "30");

        //Serialization : Java obj -> Json
        given()
        	.contentType("application/json")
        	.body(inputJson).
        when()
        	.post("http://www.thomas-bayer.com/restnames/countries.groovy").
        then()
        	.statusCode(200);
        	
    }
	
	
	
	
	
	
	
	
	/**
	 * For bigger JSON object it is easier to send java object rather creating a Map
	 * 
	 * Serialization
	 */
	//@Test
	public void testSerializationUsingContentType(){
		//Java Obj
		ZebraRequestClassNew obj = new ZebraRequestClassNew();
		obj.setAge(10);
		obj.setWeight(100);
		obj.setHome("India");
		
		
		//Serialization : Java obj -> Json
		given()
			.contentType("application/json")
    		.body(obj).
    	when()
    		.post("http://www.thomas-bayer.com/restnames/countries.groovy").
    	then()
    		.statusCode(200)
    		.contentType("application/xml").log().all();
	}

	
	
	
	
	/**
	 * Serialization can also be done using explicit serializer
	 * Here we are converting java object into json using jackson 2
	 */
	//@Test
	public void testSerializationUsingExplicitSerializer(){
		
		ZebraRequestClassNew obj = new ZebraRequestClassNew();
		obj.setAge(1);
		obj.setWeight(10);
		obj.setHome("India");
		
		given()
    		.body(obj, ObjectMapperType.JACKSON_2).
    	when()
    		.post("http://www.thomas-bayer.com/restnames/countries.groovy").
    	then()
    		.statusCode(200)
    		.contentType("application/xml").log().all();

	}
		
}