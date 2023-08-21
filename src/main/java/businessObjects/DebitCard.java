package businessObjects;

import java.math.BigInteger;
import java.util.Objects;

import exceptions.BankException;
import util.*;

public class DebitCard extends BankProduct {
	
	private BigInteger cardNumber;
	private double money;
	private int nip;
	private boolean isDefault;
	
	public DebitCard(long productID, int nip, BigInteger cardNumber) throws BankException  {
		super(productID);
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
		this.isDefault = false;
	}
	
	public double getMoney() {
		return this.money;
	}
	
	public void updateMoney(double money) {
		this.money += money;
	}
	
	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String formatID() {
		return NumberFormatter.formatNumber(this.productID.byteValue(), ProductFormatType.CARD.getFormat());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardNumber);
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
		DebitCard other = (DebitCard) obj;
		return Objects.equals(cardNumber, other.cardNumber);
	}

	
	
	
	
	
	
}
