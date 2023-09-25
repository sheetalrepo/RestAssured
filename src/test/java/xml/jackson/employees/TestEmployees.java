package xml.jackson.employees;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestEmployees {
	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new XmlMapper();
		Employees employees = objectMapper.readValue(StringUtils.toEncodedString(
				Files.readAllBytes(Paths.get("./src/test/java/xml/jackson/employees/employees.xml")),
				StandardCharsets.UTF_8), Employees.class);

		Employee emp1 = employees.getEmployee()[0];
		System.out.println("Emp1:" + emp1.getId() + " " + emp1.getFirstName());

		Employee emp2 = employees.getEmployee()[1];
		System.out.println("Emp2:" + emp2.getId() + " " + emp2.getFirstName());

	}
}
