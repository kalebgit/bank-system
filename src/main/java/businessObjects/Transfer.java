package businessObjects;
import java.time.*;

import exceptions.BankException;
import util.BankExceptionType;
public class Transfer {
	
	private Long transferID;
	private Account originAccount;
	private DebitCard originDebitCard;
	private Account receiverAccount;
	private DebitCard receiverDebitCard;
	private double amount;
	private OffsetDateTime date;
	
	
	public Transfer(Long transferID, Account originAccount, Account receiverAccount, double amount, OffsetDateTime date) {
		this.transferID = transferID;
		this.originAccount = originAccount;
		this.receiverAccount = receiverAccount;
		this.amount = amount;
		this.date = date;
	}
}
