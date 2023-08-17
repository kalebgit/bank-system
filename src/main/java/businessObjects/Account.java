package businessObjects;
import util.*;

public class Account extends BankProduct{

	public static long accountCount;
	
	static {
		accountCount = 0;
	}
	
	public Account(long bankID, long branchID) {
		super(bankID, branchID);
		
		this.productID = Long.valueOf(accountCount++);
	}
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductType.ACCOUNT.getFormat());
	}
}
