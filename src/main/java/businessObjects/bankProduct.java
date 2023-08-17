package businessObjects;

public abstract class BankProduct {
	public static long productCount;
	
	static {
		productCount = 0;
	}
	
	protected long bankID;
	protected long branchID;
	protected Long productID;
	
	
	//constructors
	
	public BankProduct(long bankID, long branchID) {
		this.bankID = bankID;
		this.branchID = branchID;
		this.productID = Long.valueOf(productCount++);
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
}
