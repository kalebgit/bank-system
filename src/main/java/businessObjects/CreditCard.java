package businessObjects;
import util.*;

public class CreditCard extends BankProduct{
	
	public static long cardCount;
	
	static {
		cardCount = 0;
	}
	
	public CreditCard(long bankID, long branchID) {
		super(bankID, branchID);
		
		this.productID = Long.valueOf(cardCount++);
	}
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductType.CARD.getFormat());
	}
	
	
}
