package View;

import java.util.Scanner;
import Controller.AddContactController;

public class AddContactView {
	
	AddContactController addContact;
	private Scanner scanner = new Scanner(System.in);

	public AddContactView() {
		addContact = new AddContactController(this);
	}
	
	public void addContact() {
		while (true) {
			String contactNumber,name,mailId;
			boolean flag;
			do {
				System.out.println("Enter Contact Number(10 Digit Number)");
				contactNumber = scanner.nextLine();
				flag = addContact.contactNumberValidation(contactNumber);
				if(flag == false) {
					System.err.println("***Invalid Contact Number***");
				}
			} while(flag != true);

			do {
				System.out.println("Enter Name");
				name = scanner.nextLine();
				flag = addContact.nameValidation(name);
				if(flag == false) {
					System.err.println("***Invalid String***");
				}
			} while(flag != true);
			
			do {
				System.out.println("Enter Email");
				mailId = scanner.nextLine();
				flag = addContact.mailIdValidation(mailId);
				if(flag == false) {
					System.err.println("***Invalid Mail Id***");
				}
			} while(flag != true);
			addContact.addContactController(contactNumber,name,mailId);
			break;
		}
	}
}