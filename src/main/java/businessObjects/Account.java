package businessObjects;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

import dataAccessObject.DAO;
import dataSources.ConnectionSqlServer;
import exceptions.BankException;
import util.*;

public class Account extends BankProduct implements DAO<Account, Long>, ConnectionSqlServer{
	private String userName;
	private String password;
	private BigDecimal bankCode;
	private double money;
	private Set<DebitCard> debitCards;
	
	//GETTERS AND SETTERS
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getBankCode() {
		return bankCode;
	}

	public void setBankCode(BigDecimal bankCode) {
		this.bankCode = bankCode;
	}
	
	public Account(long productID, String userName, String password, BigDecimal bankCode) 
			throws BankException {
		super(productID);
		if(checkPasswordFormat(password)) {
			this.setPassword(password);
		}else {
			throw new BankException(BankExceptionType.WRONGFORMAT);
		}
		if((bankCode.compareTo(new BigDecimal("100000000000000000")) == 1 &&
				(bankCode.compareTo(new BigDecimal("999999999999999999")) == -1))) {
			this.bankCode = bankCode;
		}else {
			throw new BankException(BankExceptionType.WRONGFORMAT);
		}
		this.userName = userName;
		this.debitCards = new TreeSet<DebitCard>();
		this.money = 0;
	}
	
	
	
	public boolean checkPasswordFormat(String password) throws BankException{
		char[] passwordArray = password.toCharArray();
		char[] symbols = new char[] {'*', '#', '$', '%'};
		if((passwordArray[0] >= 65 && passwordArray[0] <= 90) && passwordArray.length > 12) {
			for(int i = 0; i < passwordArray.length; i++) {
				for(int y = 0; y < symbols.length; y++) {
					if(symbols[y] == passwordArray[i]) {
						return true;
					}
				}
			}
			throw new BankException(BankExceptionType.WRONGFORMAT);
		}
		throw new BankException(BankExceptionType.WRONGFORMAT);
	}
	
	//operations
	public boolean transferTo(Account receiver, double amount) throws BankException{
		try {
			if(this.hasFunds(amount)) {
				try {
					if(this.withdrawMoney(this.getDefaultDebitCard().getCardNumber(), amount)) {
						receiver.addMoney(amount);
					}
				}catch(BankException e) {
					throw new BankException(BankExceptionType.TRANSACTIONFAILED, e);
				}
			}
		}catch(BankException e) {
			throw new BankException(BankExceptionType.TRANSACTIONFAILED, e);
		}
		return true;
	}
	
	public double getMoney() {
		return this.money;
	}
	
	private void updateMoney(double money) {
		this.money += money;
	}
	
	private boolean hasFunds(double money) throws BankException{
		if(this.money >= money) {
			return true;
		}
		throw new BankException(BankExceptionType.NOTENOUGHMONEY);
	}
	
	public boolean withdrawMoney(BigDecimal cardNumber, double money) throws BankException{
		DebitCard card = this.findDebitCard(cardNumber);
		if(card.getMoney() >= money) {
			this.updateMoney(-money);
			card.updateMoney(-money);
			return true;
		}else {
			throw new BankException(BankExceptionType.NOTENOUGHMONEY);
		}
	}
	
	public boolean addMoney(double money) throws BankException{
		try {
			if(this.debitCards.size() > 0) {
				DebitCard card = this.getDefaultDebitCard();
				card.updateMoney(money);
			}
			this.updateMoney(money);
			return true;
		}catch(BankException e) {
			throw new BankException(BankExceptionType.TRANSACTIONFAILED, e);
		}
		
		
	}
	
	
	public void addDebitCard(DebitCard debitCard) {
		if(this.debitCards.size() == 0) {
			debitCard.setDefault(true);
		}
		this.debitCards.add(debitCard);
	}
	
	public void removeDebitCard(BigDecimal cardNumber) throws BankException {
		this.debitCards.remove(findDebitCard(cardNumber));
	}
	
	public DebitCard getDefaultDebitCard() throws BankException{
		for(DebitCard card : this.debitCards) {
			if(card.isDefault()) {
				return card;
			}
		}
		throw new BankException(BankExceptionType.CARDNOTFOUND, ", no se encontro tarjeta por default");
	}
	
	public DebitCard findDebitCard(BigDecimal cardNumber) throws BankException {
		 for(DebitCard card : this.debitCards) {
			 if(card.getCardNumber() == cardNumber) {
				 return card;
			 }
		 }
		 throw new BankException(BankExceptionType.CARDNOTFOUND);
	}
	
	
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductFormatType.ACCOUNT.getFormat());
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bankCode, userName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(bankCode, other.bankCode) && Objects.equals(userName, other.userName);
	}

	

	@Override
	public boolean insert(Account element) {
		Connection conn = getConnection();
		String query = "INSERT INTO Account(BankCode, Username, Password, Funds) VALUES"
				+ "(?, ?, ?, ?)";
		PreparedStatement p;
		try {
			p = conn.prepareStatement(query);
			p.setBigDecimal(1,element.getBankCode());
			p.setString(2, element.getUserName());
			p.setString(3, element.getPassword());
			p.setDouble(4, element.getMoney());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Account element) {
		Connection conn = getConnection();
		String query = "UPDATE Account SET BankCode=?, Username=?, password=?, funds=? "
				+ "WHERE AccountID=? AND BankCode=? AND Username=?";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setBigDecimal(1, element.getBankCode());
			p.setString(2, element.getUserName());
			p.setString(3, element.getPassword());
			p.setDouble(4, element.getMoney());
			p.setLong(5, element.getProductID());
			p.setBigDecimal(6, element.getBankCode());
			p.setString(7, element.getUserName());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Account element) {
		Connection conn = getConnection();
		String query = "DELETE FROM Account WHERE AccountID=? AND BankCode=? AND Username=? ";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setLong(1, element.getProductID());
			p.setBigDecimal(2, element.getBankCode());
			p.setString(3, element.getUserName());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	
}
