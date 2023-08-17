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
	
	public Account(long bankID, long branchID, String userName, String password) throws BankException {
		super(bankID, branchID);
		if(checkPasswordFormat(password)) {
			this.password = password;
		}
		this.userName = userName;
		
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
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductType.ACCOUNT.getFormat());
	}
}
