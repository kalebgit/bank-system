package dataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessObjects.Account;
import businessObjects.DebitCard;
import dataAccessObject.DAO;

public class DebitCardImplementation implements DAO<DebitCard, Long>, ConnectionSqlServer{
	public boolean insert(DebitCard element, Account owner) {
		Connection conn = getConnection();
		String query = "INSERT INTO DebitCard VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setBigDecimal(1, element.getCardNumber());
			p.setInt(2, element.getNip());
			p.setDouble(3, element.getMoney());
			p.setInt(4, element.isDefault() ? 1 : 0);
			p.setLong(5, owner.getProductID());
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(DebitCard element) {
		
		return false;
	}

	@Override
	public boolean delete(DebitCard element) {
		
		return false;
	}

	@Override
	public boolean insert(DebitCard element) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
