package gson.json_to_obj.case3;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 *  Single placeholder class is required which hold all the POJOs data
 *  Create POJOs using http://www.jsonschema2pojo.org
 * @author Sheetal_Singh
 */
@Getter
@Setter
@ToString
public class PetsBase {

	@SerializedName("Pet1")
	@Expose
	private List<Pet1> pet1 = null;
	@SerializedName("Pet2")
	@Expose
	private List<Pet2> pet2 = null;
	@SerializedName("Pet3Robo")
	@Expose
	private List<Pet3Robo> pet3Robo = null;

}