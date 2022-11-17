package BankingManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import Database.DatabaseConnection;

public class CreateAccount {
	public void signup() {
		while (true) {
			String name, accountNumber, contactNumber, dateOfBirth,pin;
			Scanner scanner = new Scanner(System.in);
			boolean flag;
			do {
				System.out.println("Enter User Name");
				name = scanner.nextLine();
				flag = nameValidation(name);
				if (flag == false) {
					System.err.println("***Invalid Name***");
				}
			} while (flag != true);
			do {
				System.out.println("Enter Contact Number");
				contactNumber = scanner.nextLine();
				flag = contactNumberValidation(contactNumber);
				if (flag == false) {
					System.err.println("***Invalid Contact Number***");
				}
			} while (flag != true);
			do {
				System.out.println("Enter Date of Birth");
				dateOfBirth = scanner.nextLine();
				flag = dateOfBirthValidation(dateOfBirth);
				if (flag == false) {
					System.err.println("***Invalid Date Of Birth***");
				}
			} while (flag == false);
			do {
				System.out.println("Enter New Pin(4 Digits Only)");
				pin = scanner.nextLine();
				flag = pinValidation(pin);
				if(flag == false) {
					System.err.println("***Enter Valid Pin***");
				}
			} while(flag == false);
			try {
				int id = 0;
				String label = "12345";
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String sql = "SELECT * FROM bankingtable ORDER BY id DESC Limit 1";
				PreparedStatement select = DatabaseConnection.getInstance().connection.prepareStatement(sql);
				ResultSet set = select.executeQuery();
				if (set.next()) {
					id = set.getInt("id") + 1;
				}
				accountNumber = String.format(label + "%05d", id);
				double amount = 1000;
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String insertSql = "insert into bankingtable(name,accountNumber,contactNumber,dateOfBirth,pin,amount) values(?,?,?,?,?,?)";
				PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(insertSql);
				statement.setString(1, name);
				statement.setString(2, accountNumber);
				statement.setString(3, contactNumber);
				statement.setString(4, dateOfBirth);
				statement.setString(5, pin);
				statement.setDouble(6, amount);
				statement.executeUpdate();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			break;
		}
	}

	private boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("^[a-zA-z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}

	private boolean contactNumberValidation(String contactNumber) {
		Pattern contactNumberPattern = Pattern.compile("^\\d{10}$");
		if (contactNumberPattern.matcher(contactNumber).matches() == false) {
			return false;
		}
		return true;
	}

	private boolean dateOfBirthValidation(String dateOfBirth) {
		Pattern dateOfBirthPattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
		if (dateOfBirthPattern.matcher(dateOfBirth).matches() == false) {
			return false;
		}
		return true;
	}
	private boolean pinValidation(String pin) {
		Pattern pinPattern = Pattern.compile("^\\d{4}$");
		if(pinPattern.matcher(pin).matches() == false) {
			return false;
		}
		return true;
	}
}
