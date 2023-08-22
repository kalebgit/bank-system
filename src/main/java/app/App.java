package app;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import businessObjects.*;

import java.sql.*;

import util.BankSystem;
import util.FileManager;
import dataSources.*;
import exceptions.BankException;
public class App {
	public static void main(String[] args) {
		
		DAOManager manager = new DAOManager(false);
		AccountDAO accountdao = manager.getAccountDAO();
		
		
		try {
//			System.out.println( accountdao.insert(new Account(1, "emi", "Kaleb4320483#", new BigDecimal("100000000000000001"),0)));
			
//			Account emi = accountdao.getSingleByBankCode(new BigDecimal("100000000000000001"));
//			
//			emi.addDebitCard(new DebitCard(1, new BigDecimal("1000000000000001"), 4893, 0, false));
			BankSystem sys = new BankSystem();
			Account account = sys.login("emi", "Kaleb4320483#");
//			account.addDebitCard(new DebitCard(1, new BigDecimal("1000000000000002"), 1039, 0, false));
			
//			Account newaccount = new Account(1, "andy", "Andresitos23#", new BigDecimal("100000000000000002"),0);
//			System.out.println(sys.register(newaccount));
//			Account account = sys.login("andy", "Andresitos23#");
//			account.addMoney(1000);
			
			
			DAOManager man = new DAOManager(true);
			TransferDAO tran = manager.getTransferDAO();
			String log = tran.generateTransaction(new Transfer(Long.valueOf(1), account, accountdao.getSingleByBankCode(new BigDecimal("100000000000000002")), 315.00));
			System.out.println(log);
			System.out.println(BankSystem.writeLog("bankOperations/transferLog.txt", log));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
/*dummy data creations
 * 
 * 
 * Account 
 * new Account(1, "emi", "Kaleb4320483#", new BigDecimal("100000000000000000"),0)
 * 
 * DebitCard
 * new DebitCard(1, new BigDecimal("1000000000000000"), 0809, 0, false)
 */
	
}


