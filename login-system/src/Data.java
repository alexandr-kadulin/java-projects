import java.util.HashMap;

public class Data {
	
	HashMap<String, String> userData = new HashMap<String, String>();
	
	Data() {
		
		userData.put("John", "secret1");
		userData.put("Anna", "secret2");
		userData.put("Susy", "secret3");
	}
	
	protected HashMap<String, String> getUserData() {
		
		return userData;
	}
}
