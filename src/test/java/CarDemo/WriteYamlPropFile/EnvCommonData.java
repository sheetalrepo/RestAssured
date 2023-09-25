package CarDemo.WriteYamlPropFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * URL =  baseurl + port + servicePath + endpoint
 * 
 * Different Services Path and Endpoints are stored in this class
 * 
 */
@Getter
@Setter
@ToString
public class EnvCommonData {
    //All Vehicle's Service Paths and Endpoints
    String vehicleServicePath; // Path = /vehicle/     
    String vehicleDepartureProfilesEndpoint; //    v1/vehicles/{vin}/departure/profiles
    String vehicleSubscriptionsEndpoint; //     v1/vehicles/{vin}/subscriptions
    
    
    //All Navigation's Service Paths and Endpoints
    String navigationServicePath; //  Path = /navigation/     
    String navigationDirectionEndpoint; //   v1/directions   
    String navigationLocationEndpoint; //  v1/locations


    //All Gamify's Service Paths and Endpoints - There is no Path for Gamify
    String gamifyServicePath; //  Path = /     
    String gamifyRewardsEndpoint; //   gamify/{vin}/reward
    
}
