package businessObjects;
import util.*;

public class CreditCard extends BankProduct{
	
	public static long cardCount;
	
	static {
		cardCount = 0;
	}
	
	public CreditCard(long productID) {
		super(productID);
		
		this.productID = Long.valueOf(cardCount++);
	}
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.longValue(), ProductFormatType.CARD.getFormat());
	}
	
	
}
