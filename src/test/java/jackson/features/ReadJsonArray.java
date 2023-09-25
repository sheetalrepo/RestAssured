package jackson.features;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Mapper pojo class required to parse json
 * 
 * 
 * @author Sheetal_Singh
 */
public class ReadJsonArray {
	static ObjectMapper objMapper = new ObjectMapper();
	
	public static void readJsonArray(String filepath) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("===== * ===== * =====");
		Months[] arr = objMapper.readValue(new File(filepath), Months[].class);
		System.out.println("Length:" + arr.length);
		
		System.out.println("===== * ===== * =====");
		List<Months> ls1 = Arrays.asList(objMapper.readValue(new File(filepath), Months[].class));
		ls1.stream().forEach(x -> System.out.println(x.getName()));
		
		System.out.println("===== * ===== * =====");
		List<Months> ls2 = objMapper.readValue(new File(filepath), new TypeReference<List<Months>>(){});
		ls2.stream().forEach(x -> System.out.println(x.getDescription()));
		System.out.println("===== * ===== * =====");
	}
	

	
	public static void main(String[] args) throws IOException {
		String filepath = "./src/test/java/jackson/features/months.json";
		readJsonArray(filepath);
	}
}
