package businessObjects;
import java.time.*;

import exceptions.BankException;
import util.BankExceptionType;
public class Transfer {
	
	private Long TransferID;
	private Account OriginAccount;
	private DebitCard OriginDebitCard;
	private Account ReceiverAccount;
	private DebitCard ReceiverDebitCard;
	private double amount;
	private OffsetDateTime date;
	
	
	public Transfer(Account originAccount, Account receiverAccount) {
		this.OriginAccount = originAccount;
		this.ReceiverAccount = receiverAccount;
		
		try {
			if(origin.hasFunds(amount)) {
				try {
					if(this.withdrawMoney(this.getDefaultDebitCard().getCardNumber(), amount)) {
						receiver.addMoney(amount);
					}
				}catch(BankException e) {
					throw new BankException(BankExceptionType.TRANSACTIONFAILED, e);
				}
			}
		}catch(BankException e) {
			throw new BankException(BankExceptionType.TRANSACTIONFAILED, e);
		}
		return true;
	}
}
