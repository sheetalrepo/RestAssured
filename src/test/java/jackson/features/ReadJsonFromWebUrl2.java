package jackson.features;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json File -> URI -> URL -> JsonNode 
 * 
 * @author Sheetal_Singh
 */
public class ReadJsonFromWebUrl2 {

	public static void jsonFileURLBasic() throws IOException {
		File file = new File("./src/test/java/jackson/features/users.json");
		System.out.println("Path:" + file.getPath());

		// File -> URI
		URI uri = file.toURI();
		System.out.println("URI: " + uri.toString());

		// URI -> URL
		URL url = uri.toURL();
		System.out.println("URL: " + url.toString());

		// URL -> jsonNode
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readValue(url, JsonNode.class);
		JsonNode nodeBob = jsonNode.get("Bob");
		String firstName = nodeBob.get("firstname").asText();
		String age = nodeBob.get("age").asText();
		System.out.println("FN: " + firstName);
		System.out.println("Age: " + age);
	}

	public static void main(String[] args) throws IOException {
		jsonFileURLBasic();

	}

}
