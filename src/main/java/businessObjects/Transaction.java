package businessObjects;

public class Transaction {
	
	private Account OriginAccount;
	private DebitCard OriginDebitCard;
	private Account ReceiverAccount;
	private DebitCard ReceiverDebitCard;
	
	public Transaction(Account originAccount, Account receiverAccount) {
		this.OriginAccount = originAccount;
		this.ReceiverAccount = receiverAccount;
	}
	
	public Transaction(DebitCard originDebitCard, DebitCard receiverDebitCard) {
		this.OriginDebitCard = originDebitCard;
		this.ReceiverDebitCard = receiverDebitCard;
	}
	
}
