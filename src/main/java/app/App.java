package app;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import businessObjects.Account;

import java.sql.*;
import util.FileManager;
import dataSources.*;
import exceptions.BankException;
public class App {
	public static void main(String[] args) {
		
		AccountImplementation a = new AccountImplementation();  
		try {
			System.out.println(a.delete(new Account(1, "emi", "Kalebfdsafd2005#", new BigDecimal("100000000000000001"))));
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


