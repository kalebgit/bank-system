package util;

public enum ProductType {
	ACCOUNT("###-#-#####/#"), BANKCODE("######## ##############"), CARD("#### #### #### ####"),
	CREDITCARDCODE("###"), BRANCH("####");
	
	private String format;
	
	private ProductType(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}
}
