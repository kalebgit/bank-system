package businessObjects;
import java.util.Objects;

import exceptions.BankException;
import util.*;

public class Account extends BankProduct{

	public static long accountCount;
	
	static {
		accountCount = 0;
	}
	
	
	private String userName;
	private String password;
	private DebitCard debitCard;
	
	public Account(long bankID, long branchID, String userName, String password, DebitCard debitCard) 
			throws BankException {
		super(bankID, branchID);
		if(checkPasswordFormat(password)) {
			this.setPassword(password);
		}
		this.userName = userName;
		this.debitCard = debitCard;
		this.productID = Long.valueOf(accountCount++);
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
	public boolean transferTo(Account receiver, double amount) {
		if(this.debitCard.getMoney() >= amount) {
			this.debitCard.updateMoney(-amount);
			receiver.debitCard.updateMoney(amount);
			return true;
		}
		
		return false;
	}
	
	
	
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductType.ACCOUNT.getFormat());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(debitCard, userName);
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
		return Objects.equals(debitCard, other.debitCard) && Objects.equals(userName, other.userName);
	}

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

	
	
	
	
}
