package demo;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.path.json.JsonPath.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 *  This class is to set different type of data in request call
 *  
 * @author sheetalsingh
 *
 */
public class Test9_SetRequestData {

	/**
	 * Generally CONNECT used with HTTPS request
	 * http://stackoverflow.com/questions/11697943/when-should-one-use-connect-and-get-http-methods-at-http-proxy-server
	 */
	//@Test
	public void testConnectRequest(){
		
		when().
			request("CONNECT", "https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	

	
	/**
	 * In GET request we can set query parameter
	 */
	//@Test
	public void testQueryParameters(){
		given().
			queryParam("A", "A val").
			queryParam("B", "B val").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	
	/**
	 * In POST request we can set form parameter
	 */
	//@Test
	public void testFormParameters(){
		given().
			formParam("A", "A val").
			formParam("B", "B val").
		when().
			post("http://api.fonts.com/rest/json/Domains/").
		then().
			statusCode(400);
	}
	
	
	
	/**
	 * To set parameters - recommended way
	 * If request is GET then param will be treated as QueryParameter
	 * If request is POST then param will be treated as FormParameter
	 */
	//@Test
	public void testSetParameters(){
		given().
			param("A", "A-value").
			param("B", "B-value").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	
	
	

	/**
	 * To set multiple value parameters
	 * 
	 * We can pass list, multiple values or no values in param 
	 */
	//@Test
	public void testSetMultiValueParameters(){
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		
		given().
			param("A", "val1","val2","val3").
			param("B").
			param("C", list).
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	
	
	
	
	

	/**
	 * To path parameters type 1
	 * 
	 */
	//@Test
	public void testSetPathParameters1(){
		when().
			post("http://api.fonts.com/rest/{type}/{section}/","json","Domains").
		then().
			statusCode(400);
		
	}
	
	
	
	/**
	 * To path parameters type 2
	 * 
	 */
	//@Test
	public void testSetPathParameters2(){
	
		given().
			pathParam("type", "json").
			pathParam("section", "Domains").
		when().
			post("http://api.fonts.com/rest/{type}/{section}/").
		then().
			statusCode(400);
	}
	
	
	
	/**
	 * Cookies can be set in request param
	 */
	//@Test
	public void testSetCookiesInRequest(){
		
		//to set single value
		given().
			cookie("__utmt", "1").
		when().
			get("http://www.webservicex.com/globalweather.asmx?op=GetCitiesByCountry").
		then().
			statusCode(200);
	}
	
	
	
	
	/**
	 * Multiple Cookies can be set in request param
	 * todo: test example not runnable code
	 */
	//@Test
	public void testSetMultiCookiesInRequest(){
		
		//to set multi value
		given().cookie("key", "val1","val2"); // this will create two cookies key = val1; key = val2
				
		
		//to set detailed cookie
		Cookie cookie = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		given().cookie(cookie).when().get("/cookie").then().assertThat().body(equalTo("x"));
		
		
		//to set multiple detailed cookies
		Cookie someCookie1 = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		Cookie someCookie2 = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		Cookies cookies = new Cookies(someCookie1, someCookie2);
		given().cookies(cookies).when().get("/cookie").then().assertThat().body(equalTo("x"));
	}
		
	
	
	/**
	 * We can pass single header, headers with multiple values and
	 * multiple headers
	 */
	//@Test
	public void testSetHeaders(){
		given().
			header("k", "v").
			header("k10", "val1","val2","val3").
			headers("k1","v1","k2","v2").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	

	
	
	/**
	 * Content Type can be also be set
	 */
	//@Test
	public void testSetContentType(){
		given().
			contentType(ContentType.JSON).
			contentType("application/json; charset=utf-8").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	

	
	
	
	
	/**
	 * Request Body 
	 * used in case of POST, PUT and DELETE
	 * todo: Need to change URL, not testable
	 */
	//@Test
	public void testSetBody(){
		given().
			body("some body").
			request().body("some body").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	
	
	
	
}


