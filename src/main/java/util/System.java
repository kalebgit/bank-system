package util;

import java.util.*;

import businessObjects.*;

public class System {
	
	private static Set<Account> accounts;
	
	public System() {
		accounts = new TreeSet<Account>();
	}
	
	public static boolean login(String userName, String password) {
		for(Account account : accounts) {
			if(account.getUserName().equals(userName) && account.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
}
