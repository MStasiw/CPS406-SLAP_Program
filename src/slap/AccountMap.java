/**
 * 
 */
package slap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Michael
 *
 */
public class AccountMap {
	
	private SortedMap<String, Account> map = null;

	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1609641885705800721L;*/

	/**
	 * 
	 */
	public AccountMap() {
		map = new TreeMap<String, Account>();
		// TODO Auto-generated constructor stub
	}

	protected boolean addAccount(Account userAccount) {
		if (!this.userExist(userAccount.getUsername())) {
			try {
				map.put(userAccount.getUsername(), userAccount);
				if (this.userExist(userAccount.getUsername())) {
					return true;
				}else{
					System.err.println("Error occured: " + userAccount.getUsername() + "was not added to map");
				}
			}catch(Exception e) {
				System.err.println("Error occured: " + userAccount.getUsername() + "was not added to map");
				return false;
			}
		}
		return false;
	}
	
	protected boolean userExist(String username) {
		return map.containsKey(username);
	}
	
	protected boolean changeUsername(Account userAccount, String newName) {
		Account tempAccount = null;
		if (this.userExist(userAccount.getUsername())) {
			try {
				tempAccount = map.get(userAccount.getUsername());
				map.remove(userAccount.getUsername());
				this.addAccount(tempAccount);
			}catch(Exception e) {
				System.err.println("Error occured: username for: " + userAccount.getUsername() + " was not changed.");
				return false;
			}
		}
		return true;
	}
	
	protected Account getAccountObj(String username) {
		if (this.userExist(username)) {
			try {
				return map.get(username);
			}catch(Exception e) {
				System.err.println("Error occured retrieving user account for username: " + username + ".");
			}
		}
		return null;
	}

	/*
	 * Internal Development and/or Testing method
	 * DO NOT USE in final product: SECURITY RISK
	 *  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		return "AccountMap ["
				+ (map != null ? "map=" + toString(map.entrySet(), maxLen) : "")
				+ "]";
	}

	/**
	 * @param collection
	 * @param maxLen
	 * @return
	 */
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[{");
		String key = null;
		String username = "";
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append("}, {");
			key = iterator.next().toString();
			username = key.substring(0, key.indexOf('='));
			builder.append(key + ", ");
			builder.append(map.get(username).getPsw());
		}
		builder.append("}]");
		return builder.toString();
	}
}
