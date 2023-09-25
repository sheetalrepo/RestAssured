package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.io.InputStream;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Test5_ReadResponseInDiffWays {

	/**
	 * To get all response as String
	 */
	//@Test
	public void testGetResponseAsString(){
		String responseAsString = get("http://services.groupkt.com/country/search?text=lands").asString();
		System.out.println("My Response:\n\n\n"+responseAsString);
	}
	
	
	

	/**
	 * To get all response as InputStream
	 * @throws IOException 
	 */
	//@Test
	public void testGetResponseAsInputStream() throws IOException{
		InputStream stream = get("http://services.groupkt.com/country/get/iso2code/cn").asInputStream(); 
		System.out.println("Stream Length:"+stream.toString().length());
		stream.close();
	}
	
	
	

	/**
	 * To get all response as ByteArray
	 */
	//@Test
	public void testGetResponseAsByteArray(){
		byte[] byteArray = get("http://services.groupkt.com/country/get/iso2code/cn").asByteArray();
		System.out.println(byteArray.length);
	}
	
	
	

	/**
	 * Extract details using path
	 */
	//@Test
	public void testExtractDetailsUsingPath(){
		String href=
		when().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			contentType(ContentType.JSON).
			body("albumId", equalTo(1)).
		extract().
			path("url");
		
		System.out.println(href);
		
		
		when().get(href).then().statusCode(200);
	}
	
	
	

	/**
	 * Extract details using path in one line
	 */
	//@Test
	public void testExtractPathInOneLine(){
		//type 1:
		String href1= get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		System.out.println("Fetched URL 1:"+href1);
		when().get(href1).then().statusCode(200);
		
		
		//type 2:
		String href2 = get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println("Fetched URL 2:"+href2);
		when().get(href2).then().statusCode(200);
	}
	
	
	

	/**
	 * Extract details as Response for further use
	 */
	//@Test
	public void testExtractDetailsUsingResponse(){
		Response response=
		when().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
		extract().
			response();
		
		System.out.println("Content Type: "+response.contentType());
		System.out.println("Href: "+response.path("url"));
		System.out.println("Status Code: "+response.statusCode());
	
	}
}
