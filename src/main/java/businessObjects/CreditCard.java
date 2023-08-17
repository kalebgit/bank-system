package businessObjects;
import util.*;

public class CreditCard extends BankProduct{
	
	public CreditCard(long bankID, long branchID) {
		super(bankID, branchID);
	}
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductType.CREDITCARD.getFormat());
	}
	
	
}
