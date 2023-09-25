package demo;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.*;
import org.testng.annotations.Test;
import io.restassured.path.xml.XmlPath;


/**
 *  NOT FOR DEMO
 *
 */
public class Test7_todo {


	/**
	 * todo: Need to change url
	 */
	//@Test
	public void todo(){
		String xml = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").andReturn().asString();
		String firstName = from(xml).get("CUSTOMER.FIRSTNAME");
		System.out.println(firstName);
		
		// or a bit more efficiently:
		XmlPath xmlPath = new XmlPath(xml).setRoot("CUSTOMER");
		String firstName2 = xmlPath.get("FIRSTNAME");
		System.out.println(firstName2);
		
	}
}
