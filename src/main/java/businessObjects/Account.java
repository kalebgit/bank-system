package businessObjects;
import util.*;
public class Account extends BankProduct{
	
	public Account(long bankID, long branchID) {
		super(bankID, branchID);
	}
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductType.ACCOUNT.getFormat());
	}
}
