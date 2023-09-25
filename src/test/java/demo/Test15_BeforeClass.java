package demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test15_BeforeClass {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://services.groupkt.com";
		RestAssured.basePath = "/country";
//		RestAssured.port = 8080;
//		RestAssured.authentication = basic("username", "password");
//		RestAssured.rootPath = "x.y.z";
//		RestAssured.filters(..); // List of default filters
//		RestAssured.requestSpecification = .. // Default request specification
//		RestAssured.responseSpecification = .. // Default response specification
//		RestAssured.urlEncodingEnabled = .. // Specify if Rest Assured should URL encoding the parameters
//		RestAssured.defaultParser = .. // Specify a default parser for response bodies if no registered parser can handle data of the response content-type
//		RestAssured.registerParser(..) // Specify a parser for the given content-type
//		RestAssured.unregisterParser(..) // Unregister a parser for the given content-type
//		RestAssured.useRelaxedHTTPSValidation();  // In case server using invalid certificate and throwing SSLPeerUnverifiedException
//		RestAssured.trustStore(keystore);  // for Java keystore file
//		RestAssured.reset(); // reset all configuration to default like baseURI (localhost), basePath (empty), standard port (8080), standard root path (""), default authentication scheme (none) and url encoding enabled (true)

	}
	
	
	/**
	 * Here we need to get only end points, as baseuri and basepath will be
	 * picked from BeforeClass
	 */
	//@Test
	public void test1() {
		given().get("/search?text=united").then().statusCode(200).log().all();
	}
	
	@Test
	public void test2() {
		given().get("/get/all").then().statusCode(200).log().headers();
	}

}
