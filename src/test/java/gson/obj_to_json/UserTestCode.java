package gson.obj_to_json;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * Serialization : Java Object -> Json String/File etc
 * Here we initialize java obj with constructor rather getter setter
 */
public class UserTestCode {

	public static void main(String[] args) {
		//Initializing Java Object
		UserAddress userAddress = new UserAddress("Main Street", "100", "Malaga", "Spain");
		UserNested javaObject = new UserNested("Sheetal", "norman@futurestud.io", true, 26, userAddress);

		Gson gson = new Gson();
		String userWithAddressJson = gson.toJson(javaObject);

		System.out.print("Json String: \n"+userWithAddressJson);

		String file = ".\\src\\test\\java\\gson\\obj_to_json\\user_output.json";
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
			gson.toJson(javaObject, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nFile created succesfully");

	}

}
