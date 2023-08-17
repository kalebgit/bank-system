package businessObjects;

import java.util.Objects;

public abstract class BankProduct {
	
	
	protected long bankID;
	protected long branchID;
	protected Long productID;
	
	
	//constructors
	
	public BankProduct(long bankID, long branchID) {
		this.bankID = bankID;
		this.branchID = branchID;
		
	}


	public long getBankID() {
		return bankID;
	}


	public void setBankID(long bankID) {
		this.bankID = bankID;
	}


	public long getBranchID() {
		return branchID;
	}


	public void setBranchID(long branchID) {
		this.branchID = branchID;
	}


	public long getProductID() {
		return productID;
	}


	public void setProductID(long productID) {
		this.productID = productID;
	}

	//getters and setters

	
	//other members
	protected abstract String formatID();
	
	public String toString() {
		return formatID();
	}


	@Override
	public int hashCode() {
		return Objects.hash(bankID, branchID, productID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankProduct other = (BankProduct) obj;
		return bankID == other.bankID && branchID == other.branchID && Objects.equals(productID, other.productID);
	}
	
	
}
