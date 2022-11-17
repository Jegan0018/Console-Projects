package BankingManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import Database.DatabaseConnection;

public class TransactionAmount {
	public void amountTransact(String accountNumber) {
		Scanner scanner = new Scanner(System.in);
		String receiverAccountNumber;
		double transactAmount = 0, result, amount = 0, userAmount = 0, userResult;
		boolean flag;
		while (true) {
			do {
				System.out.println("Enter Receiver Account Number");
				receiverAccountNumber = scanner.nextLine();
				flag = receiverAccountNumberValidation(receiverAccountNumber);
				if (flag == false) {
					System.err.println("***Invalid Account Number***");
				}
			} while (flag == false);
			try {
				System.out.println("Enter the Amount to Deposit");
				transactAmount = scanner.nextDouble();
			} catch (Exception e) {
				System.out.println("***Invalid Number***");
			}

			try {
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String getSql = "select amount from bankingtable where accountNumber='" + receiverAccountNumber + "'";
				String getUserSql = "select amount from bankingtable where accountNumber='" + accountNumber + "'";
				PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(getSql);
				PreparedStatement userstatement = DatabaseConnection.getInstance().connection
						.prepareStatement(getUserSql);
				ResultSet resultSet = statement.executeQuery();
				ResultSet userResultSet = userstatement.executeQuery();
				if (resultSet.next()) {
					amount = resultSet.getDouble("amount");
				}
				if (userResultSet.next()) {
					userAmount = userResultSet.getDouble("amount");
				}
				result = amount + transactAmount;
				userResult = userAmount - transactAmount;
				if (result >= 1000) {
					String sql = "Update bankingtable set amount = ? where accountNumber='" + receiverAccountNumber
							+ "' ";
					String userSql = "Update bankingtable set amount = ? where accountNumber='" + accountNumber + "' ";
					PreparedStatement updateStatement = DatabaseConnection.getInstance().connection
							.prepareStatement(sql);
					PreparedStatement updateUserStatement = DatabaseConnection.getInstance().connection
							.prepareStatement(userSql);
					updateStatement.setDouble(1, result);
					updateUserStatement.setDouble(1, userResult);
					updateStatement.executeUpdate();
					updateUserStatement.executeUpdate();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			break;
		}
	}

	private boolean receiverAccountNumberValidation(String receiverAccountNumber) {
		Pattern receiverAccountNumberPattern = Pattern.compile("^12345\\d{5}$");
		if (receiverAccountNumberPattern.matcher(receiverAccountNumber).matches() == false) {
			return false;
		}
		return true;
	}
}
