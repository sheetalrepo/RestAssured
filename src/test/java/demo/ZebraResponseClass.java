package demo;


/**
 * 
 * This class contains json elements for response calls
 * reg id will be unique and city depends upon where slots are free for more zebra accomodations
 * 
 *  {  
		   "regID":"1101",
		   "city":"Delhi"
	 }
 * 
 */
public class ZebraResponseClass {
	int regId;
	String city;
	
	public int getRegId() {
		return regId;
	}
	public String getCity() {
		return city;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
