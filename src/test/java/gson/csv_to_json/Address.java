package gson.csv_to_json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String hno;
    private String block;
    private String area;
    private String state;
    private AddressGeo addressGeo;
}
