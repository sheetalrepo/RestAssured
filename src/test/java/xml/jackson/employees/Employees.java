package xml.jackson.employees;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employees") 
public class Employees {

	@JacksonXmlElementWrapper(localName = "employee", useWrapping = false)
	private Employee[] employee;

	public Employee[] getEmployee() {
		return employee;
	}

	public void setEmployee(Employee[] employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ClassPojo [employee = " + employee + "]";
	}
}