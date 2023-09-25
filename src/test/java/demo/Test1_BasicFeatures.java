package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Test1_BasicFeatures {


	/**
	 * simply checking status code
	 */
	@Test
	public void testStatusCode() {
		System.out.println("******************Basic 200 : Test 1****************************");
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200);
	}

	
	
	/**
	 * it will verify code and print complete response in console
	 */
	@Test
	public void testLogging() {
		given().
			get("http://services.groupkt.com/country/get/iso2code/in").
		then().
			statusCode(200).
			log().all();
	}



	/**
	 * verifying single content using org.hamcrest.Matchers library's equalTo method
	 */
	@Test
	public void testEqualToFunction() {
		given().
			get("http://services.groupkt.com/country/get/iso2code/us").
		then().
			body("RestResponse.result.name",equalTo("United States of America"));
	}
	
	
	
	
	/**
	 * verifying multiple content using org.hamcrest.Matchers library
	 */
	@Test
	public void testHasItemFunction() {
		System.out.println("******************Basic Has Item: Test 2****************************");
		given().
			get("http://services.groupkt.com/country/get/all").
		then().
			body("RestResponse.result.name",hasItems("Afghanistan","Argentina","Australia"));
	}
	
	
	
	
	
	/**
	 * parameters and headers can be set
	 */
	@Test
	public void testParametersAndHeaders() {
		given().
			param("key1", "value1").
			header("headA", "valueA").
		when().
			get("http://services.groupkt.com/country/get/iso2code/gb").
		then().
			statusCode(200).
			log().all();
	}

	

	
	
	/**
	 * using 'and' to increase readability 
	 * generally used when writing in one line xpath style
	 */
	@Test
	public void testAndFeatureForReadability() {
		given().param("key1", "value1").and().header("key2", "value2").when().get("http://services.groupkt.com/country/get/iso2code/cn").then().statusCode(200).and().body("RestResponse.result.alpha3_code", equalTo("CHN"));
	}



		
}
