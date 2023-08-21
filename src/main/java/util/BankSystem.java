package util;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

import businessObjects.*;
import exceptions.BankException;

public class BankSystem {
	
	private static Set<Account> accounts;
	
	public BankSystem() {
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
				
				return account.getUserName() + " ha transferido $" + amount + " a " + receiver.getUserName() +
						"date: " + java.time.ZonedDateTime.now().toString();
			}catch(BankException e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				return sw.toString();
			}
	}
	
	public static boolean writeLog(String fileName, String message) {
		File file = new File(fileName);
		if(file.isFile()) {
			try(BufferedWriter output = new BufferedWriter(new FileWriter(file))){
				try(BufferedReader input = new BufferedReader(new FileReader(file))){
					if(input.ready()) {
						if(input.readLine() == "") {
							output.write(message);
						}else {
							output.newLine();
							output.write(message);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	
	public static <K, V> boolean createPropertiesFile(String fileName, Map<K, V> properties) {
		File file = new File("./" + fileName + ".properties");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
			for(Entry<K, V> data : properties.entrySet()) {
				writer.write(data.getKey() + "=" + data.getValue());
				writer.newLine();
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Properties getPropertiesFrom(String fileName) throws FileNotFoundException, IOException {
		File file = new File("./" + fileName);
		Properties p = new Properties();
		p.load(new BufferedReader(new FileReader(file)));
		return p;
	}

	
	public static void run() {
		
	}
	
}
