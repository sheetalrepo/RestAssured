package yaml.snake.readYaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.yaml.snakeyaml.Yaml;

public class ChildTestClass {

    public static void main(String[] args) {
        String yamlPath = ".\\src\\test\\java\\yaml\\snake\\readYaml\\data.yaml";
        Yaml yaml = new Yaml();
        ChildPlaceholder placeholder = null;
        try {
            placeholder = yaml.loadAs(new FileReader(new File(yamlPath)), ChildPlaceholder.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(placeholder);

    }

}