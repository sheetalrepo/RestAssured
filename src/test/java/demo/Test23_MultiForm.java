package demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.parsing.Parser;


public class Test23_MultiForm {

	/**
	 * 
	 * html code of upload element:  <input type="file" size="45" name="file_upload">
	 * 
	 */
	//@Test
	public void testUploadFile(){
		given().
        	multiPart("file_upload", new File("/Users/sheetalsingh/Desktop/abc.txt")).
        when().
        	post("http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload").
        then().
        	statusCode(200);
	}
	
	
	
	
	
	/**
	 * 
	 * if the html code of upload element is :  <input type="file" size="45" name="file">
	 * i.e. name is "file" then no need to specify web element locator
	 * Rest assured will automatically identify the element
	 * 
	 */
	//@Test
	public void testUploadFileWithDefaultWebElement(){
		given().
        	multiPart(new File("/Users/sheetalsingh/Desktop/abc.txt")).
        when().
        	post("http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload").
        then().
        	statusCode(200);
	}
	
}
