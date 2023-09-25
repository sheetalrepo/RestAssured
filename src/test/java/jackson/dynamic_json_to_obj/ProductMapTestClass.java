package jackson.dynamic_json_to_obj;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductMapTestClass {

	public static ProductMap getPlaceHolderObject(String jsonPath, ObjectMapper objmapper) throws JsonParseException, JsonMappingException, IOException {
		ProductMap product = objmapper.readValue(new File(jsonPath), ProductMap.class);
		return product;
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		
		String shoesJsonPath = "./src/test/java/jackson/dynamic_json_to_obj/shoes.json";
		ProductMap productShoes = getPlaceHolderObject(shoesJsonPath, objMapper);
		System.out.println(productShoes.getName());
		System.out.println(productShoes.getCategory());
		System.out.println(productShoes.getDetails().get("size"));
		System.out.println(productShoes.getDetails().get("color"));
		System.out.println(productShoes.getDetails().get("material"));

		System.out.println("-------------------------------");
	}

}
