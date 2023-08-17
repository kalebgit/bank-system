package util;

public enum BankExceptionType {
	PRODUCTNOTFOUND((byte)1, "El producto no fue encontrado"), PRODUCTTYPENOTDECLARED((byte)2, 
			"El tipo de producto no se encuentra en ninguna de nuestras listas"), 
	WRONGFORMAT((byte)3, "El formato que se ingreso es incorrecto");
	
	private Byte code;
	private String message;
	
	private BankExceptionType(byte code, String message){
		this.code = Byte.valueOf(code);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
