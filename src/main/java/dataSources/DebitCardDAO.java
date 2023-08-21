package dataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessObjects.Account;
import businessObjects.DebitCard;
import dataAccessObject.DAO;

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
}
