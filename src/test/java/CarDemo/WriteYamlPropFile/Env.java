package CarDemo.WriteYamlPropFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Env {
    String envName;
    EnvKey envValues;
}
