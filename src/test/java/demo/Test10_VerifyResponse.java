package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
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
public class Test10_VerifyResponse {



	
	/**
	 * status code verification
	 */
	@Test
	public void testStatusInResponse(){
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusCode(200);
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusLine("HTTP/1.1 200 OK");
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusLine(containsString("OK"));	
	}
	
	
	
	
	/**
	 * headers verification
	 */
	//@Test
	public void testHeadersInResponse(){
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().header("X-Powered-By","Express");
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().headers("Vary","Accept-Encoding","Content-Type",containsString("json"));
	}
	
	
	
	

	/**
	 * content type verification
	 */
	//@Test
	public void testContentTypeInResponse(){
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().contentType(ContentType.JSON);
	}
	
	
	
	
	/**
	 * body text verification
	 */
	//@Test
	public void testBodyInResponse(){
		String responseString = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").asString();
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").then().assertThat().body(equalTo(responseString));
	}
	
	
	
	/**
	 * body attribute verification using java 8 lambda expression
	 */
	//@Test
	public void testBodyParametersInResponse(){
		
		given().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			body("thumbnailUrl", new ResponseAwareMatcher<Response>() {
				public Matcher<?> matcher(Response response) {
                    return equalTo("http://placehold.it/150/30ac17");
            	}
			});
		

		//With Java 8 lambda expression
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl", response -> equalTo("http://placehold.it/150/30ac17"));
	
	
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl", endsWith("30ac17"));
			
	}
	
	
	
	
	
	
	
	/**
	 * todo: Not working 
	 * cookie value changing, need diff call
	 */
	//@Test
	public void testCookiesInResponse(){
		given().get("http://jsonplaceholder.typicode.com/comments").then().log().all().assertThat().cookie("__cfduid","db8a58dc77654193b3bbd9bba0c7642a81486464587");
	}
	
}
