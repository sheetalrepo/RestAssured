package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;

/**
 * NOT FOR DEMO AS OF NOW
 */
public class Test5_todo {
	
	/**
	 * Example 3: pending, need a good xml 
	 */
	//@Test
	public void test1() {
		String res = get("http://httpbin.org/xml").asString();
		System.out.println(res);
		
		//List<String> aa = get("http://httpbin.org/xml").path("slideshow.slide.find{it.@type == 'all'}.item");
		//System.out.println(aa);
		
		//List<String> groceries = get("/shopping").path("shopping.category.find { it.@type == 'groceries' }.item");
	}
		
	
	
	/**
	 * todo: not working
	 */
	//@Test
	public void testX2() {
		given().
			get("http://httpbin.org/xml").
		then().
			body("slideshow.slide.find{it.@type =='all'}.title", hasItems("Wake up to WonderWidgets!","Overview")).log().all();
	}
	
	
	
	/**
	 * todo: Schema and DTD validation
	 */
	//@Test
	public void testX1() {
		// get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").then().assertThat().body(matchesXsd(xsd));
		// get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").then().assertThat().body(matchesDtd(dtd));
	}

}
