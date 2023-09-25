package gson.csv_to_json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Base Class: ServicePlaceholderPojo

@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private String surname;
    private String age;
    private Address address;
    private Office office;

}
