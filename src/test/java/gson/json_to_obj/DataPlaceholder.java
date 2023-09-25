package gson.json_to_obj;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


// Use https://www.jsonschema2pojo.org/ to generate POJO class from JSON
@Getter
@Setter
@ToString
public class DataPlaceholder {
	@SerializedName("Data")
	@Expose
	private List<Data> data = null;

}
