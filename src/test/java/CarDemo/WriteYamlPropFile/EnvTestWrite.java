package CarDemo.WriteYamlPropFile;

import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnvTestWrite {

    public static void main(String[] args) {
        //1st Env Prod
        EnvKey envKey1 = new EnvKey();
        envKey1.setBaseUrl("http://abc.com");
        envKey1.setPort(8080);

        Env env1 = new Env();
        env1.envName = "Prod";
        env1.setEnvValues(envKey1);

        //2nd Env Sandbox
        EnvKey envKey2 = new EnvKey();
        envKey2.setBaseUrl("http://sb.abc.com");
        envKey2.setPort(4040);

        Env env2 = new Env();
        env2.envName = "Sandbox";
        env2.setEnvValues(envKey2);

        //Add all Env to List of Env
        List<Env> envList = new ArrayList<>();
        envList.add(env1);
        envList.add(env2);
        
        //Common Data
        EnvCommonData envCommonData = new EnvCommonData();
        envCommonData.vehicleServicePath = "/vehicle/";
        envCommonData.vehicleDepartureProfilesEndpoint = "v1/vehicles/{vin}/departure/profiles";
        envCommonData.vehicleSubscriptionsEndpoint = "v1/vehicles/{vin}/subscriptions";
        
        envCommonData.navigationServicePath = "/navigation/";
        envCommonData.navigationDirectionEndpoint = "v1/directions";
        envCommonData.navigationLocationEndpoint = "v1/locations";
        
        envCommonData.gamifyServicePath = "/";
        envCommonData.gamifyRewardsEndpoint = "gamify/{vin}/reward";
        
        //Add list of env to EnvPlaceholder
        EnvPlaceholder envPlaceholder = new EnvPlaceholder();
        envPlaceholder.setAllEnvData(envList);
        envPlaceholder.setCommonData(envCommonData);    
        
        //Write EnvPlaceholder object into Yaml
        Yaml yaml = new Yaml();
        try {
            String dataFile = "\\src\\test\\java\\yaml\\snake\\carad\\env.yaml";
            String strFile = System.getProperty("user.dir") + dataFile;
            yaml.dump(envPlaceholder, new FileWriter(strFile));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Env File Written successfully");
         
    }
}
