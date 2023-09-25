package jackson.json_to_obj;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * POJO manually generated using
 * http://www.jsonschema2pojo.org/
 * 
 * @author Sheetal_Singh
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"streetAddress",
"city",
"state",
"postalCode"
})
public class UserAddress {

@JsonProperty("streetAddress")
private String streetAddress;

@JsonProperty("city")
private String city;

@JsonProperty("state")
private String state;

@JsonProperty("postalCode")
private String postalCode;

@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("streetAddress")
public String getStreetAddress() {
return streetAddress;
}

@JsonProperty("streetAddress")
public void setStreetAddress(String streetAddress) {
this.streetAddress = streetAddress;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("state")
public String getState() {
return state;
}

@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

@JsonProperty("postalCode")
public String getPostalCode() {
return postalCode;
}

@JsonProperty("postalCode")
public void setPostalCode(String postalCode) {
this.postalCode = postalCode;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
