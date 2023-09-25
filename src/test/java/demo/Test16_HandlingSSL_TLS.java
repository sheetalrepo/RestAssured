package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;
/**
 * 
 * 
 * @author sheetalsingh
 *
 */
public class Test16_HandlingSSL_TLS {
	
	
	@BeforeClass
	public void setup(){
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	
	/**
	 * Suppose server has invalid certificate and throwing SSLPeerUnverifiedException exception
	 * So to handle this case we can relax certificate condition and now no SSL exception will come
	 * 
	 * Don't have any proper url to test this feature
	 */
	@Test
	public void testSSL1(){
		given().relaxedHTTPSValidation().when().get("http://www.bupa.com.au/");
		//given().get("http://freegeoip.net:80/").then().statusCode(200);
	}
	

	

	/**
	 * We can also handle TLS protocol using an overloaded method
	 */
	//@Test
//	public void testTLS(){
//		given().relaxedHTTPSValidation("TLS").when().get("https://services.groupkt.com/country/get/iso3code/ita");
//	}
//	
	
}

