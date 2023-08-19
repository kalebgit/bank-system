package util;

import java.io.*;
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
	
	
	
	public static String generateTransaction(Account account) throws BankException {
		
			try {
				Account receiver = findAccount(new BigInteger("111111111111111111"));
				double amount = 500;
				account.transferTo(receiver, 500);
				Date today = new Date();
				return account.getUserName() + " ha transferido $" + amount + " a " + receiver.getUserName() +
						"date";
			}catch(BankException e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				return sw.toString();
			}
	}
	
	public static boolean writeLog(String fileName, String message) {
		byte[] m = message.getBytes();
		File file = new File(fileName);
		if(file.isFile()) {
			try(FileOutputStream output = new FileOutputStream(file)){
				try (BufferedOutputStream out = new BufferedOutputStream(output)){
					out.write(m);
					out.flush();
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	

	
	public static void run() {
		
	}
	
}
