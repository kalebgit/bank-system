package dataSources;
import businessObjects.*;
import dataAccessObject.DAO;
import exceptions.BankException;
import util.BankExceptionType;
public class TransactionDAO implements DAO<Transaction, Long> {

	@Override
	public boolean insert(Transaction element) {
		public boolean transferTo(Account receiver, double amount) throws BankException{
			try {
				if(this.hasFunds(amount)) {
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

	@Override
	public boolean update(Transaction element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Transaction element) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
