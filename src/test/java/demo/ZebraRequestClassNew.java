package demo;

/**
 * Application: Our system take json input of Zebra(age,wt and country) and 
 * in response allocate a registration id and the city where zebra will be transferred 
 * 
 * This class contains json elements for request calls
 * 
 *  {  
		   "age":"10",
		   "weight":"100",
		   "home":"India"
	 }
 * 
 */
public class ZebraRequestClassNew {
	int age;
	int weight;
	String home;
	
	public int getAge() {
		return age;
	}
	public int getWeight() {
		return weight;
	}
	public String getHome() {
		return home;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setHome(String home) {
		this.home = home;
	}
	
}
