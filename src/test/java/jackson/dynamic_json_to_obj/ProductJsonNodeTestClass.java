package jackson.dynamic_json_to_obj;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductJsonNodeTestClass {

	public static ProductJsonNode getPlaceHolderObject(String jsonPath, ObjectMapper objmapper) throws JsonParseException, JsonMappingException, IOException {
		ProductJsonNode product = objmapper.readValue(new File(jsonPath), ProductJsonNode.class);
		return product;
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objMapper = new ObjectMapper();

		// Set 1:
		String mobileJsonPath = "./src/test/java/jackson/dynamic_json_to_obj/mobile.json";
		ProductJsonNode productMobile = getPlaceHolderObject(mobileJsonPath, objMapper);

		System.out.println(productMobile.getName());
		System.out.println(productMobile.getCategory());
		System.out.println(productMobile.getDetails().get("audioConnector").asText());
		System.out.println(productMobile.getDetails().get("displayAspectRatio").asText());
		System.out.println("-------------------------------");

		
		
		
		// Set 2:
		String shoesJsonPath = "./src/test/java/jackson/dynamic_json_to_obj/shoes.json";
		ProductJsonNode productShoes = getPlaceHolderObject(shoesJsonPath, objMapper);

		System.out.println(productShoes.getName());
		System.out.println(productShoes.getCategory());
		System.out.println(productShoes.getDetails().get("size").asText());
		System.out.println(productShoes.getDetails().get("color"));
		System.out.println(productShoes.getDetails().get("material"));
		System.out.println("-------------------------------");
	}

}
