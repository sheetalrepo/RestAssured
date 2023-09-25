package demo;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test3_SchemaCheck {

	
	/**
	 * verify response type
	 */
	//@Test
	public void testContentType() {
	
	given().
		get("http://services.groupkt.com/country/get/iso2code/cn").
	then().
		statusCode(200).
		contentType(ContentType.JSON);
		//contentType(ContentType.HTML);
		//contentType(ContentType.XML);
	}
	
	
	
	
	/**
	 * This test will verify the response schema with predefined existing schema
	 * path: src/test/resources/geo-schema.json
	 */
	//@Test
	public void testSchema() {

		given().
			get("http://geo.groupkt.com/ip/172.217.4.14/json").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("test3_geo_schema123.json"));

	}
}
