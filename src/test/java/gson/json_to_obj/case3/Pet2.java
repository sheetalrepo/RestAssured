package gson.json_to_obj.case3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pet2 {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("category")
	@Expose
	private String category;

}
