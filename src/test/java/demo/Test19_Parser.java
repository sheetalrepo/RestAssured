package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;


/**
 * 
 * @author sheetalsingh
 *
 */
public class Test19_Parser {


	//@Test
	public void testDefaultParser1(){
		//Any one can be used
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.defaultParser = Parser.XML;
		RestAssured.defaultParser = Parser.HTML;
		
	}
	
	
	//@Test
	public void testDefaultParser2(){
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").then().using().defaultParser(Parser.JSON);
	}
	
	
	
	/**
	 * Custom parser for - "application/vnd.uoml+xml" type
	 * Syntax: RestAssured.registerParser(<content-type>, <parser>);
	 */
	//@Test
	public void testCustomParser1(){
		RestAssured.registerParser("application/vnd.uoml+xml", Parser.XML);
		RestAssured.unregisterParser("application/vnd.uoml+xml");
	}
	
	
	
	
	/**
	 * Custom Parser - Type 2
	 */
	//@Test
	public void testCustomParser2(){
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").then().using().parser("application/vnd.uoml+xml", Parser.XML);
	}
	
}


























