package businessObjects;

import java.math.BigInteger;

import exceptions.BankException;
import util.*;

public class DebitCard extends BankProduct {
	
	public static long cardCount;
	
	static {
		cardCount = 0;
	}
	
	private BigInteger cardNumber;
	private double money;
	private int nip;
	
	public DebitCard(long bankID, long branchID, int nip, BigInteger cardNumber) throws BankException  {
		super(bankID, branchID);
		this.money = 0;
		if((cardNumber.compareTo(new BigInteger("1000000000000000")) == 1 && 
				cardNumber.compareTo(new BigInteger("999999999999")) == -1) 
				&&
			(nip > 1000 && nip < 9999)) {
			this.cardNumber = cardNumber;
			this.nip = nip;
		}
		else {
			throw new BankException(BankExceptionType.WRONGFORMAT);
		}
		this.productID = Long.valueOf(cardCount++);
	}
	
	public double getMoney() {
		return this.money;
	}
	
	public void updateMoney(double money) {
		this.money += money;
	}
	
	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.byteValue(), ProductType.CARD.getFormat());
	}
	
	
	
}
