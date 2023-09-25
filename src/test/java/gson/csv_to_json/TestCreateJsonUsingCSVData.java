package gson.csv_to_json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.opencsv.CSVReader;

/**
 * This class read data from csv and create a single json with all employee data in it
 * 
 * csv -> hash map -> pojo -> json(via gson lib)
 * 
 * json can be passed to POST req etc
 *
 */
public class TestCreateJsonUsingCSVData {

	
	/**
	 * This method will read complete test data present in csv file and create a big LinkedHashMap
	 * 
	 * Big hash map contains test case id as key & val as <title heading,title value>
	 * <"1",  <"Name","Sheetal">,"Surname":"Singh","Age":35,  >
	 * <"2",  <"Name","John">>
	 * 
	 * LinkedHM chosen just go get data in same sequence as it has been arranged in CSV
	 */
	public static LinkedHashMap<String, LinkedHashMap<String, String>> readCompleteCSVFile(File file) throws IOException{
		FileReader fr = new FileReader(file);

		CSVReader csvReader = new CSVReader(fr);
		List<String []> allCSVData = csvReader.readAll();
		csvReader.close();
		
		LinkedHashMap<String, LinkedHashMap<String, String>> bigLinkedHashMap = new LinkedHashMap<>();
		
		String [] headersArray = allCSVData.get(0);
		List<String> headersList = Arrays.asList(headersArray);
		
		for (int i = 1; i < allCSVData.size(); i++) {			
			List<String> bodyRow = Arrays.asList(allCSVData.get(i));
			
			LinkedHashMap<String, String> smallLinkedHashMap = new LinkedHashMap<>();
			for (int j = 0; j < headersList.size(); j++) {
				smallLinkedHashMap.put(headersList.get(j), bodyRow.get(j));
			}
			bigLinkedHashMap.put(bodyRow.get(0), smallLinkedHashMap);							
		}
		return bigLinkedHashMap;	
	}
	
	
	public static ServicePlaceholderPojo convertLinkedHashMaptoPojoObject(LinkedHashMap<String, LinkedHashMap<String, String>> bigMap){
		ServicePlaceholderPojo service = new ServicePlaceholderPojo();
		List<Employee> lsEmp = new ArrayList<>();
		
		//run as per row count excluding headers
		for(LinkedHashMap<String, String> lhm : bigMap.values()){
			
			Employee employee = new Employee();
			Address address = new Address();
			AddressGeo addressgeo = new AddressGeo();
			Office office = new Office();
			OfficeA officea = new OfficeA();
			OfficeB officeb = new OfficeB();
			
			for(Entry<String, String> entry : lhm.entrySet()){
				String key = entry.getKey();
				String value = entry.getValue();
				
				//all classes has been initialized
				switch(key){
					case "Name": employee.setName(value);break;
					case "Surname": employee.setSurname(value);break;
					case "Age": employee.setAge(value);break;
					
					case "Address#Hno": address.setHno(value);break;
					case "Address#Block": address.setBlock(value);break;
					case "Address#Area": address.setArea(value);break;
					case "Address#State": address.setState(value);break;
					
					case "Address#AddressGeo#Lat": addressgeo.setLatitude(value);break;
					case "Address#AddressGeo#Long": addressgeo.setLongitude(value);break;
					
					case "Office#Office-A#Name": officea.setName(value);break;
					case "Office#Office-A#Client": officea.setClient(value);break;
					case "Office#Office-A#Teamsize": officea.setTeamSize(value);break;
					
					case "Office#Office-B#Name": officeb.setName(value);break;
					case "Office#Office-B#Client": officeb.setClient(value);break;
					case "Office#Office-B#Teamsize": officeb.setTeamSize(value);break;
				}
			}
			
			//create single 'service' object for one row
			address.setAddressGeo(addressgeo);
			office.setOfficeA(officea);
			office.setOfficeB(officeb);
			
			employee.setAddress(address);
			employee.setOffice(office);
			
			lsEmp.add(employee);
		}
		
		service.setEmployee(lsEmp);
		
		return service;
	}

	public static void main(String[] args) throws IOException {
		//read input csv
		String csvFilePath = ".\\src\\test\\java\\gson\\csv_to_json\\inputdata.csv";
		
		LinkedHashMap<String, LinkedHashMap<String, String>> bigLinkedHashMap = 
				readCompleteCSVFile(new File(csvFilePath));
		
		
		//convert into java object
		ServicePlaceholderPojo service = TestCreateJsonUsingCSVData.convertLinkedHashMaptoPojoObject(bigLinkedHashMap);
		
			
		//create json file
		String file = ".\\src\\test\\java\\gson\\csv_to_json\\empusingcsv.json";
		FileWriter fw = null;
		
		Gson gson = new Gson();
		try {
			fw = new FileWriter(file);
			gson.toJson(service, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Json file 'empusingcsv.json' created successfully from 'inputdata.csv'");
	}

}
