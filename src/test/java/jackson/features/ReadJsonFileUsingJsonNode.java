package jackson.features;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * 
 * Json File -> JsonNode
 * 
 * Reading values from Json without using POJOs JsonArray, NestedJson
 * 
 * Usage: Can be used for reading properties, test data etc
 * 
 * @author Sheetal_Singh
 */
public class ReadJsonFileUsingJsonNode {
	static ObjectMapper objMapper = new ObjectMapper();

	private static void readJsonNodeSimple(JsonNode jsonNode, String baseNodeName) {
		System.out.println("===== * ===== * =====");
		JsonNode nodeBob = jsonNode.get(baseNodeName);
		String firstName = nodeBob.get("firstname").asText();
		String age = nodeBob.get("age").asText();
		System.out.println("FN: " + firstName);
		System.out.println("Age: " + age);
		System.out.println("===== * ===== * =====");
	}

	// Reading nested json node {}
	private static void readNestedJson(JsonNode jsonNode, String baseNodeName) {
		JsonNode nodeBob = jsonNode.get(baseNodeName);
		JsonNode addressNode = nodeBob.get("address");
		String hNo = addressNode.get("hno").asText();
		System.out.println("HNo:" + hNo);
		System.out.println("===== * ===== * =====");
	}

	/**
	 * Reading nested json array [] - using get(index)
	 * Reading nested json array [] - using ArrayNode
	 */
	private static void readJsonArray(JsonNode jsonNode, String baseNodeName) {
		JsonNode nodeBob = jsonNode.get(baseNodeName);
		JsonNode skillsNode = nodeBob.get("skills");
		String s1 = skillsNode.get(2).asText();
		System.out.println("Skill:" + s1);

		ArrayNode arraySkillsNode = (ArrayNode) nodeBob.get("skills");
		if (arraySkillsNode.isArray()) {
			System.out.println("Skills:");
			for (JsonNode value : arraySkillsNode) {
				String val = value.asText();
				System.out.println(val);
			}
		}
		System.out.println("===== * ===== * =====");
	}

	public static void main(String[] args) throws IOException {
		String jsonFile = "./src/test/java/jackson/features/users.json";
		JsonNode jsonNode = objMapper.readTree(new File(jsonFile));

		//readJsonNodeSimple(jsonNode, "Bob");
		//readNestedJson(jsonNode, "Bob");
		readJsonArray(jsonNode, "Bob");
	}

}
