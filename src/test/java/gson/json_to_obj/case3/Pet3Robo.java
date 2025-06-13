package gson.json_to_obj.case3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pet3Robo {

	@SerializedName("surname")
	@Expose
	private String surname;
	@SerializedName("category")
	@Expose
	private String category;
	@SerializedName("hp")
	@Expose
	private String hp;

}
