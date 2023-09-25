package jackson.dynamic_json_to_obj;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

/**
 *  Map can also be used rather jsonNode
 *  https://www.baeldung.com/jackson-mapping-dynamic-object
 *  
 * @author Sheetal_Singh
 *
 */
public class ProductMap {

	String name;
	String category;
	Map<String, Object> details = new LinkedHashMap<>();

	public Map<String, Object> getDetails() {
		return details;
	}

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

	public void setDetails(Map<String, Object> details) {
		this.details = details;
	}

	@JsonAnySetter
	void setDetail(String key, Object value) {
		details.put(key, value);
	}

}
