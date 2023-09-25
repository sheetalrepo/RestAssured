package yaml.snake;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 * 
 * https://bitbucket.org/asomov/snakeyaml/wiki/Documentation#markdown-header-installation
 * https://confluence.atlassian.com/get-started-with-bitbucket/git-and-mercurial-commands-860009656.html
 *
 */
public class BasicTests {

	// Eg 1: Yaml String to Java Map
	public void stringToMap() {
		Yaml yaml = new Yaml();

		String str = "hello: 25";
		Map<String, Integer> map = yaml.load(str);

		Integer value = map.get("hello");
		System.out.println(value);
	}

	// Eg 2: Multiple str line to Map
	public void multipleStringLinesToMap() {
		Yaml yaml = new Yaml();

		// Read String as Object
		String str = "name: Joe\n" + "phone: 111-111-1111\n" + "address: Park Dr, Charlie Hill";
		Object obj = yaml.load(str);

		// Object Type as LinkedHashMap
		System.out.println("Object Type: " + obj.getClass());

		// Convert Object into Map
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) obj;

		System.out.println("Name: " + map.get("name"));
		System.out.println(map);

	}

	// Eg 3: Yaml File To Map
	public void yamlFileToMap() throws FileNotFoundException {
		Yaml yaml = new Yaml();

		String path = ".\\src\\test\\java\\yaml\\snake\\basic.yaml";
		Map<String, String> map = yaml.load(new FileInputStream(new File(path)));

		System.out.println(map.get("name"));
		System.out.println(map);
	}

	public static void main(String[] args) throws IOException {
		BasicTests obj = new BasicTests();
		obj.stringToMap();
		//obj.multipleStringLinesToMap();
		//obj.yamlFileToMap();
	}

}
