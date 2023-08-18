package util;

import java.math.BigInteger;
import java.util.*;

import businessObjects.*;
import exceptions.BankException;

public class System {
	
	private static Set<Account> accounts;
	
	public System() {
		accounts = new TreeSet<Account>();
	}
	
	public static boolean login(String userName, String password) throws BankException{
		for(Account account : accounts) {
			if(account.getUserName().equals(userName) && account.getPassword().equals(password)) {
				return true;
			}
		}
		throw new BankException(BankExceptionType.USERNOTFOUND) ;
	}
	
	public static boolean register(Account newAccount) throws BankException{
		for(Account account : accounts) {
			if(account.equals(newAccount)) {
				throw new BankException(BankExceptionType.DUPLICATEUSER);
			}
		}
		return true ;
	}
	
	public static Account findAccount(BigInteger bankCode) throws BankException{
		for(Account account : accounts) {
			if(account.getBankCode().equals(bankCode)) {
				return account;
			}
		}
		throw new BankException(BankExceptionType.USERNOTFOUND, ": NO SE ENCONTRO UN USUARIO CON LA CLABE");
		
	}
	
	public static boolean generateTransaction(Account account) {
		boolean access = false;
		do {
			try {
				
			}catch(BankException e) {
				e.printStackTrace();
				access =  true;
				
				
			}
		}while(access);
	}
	

	
	public static void run() {
		
	}
	
}
