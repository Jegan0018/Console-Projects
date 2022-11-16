package View;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Controller.AddContactController;
import Controller.EditContactController;
import Repository.DatabaseConnection;
import model.ContactFields;

public class EditContactView {
	EditContactController editContactController;
	private Scanner scanner = new Scanner(System.in);

	public EditContactView() {
		editContactController = new EditContactController(this);
	}
	public void editContact() {
		String name,contactNumber,mailId;
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter Existing Name");
			name = scanner.nextLine();
			flag = editContactController.nameValidation(name);
			if(flag == false) {
				System.err.println("***Invalid String***");
			}
		} while(flag != true);

		do {
			System.out.println("Enter Contact Number(10 Digit Number)");
			contactNumber = scanner.nextLine();
			flag = editContactController.contactNumberValidation(contactNumber);
			if(flag == false) {
				System.err.println("***Invalid Contact Number***");
			}
		} while(flag != true);

		do {
			System.out.println("Enter Email");
			mailId = scanner.nextLine();
			flag = editContactController.mailIdValidation(mailId);
			if(flag == false) {
				System.err.println("***Invalid Mail Id***");
			}
		} while(flag != true);
		editContactController.editContactController(name,contactNumber,mailId);
	}
	
}
