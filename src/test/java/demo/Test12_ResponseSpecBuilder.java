package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;


/**
 * We can defined few mandatory check in ResponseSpecBuilder
 * 
 * then it can be used in multiple test
 * 
 * @author sheetalsingh
 *
 */
public class Test12_ResponseSpecBuilder {
	
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setup(){
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectHeader("Content-Type", "application/json;charset=UTF-8");
		builder.expectHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
		responseSpec = builder.build();
	}
	
	

	@Test
	public void testResponse1(){
		when()
		       .get("http://services.groupkt.com/country/search?text=india").
		then()
		       .spec(responseSpec)
		       .time(lessThan(4000L));
	}
	
	
	@Test
	public void testResponse2(){
		when()
		       .get("http://services.groupkt.com/country/search?text=states").
		then()
		       .spec(responseSpec);
	}
	
}