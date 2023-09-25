package gson.csv_to_json;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This is main POJO class which contains list of all employees data
 */

@Getter
@Setter
@ToString
public class ServicePlaceholderPojo {
    private List<Employee> Employee = null;
}
