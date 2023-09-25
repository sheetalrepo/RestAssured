package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;

public class Test1_BasicFeaturesForXml {

	/**
	 * To test xml response for single body content
	 */
	//@Test
	public void testSingleContent() {
		when().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
			body("CUSTOMER.ID", equalTo("10")).
			log().all();
	}

	
	
	
	
	/**
	 * To test xml response for multiple body content
	 * 
	 * test can also we written in xpath style i.e. in one line but that may be
	 * unreadable
	 */
	//@Test
	public void testMultipleContent() {
		given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
			body("CUSTOMER.ID", equalTo("10")).
			body("CUSTOMER.FIRSTNAME", equalTo("Sue")).body("CUSTOMER.LASTNAME", equalTo("Fuller")).
			body("CUSTOMER.STREET", equalTo("135 Upland Pl.")).body("CUSTOMER.CITY", equalTo("Dallas"));
	}
	
	
	
	

	/**
	 * Compare complete text in one go
	 */
	//@Test
	public void testCompleteTextInOneGo() {
		given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
			body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
			log().all();
	}
	
	
	
	


	/**
	 * xpath can also be used to find values
	 */
	//@Test
	public void testUsingXpath1() {
		given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
			body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
	}
	
	
	

	
	/**
	 * xpath types
	 */
	//@Test
	public void testUsingXpath2() {
		given().
			get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
		then().
			body(hasXPath("/INVOICEList/INVOICE[text()='40']")).log().all();
	}
	
	
}
