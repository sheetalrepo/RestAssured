package wiremock.basics;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFinal {

	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	private static WireMockServer server = new WireMockServer(PORT);

	@BeforeClass
	public void initializeServer() {
		System.out.println("Init");
		//Start Wiremock server via code and configure it with required host and post
		server.start();
		WireMock.configureFor(HOST, PORT);
	}

	@Test
	public void testCode() {
		String testApi = "http://localhost:"+ PORT +"/emps/1";
		System.out.println("Service to be hit: "+testApi);
		String token = 
				RestAssured.
				given().
					get(testApi).
				then().
					assertThat().
					statusCode(200).
				extract().
					header("token");
			
			System.out.println("testCode token: "+token);
			Assert.assertEquals("12345", token);
	}



	@Test
	public void testCode2() {
		String testApi = "http://localhost:"+ PORT +"/emps/2";
		System.out.println("Service to be hit: "+testApi);
		String token =
				RestAssured.
					given().
						get(testApi).
					then().
						assertThat().
						statusCode(200).
					extract().
						header("token");

		System.out.println("testCode token: "+token);
		Assert.assertEquals("12345", token);
	}
	
	@AfterClass
	public void closeServer() {
		System.out.println("End");
		if (server.isRunning() && null != server) {
			server.shutdown();
		}
	}

}
