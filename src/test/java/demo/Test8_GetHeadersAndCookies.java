package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.path.json.JsonPath.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test8_GetHeadersAndCookies {

	/**
	 * To get response headers
	 */
	//@Test
	public void testResponseHeaders(){
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		//to get single header
		String headerCFRAY = response.getHeader("CF-RAY");
		System.out.println(">>>>> Header: "+headerCFRAY);
		
		System.out.println("");
		
		//to get all headers
		Headers headers = response.getHeaders();
		for(Header h: headers){
			System.out.println(h.getName()+":"+h.getValue());
		}
	}
	
	
	
	
	
	
	/**
	 * To get cookies
	 */
	//@Test
	public void testCookies(){
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		Map<String, String> cookies = response.getCookies();
		
		for(Map.Entry<String, String> entry : cookies.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	
	}
	
	
	
	
	
	/**
	 * To get detailed cookies
	 */
	//@Test
	public void testDetailedCookies(){
		Response response = get("http://jsonplaceholder.typicode.com/photos");
	
		Cookie a = response.getDetailedCookie("__cfduid");
		System.out.println("Detailed: "+a.hasExpiryDate());
		System.out.println("Detailed: "+a.getExpiryDate());
		System.out.println("Detailed: "+a.hasValue());
	}
	
	
}
