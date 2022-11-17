package BankingManagement;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mysql.jdbc.ResultSet;

import Database.DatabaseConnection;

public class BankingLogin {
	public void accountLogin() {
		String accountNumber,pin;
		int input = 0;
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			do {
				System.out.println("Enter Account Number");
				accountNumber = scanner.nextLine();
				flag = accountNumberValidation(accountNumber);
				if(flag == false) {
					System.err.println("***Invalid Account Number***");
				}
			} while(flag == false);
			do {
				System.out.println("Enter Pin(4 Digits)");
				pin = scanner.nextLine();
				flag = pinValidation(pin);
				if(flag == false) {
					System.err.println("***Invalid Pin***");
				}
			} while(flag == false);
			try {
				DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
				String loginSql = "select accountNumber,pin from bankingtable where accountNumber = '"+accountNumber+"' AND pin = '"+pin+"'";
				PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(loginSql);
				java.sql.ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()) {
					System.out.println("Succesfully Logged In");
					do {
						loginMenu();
						try {
							input = scanner.nextInt();
							switch(input) {
							case 1:
								new CheckBankBalance().bankBalance(accountNumber);
								break;
							case 2:
								new WithDrawAmount().amountWithDraw(accountNumber);
								break;
							case 3:
								new DepositAmount().amountDeposit(accountNumber);
								break;
							case 4:
								new TransactionAmount().amountTransact(accountNumber);
								break;
							case 5:
								System.out.println("Logged Out Successfully...");
								break;
							default:
								System.err.println("***Invalid Number***");
							}
						} catch(Exception exception) {
							System.err.println("***Invalid Option***");
						}	
					} while(input != 5);
				}
				else {
					System.err.println("***Account Number and Pin does not Matches***");
				}
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			break;
		}
	}
	private void loginMenu() {
		System.out.println("Press 1 to Check Bank Balance");
		System.out.println("Press 2 to Deposit Amount");
		System.out.println("Press 3 to WithDraw Amount");
		System.out.println("Press 4 to Amount Transaction");
		System.out.println("Press 5 to Logout");
		System.out.println("Please Enter Any One of The Options");
	}
	private boolean pinValidation(String pin) {
		Pattern pinPattern = Pattern.compile("^\\d{4}$");
		if(pinPattern.matcher(pin).matches() == false) {
			return false;
		}
		return true;
	}
	private boolean accountNumberValidation(String accountNumber) {
		Pattern accountNumberPattern = Pattern.compile("^12345\\d{5}$");
		if(accountNumberPattern.matcher(accountNumber).matches() == false) {
			return false;
		}
		return true;
	}
}
