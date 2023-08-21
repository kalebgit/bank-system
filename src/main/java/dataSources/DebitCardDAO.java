package dataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessObjects.Account;
import businessObjects.DebitCard;
import dataAccessObject.DAO;
import exceptions.BankException;
import util.BankExceptionType;

public class DebitCardDAO implements DAO<DebitCard, Long>{
	
	private Connection conn;
	
	public DebitCardDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean insert(DebitCard element, Account owner) {
		
		String query = "INSERT INTO DebitCard(Number, NIP, Funds, IsDefault, AccountID) "
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setBigDecimal(1, element.getCardNumber());
			p.setInt(2, element.getNip());
			p.setDouble(3, element.getMoney());
			p.setInt(4, element.isDefault() ? 1 : 0);
			p.setLong(5, owner.getProductID());
			p.execute();
			p.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean update(DebitCard element) {
		
		String query = "UPDATE DebitCard SET Number=?, NIP=?, Funds=?, IsDefault=? "
				+ "WHERE DebitCardID=? AND Number=? AND NIP=?";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setBigDecimal(1, element.getCardNumber());
			p.setInt(2, element.getNip());
			p.setDouble(3, element.getMoney());
			p.setInt(4, element.isDefault() ? 1 : 0);
			p.setLong(5, element.getProductID());
			p.setBigDecimal(6, element.getCardNumber());
			p.setInt(7, element.getNip());
			p.execute();
			p.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean delete(DebitCard element) {
		
		String query = "DELETE FROM DebitCard WHERE DebitCardID=? AND Number=? AND NIP=? ";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setLong(1, element.getProductID());
			p.setBigDecimal(2, element.getCardNumber());
			p.setInt(3, element.getNip());
			p.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(DebitCard element) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	public DebitCard getSingle(Long key) {
		throw new UnsupportedOperationException();
	}
	
	public List<DebitCard> getOwnerDebitCards(Account account)throws BankException{
		String query = "SELECT DebitCardID, Number, NIP, DebitCard.Funds, IsDefault FROM "
				+ "DebitCard "
				+ "INNER JOIN "
				+ "Account "
				+ " ON DebitCard.AccountID = Account.AccountID "
				+ " WHERE Account.BankCode=?";
		
		List<DebitCard> debitCards = new ArrayList<DebitCard>();
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setBigDecimal(1, account.getBankCode());
			ResultSet set = p.executeQuery();
			while(set.next()) {
				debitCards.add(new DebitCard(set.getLong("DebitCardID"), set.getBigDecimal("Number"), 
						set.getInt("NIP"), set.getDouble("Funds"), set.getInt("IsDefault") == 1 ? 
								true : false));
			}
			p.close();
			if(debitCards.size() > 0) {
				return debitCards; 
			}else {
				throw new BankException(BankExceptionType.CARDNOTFOUND, "ninguna tarjeta fue encontrada");
			}
		}catch(Exception e) {
			throw new BankException(BankExceptionType.CARDNOTFOUND, e, "ninguna tarjeta fue encontrada");
		}
	}
}
