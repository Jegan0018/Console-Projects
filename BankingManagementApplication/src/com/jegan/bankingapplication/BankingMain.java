package BankingManagement;

import java.util.Scanner;

public class BankingMain {
	public static void main(String[] args) {
		BankingMain main = new BankingMain();
		main.displayInfo();
	}

	private void displayInfo() {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		do {
			menu();
			try {
				input = scanner.nextInt();
				switch(input) {
				case 1:
					new CreateAccount().signup();
					break;
				case 2:
					new BankingLogin().accountLogin();
					break;
				case 3:
					System.out.println("Exitted Successfully...");
					break;
				default:
					System.out.println("***Invalid Number***");
				}
			} catch(Exception e) {
				System.out.println("***Please Enter Valid Number");
				displayInfo();
			}

		} while(input != 3);
	}

	private void menu() {
		System.out.println("Are you New User");
		System.out.println("Press 1 to Create Account");
		System.out.println("Already Have an Account?");
		System.out.println("Press 2 to Login");
		System.out.println("Press 3 to Exit");
		System.out.println("Please Enter Any One of the Option"); 
	}
}
