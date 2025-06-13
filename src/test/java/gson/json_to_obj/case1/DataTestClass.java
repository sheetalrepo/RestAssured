package gson.json_to_obj.case1;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

/**
 * Deserialization : Json to Java Object
 * @author Sheetal_Singh
 */
public class DataTestClass {

	
	public static DataPlaceholder getJsonDataAsJavaObj(String path, Gson gson) {
		DataPlaceholder data = null;
		try (Reader reader = new FileReader(path)) {
			data = gson.fromJson(reader, DataPlaceholder.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	private static void printme(DataPlaceholder data) {
		System.out.println("Photo ID: "+data.getData().get(2).getPhotoId());
		System.out.println("Photo ID: "+data.getData().get(2).getCategory());
	}
	
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		String path = ".\\src\\test\\java\\gson\\json_to_obj\\case1\\data.json";
		DataPlaceholder base = getJsonDataAsJavaObj(path, gson);
		printme(base);
	}

}
