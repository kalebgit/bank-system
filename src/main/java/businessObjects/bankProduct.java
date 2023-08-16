package businessObjects;

public abstract class bankProduct {
	public static long productCount;
	
	static {
		productCount = 0;
	}
	
	protected long bankID;
	protected long branchID;
	protected long productID;
	
	
	//constructors
	
	public bankProduct(long bankID, long branch) {
		this.bankID = bankID;
		this.branchID = branchID;
		this.productID = productCount++;
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
	
}
