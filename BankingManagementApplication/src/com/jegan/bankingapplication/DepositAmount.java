package BankingManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Database.DatabaseConnection;

public class DepositAmount {
	public void amountDeposit(String accountNumber) {
		Scanner scanner = new Scanner(System.in);
		double depositAmount = 0, result, amount = 0;
		boolean flag;
		while (true) {
			try {
				System.out.println("Enter the Amount to Deposit");
				depositAmount = scanner.nextDouble();
			} catch (Exception e) {
				System.out.println("***Invalid Number***");
			}

			try {
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String getSql = "select amount from bankingtable where accountNumber='" + accountNumber + "'";
				PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(getSql);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					amount = resultSet.getDouble("amount");
				}
				result = amount + depositAmount;
				if (result >= 1000) {
					DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
					String sql = "Update bankingtable set amount = ? where accountNumber='" + accountNumber + "' ";
					PreparedStatement updateStatement = DatabaseConnection.getInstance().connection
							.prepareStatement(sql);
					updateStatement.setDouble(1, result);
					updateStatement.executeUpdate();
				}

			} catch (Exception exception) {
				exception.printStackTrace();
			}
			break;
		}
	}
}
