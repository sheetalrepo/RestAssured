package gson.multiple_conversion;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Json Object, Json Element, Json Array examples
 * 
 * Without making POJOs we can fetch data from JSON
 * 
 * @author Sheetal_Singh
 *
 */
public class JsonObjectExamples {

	public static JsonObject getJsonObjectFromJson(String path,Gson gson) {

		Reader reader = null;
		try {
			reader = new FileReader(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// JSON Element
		JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);

		// JSON Element -> JSON String
		String jsonString = gson.toJson(jsonElement);
		
		// JSON Element -> JSON Object
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		return jsonObject;
	}

	// We could have converted json to java obj directly as well
	public static void fetchData(JsonObject jsonObject,Gson gson) {
		String id = jsonObject.get("ID").getAsString();
		String name = jsonObject.get("Name").getAsString();
		JsonArray arraySkills = jsonObject.getAsJsonArray("Skills");

		@SuppressWarnings("unchecked")
		List<String> list = gson.fromJson(arraySkills, ArrayList.class);

		System.out.println("Id: " + id);
		System.out.println("Name: " + name);
		System.out.println("Skills: " + list);
	}
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		String path = ".\\src\\test\\java\\gson\\multiple_conversion\\abc.json";
		JsonObject jsonObject = getJsonObjectFromJson(path, gson);
		fetchData(jsonObject, gson);
	}

}
