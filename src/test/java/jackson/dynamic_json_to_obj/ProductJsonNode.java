package jackson.dynamic_json_to_obj;

import com.fasterxml.jackson.databind.JsonNode;

/**
 *  Json Node is helpful when json is changing dynamically
 *  https://www.baeldung.com/jackson-mapping-dynamic-object
 *  
 * @author Sheetal_Singh
 *
 */
public class ProductJsonNode {

	String name;
	String category;
	JsonNode details;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public JsonNode getDetails() {
		return details;
	}
	public void setDetails(JsonNode details) {
		this.details = details;
	}
	
	
	
}
