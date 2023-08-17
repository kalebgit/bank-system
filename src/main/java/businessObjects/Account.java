package businessObjects;
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
			this.password = password;
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
}
