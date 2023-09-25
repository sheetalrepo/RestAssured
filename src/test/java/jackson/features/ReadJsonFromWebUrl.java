package jackson.features;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Web URL -> JsonNode
 * 
 * @author Sheetal_Singh
 */
public class ReadJsonFromWebUrl {

	private static void readJsonFromWebUrl(String api) throws JsonParseException, JsonMappingException, IOException {

		URL url = new URL(api);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readValue(url, JsonNode.class);

		System.out.println("===== * ===== * =====");
		System.out.println("Sentence: " + jsonNode.get("sentence").asText());
		System.out.println("Character: " + jsonNode.path("character").path("name").asText());
		System.out.println("House Name:" + jsonNode.path("character").path("house").path("name").asText());
		System.out.println("===== * ===== * =====");
	}

	public static void main(String[] args) throws IOException {
		String api = "https://game-of-thrones-quotes.herokuapp.com/v1/random";
		readJsonFromWebUrl(api);
	}

}
