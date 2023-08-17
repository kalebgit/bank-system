package util;

public enum ProductType {
	ACCOUNT("###-#-#####/#"), BANKCODE("######## ##############"), CREDITCARD("#### #### #### ####"),
	CREDITCARDCODE("###"), BRANCH("####");
	
	private String format;
	
	private ProductType(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}
}
