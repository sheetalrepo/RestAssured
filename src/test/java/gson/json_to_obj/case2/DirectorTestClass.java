package gson.json_to_obj.case2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

/**
 * Deserialization : Json to Java Object
 * @author Sheetal_Singh
 */
public class DirectorTestClass {

	
	public static void main(String[] args) {
		Gson gson = new Gson();
		Director dir = null;
		String path = ".\\src\\test\\java\\gson\\json_to_obj\\case2\\director.json";
		
		
		try (Reader reader = new FileReader(path)) {
			dir = gson.fromJson(reader, Director.class);
			
		}catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println(dir.toString());
		System.out.println("Director Name: "+dir.getName());
		
		
	}
}
