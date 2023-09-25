package gson.json_to_obj;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import com.google.gson.Gson;

public class PetTestClass {

	public static PetsBase getJsonDataAsJavaObj(String path, Gson gson) {
		PetsBase petsbase = null;
		try (Reader reader = new FileReader(path)) {
			petsbase = gson.fromJson(reader, PetsBase.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return petsbase;
	}

	private static void printme(PetsBase base) {
		System.out.println("Pet1: " + base.getPet1().get(1).getName());
		System.out.println("PetRobo: " + base.getPet3Robo().get(0).getHp());
	}

	public static void main(String[] args) {
		Gson gson = new Gson();
		String path = ".\\src\\test\\java\\gson\\json_to_obj\\pet.json";
		PetsBase baseObj = getJsonDataAsJavaObj(path, gson);
		printme(baseObj);
	}
}
