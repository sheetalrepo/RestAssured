package CarDemo.TestClass;

import CarDemo.WriteYamlPropFile.EnvPlaceholder;
import org.yaml.snakeyaml.Yaml;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadPropertyFile {

    public static void main(String[] args) {
        
        String yamlPath = ".\\src\\test\\java\\CarDemo\\WriteYamlPropFile\\env.yaml";
        Yaml yaml = new Yaml();
        EnvPlaceholder envProperties = null;
        try {
            envProperties = yaml.loadAs(new FileReader(yamlPath), EnvPlaceholder.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String runEnv = "sb"; //TODO: get from command line

        String envName;
        String envBaseUrl;        
        if(runEnv.equalsIgnoreCase("prod")) {
            envName= envProperties.getAllEnvData().get(0).getEnvName();
            envBaseUrl= envProperties.getAllEnvData().get(0).getEnvValues().getBaseUrl(); 
        } else if(runEnv.equalsIgnoreCase("sb")) {
            envName= envProperties.getAllEnvData().get(1).getEnvName();
            envBaseUrl= envProperties.getAllEnvData().get(1).getEnvValues().getBaseUrl();  
        } else {
            //default env = sb
            envName= envProperties.getAllEnvData().get(1).getEnvName();
            envBaseUrl= envProperties.getAllEnvData().get(1).getEnvValues().getBaseUrl();
        }
        
        //Data
        String vehicleServicePath = envProperties.getCommonData().getVehicleServicePath();
        String vehicleDepartureProfilesEndpoint = envProperties.getCommonData().getVehicleDepartureProfilesEndpoint();
        String departureUrl = envBaseUrl + vehicleServicePath + vehicleDepartureProfilesEndpoint;
        System.out.println(envName);
        System.out.println(departureUrl);

        
    }
}
