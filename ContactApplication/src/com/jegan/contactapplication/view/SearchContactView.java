package View;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import Controller.SearchContactController;
import Repository.DatabaseConnection;

public class SearchContactView {
	private SearchContactController searchContactController;
	SearchContactView() {
		searchContactController = new SearchContactController(this);
	}

	public void searchContact() {
		Scanner scanner = new Scanner(System.in);
		boolean flag;
		String name="";
		try {
			do {
				System.out.println("Enter Name");
				name = scanner.nextLine();
				flag = nameValidation(name);
				if (flag == false) {
					System.err.println("***Invalid String***");
				}
			} while (flag != true);
		} catch (Exception e) {
			System.err.println("***Please Enter Valid Number***");
			searchContact();
		}
		searchContactController.searchContact(name);
	}

	private boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}
}
