package dataSources;
import businessObjects.*;
import dataAccessObject.DAO;
public class TransferDAO implements DAO<Transfer, Long>{

	@Override
	public boolean insert(Transfer element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Transfer element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Transfer element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transfer getSingle(Long key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//TransferID, OriginAccountID, OriginDebitCardID, ReceiverAccountID, ReceiverDebitCardID, 
	//Amount, TransactionDate
	
	//String query = "INSERT INTO Transfer VALUES (?, ?, ?, ?, ?, ?)";
	public boolean generateTransaction(Transfer element) {
		
	}

}
