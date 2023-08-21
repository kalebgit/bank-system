package dataSources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import businessObjects.Account;
import dataAccessObject.DAO;

public class AccountDAO implements DAO<Account, Long>{
	
	private Connection conn;
	
	public AccountDAO(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean insert(Account element) {
		String query = "INSERT INTO Account(BankCode, Username, Password, Funds) VALUES "
				+ " (?, ?, ?, ?)";
		PreparedStatement p;
		try {
			p = conn.prepareStatement(query);
			p.setBigDecimal(1,element.getBankCode());
			p.setString(2, element.getUserName());
			p.setString(3, element.getPassword());
			p.setDouble(4, element.getMoney());
			p.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Account element) {
		String query = "UPDATE Account SET BankCode=?, Username=?, password=?, funds=? "
				+ "WHERE AccountID=? AND BankCode=? AND Username=?";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setBigDecimal(1, element.getBankCode());
			p.setString(2, element.getUserName());
			p.setString(3, element.getPassword());
			p.setDouble(4, element.getMoney());
			p.setLong(5, element.getProductID());
			p.setBigDecimal(6, element.getBankCode());
			p.setString(7, element.getUserName());
			p.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Account element) {
		String query = "DELETE FROM Account WHERE AccountID=? AND BankCode=? AND Username=? ";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setLong(1, element.getProductID());
			p.setBigDecimal(2, element.getBankCode());
			p.setString(3, element.getUserName());
			p.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
