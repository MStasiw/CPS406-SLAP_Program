/**
 * 
 */
package slap;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Michael
 *
 */
public class AccountMap_NoUsingObj {
	
	private SortedMap<String, String> map = null;

	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1609641885705800721L;*/

	/**
	 * 
	 */
	public AccountMap_NoUsingObj() {
		map = new TreeMap<String, String>();
		// TODO Auto-generated constructor stub
	}

	protected boolean addAccount(String username, String psw) {
		if (!this.userExist(username)) {
			try {
				map.put(username, psw);
				if (this.userExist(username)) {
					return true;
				}else{
					System.err.println("Error occured: " + username + "was not added to map");
				}
			}catch(Exception e) {
				System.err.println("Error occured: " + username + "was not added to map");
				return false;
			}
		}
		return false;
	}
	
	private boolean userExist(String username) {
		return map.containsKey(username);
	}
	
	private boolean changeUsername(String oldName, String newName) {
		String psw = null;
		if (this.userExist(oldName)) {
			try {
				psw = map.get(oldName);
				map.remove(oldName);
				this.addAccount(newName, psw);
			}catch(Exception e) {
				System.err.println("Error occured: username for: " + oldName + " was not changed.");
				return false;
			}
		}
		return true;
	}
	
	private boolean changePassword(String username, String newPassword) {
		if (this.userExist(username)) {
			try {
				map.put(username, newPassword); //overwrites password value
			}catch(Exception e) {
				System.err.println("Error occured: password for username: " + username + " was not changed.");
				return false;
			}
		}
		return true;
	}
}
