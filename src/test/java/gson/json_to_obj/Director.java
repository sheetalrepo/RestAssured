package gson.json_to_obj;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Director {
	
	private String ID;
	private String Name;
	private String Position;
	private BigDecimal Salary;
	private String Dept;
	private String Location;
	private List<String> Skills;
	private String Country;
	
}
