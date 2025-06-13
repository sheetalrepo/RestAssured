package gson.json_to_obj.case1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Data {
	@SerializedName("photoId")
	@Expose
	private String photoId;
	@SerializedName("category")
	@Expose
	private String category;
	
}
