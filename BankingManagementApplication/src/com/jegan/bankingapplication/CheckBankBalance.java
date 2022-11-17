package BankingManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.DatabaseConnection;

public class CheckBankBalance {
	public void bankBalance(String accountNumber) {
		while(true) {
			try {
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String sql = "select accountNumber,name,amount from bankingtable where accountNumber='"+accountNumber+"' ";
				PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()) {
					System.out.println("Account Number :"+resultSet.getString("accountNumber"));
					System.out.println("Name :"+resultSet.getString("name"));
					System.out.println("Balance :"+resultSet.getString("amount"));
				}
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			break;
		}
		
	}
}
