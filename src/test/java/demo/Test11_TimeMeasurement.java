package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;
/**
 * @author sheetalsingh
 *
 */
public class Test11_TimeMeasurement {

	
	/**
	 * response time measurement
	 * 
	 * please note time include HTTP round trip + rest assured processing time
	 * 
	 */
	//@Test
	public void testResponseTime(){
		long t = given().get("http://jsonplaceholder.typicode.com/photos/").time();
		System.out.println("Time(ms): "+t);
	}
	
	
	
	//@Test
	public void testResponseTimeInUnit(){
		long t = given().get("http://jsonplaceholder.typicode.com/photos/1").timeIn(TimeUnit.SECONDS);
		System.out.println("Time(ms): "+t);
	}
	
	
	//@Test
	public void testResponseTimeAssertion(){
		given().get("http://jsonplaceholder.typicode.com/photos/").then().time(lessThan(4000L)); 
	}

	
	
}


























