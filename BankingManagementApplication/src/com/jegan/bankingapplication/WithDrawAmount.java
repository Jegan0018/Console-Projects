package BankingManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import Database.DatabaseConnection;

public class WithDrawAmount {
	public void amountWithDraw(String accountNumber) {
		Scanner scanner = new Scanner(System.in);
		double withdrawAmount = 0,result,amount = 0;
		boolean flag;
		while(true) {
			try {
				System.out.println("Enter the Amount to WithDraw");
				withdrawAmount = scanner.nextDouble();
			} catch(Exception e) {
				System.out.println(e);
			}
				
			try {
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String getSql = "select amount from bankingtable where accountNumber='"+accountNumber+"'";
				PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(getSql);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()) {
					amount = resultSet.getDouble("amount");
				}
				result = amount-withdrawAmount;
				if(result >=1000) {
					DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
					String sql="Update bankingtable set amount = ? where accountNumber='"+accountNumber+"' ";
					PreparedStatement updateStatement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
					updateStatement.setDouble(1, result);
					updateStatement.executeUpdate();
				} else {
					System.err.println("***Insufficient Amount***");
				}
				
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			break;
		}
	}
}
