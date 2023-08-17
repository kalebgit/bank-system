package exceptions;
import util.*;

public class BankException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BankExceptionType type;
	
	public BankException(BankExceptionType type) {
		super();
		this.type = type;
	}
	
	@Override
	public String toString() {
		switch(type) {
			case PRODUCTNOTFOUND: 
				return type.getMessage();
			case PRODUCTTYPENOTDECLARED: 
				return type.getMessage();
			default: 
				return super.getMessage();
		}
	}
}
