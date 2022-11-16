package View;

import java.util.Scanner;


public class ContactMainView {
	public static void main(String[] args) {
		ContactMainView contact = new ContactMainView();
		contact.displayInfo();
	}

	private void menu() {
		System.out.println("------------Contact Application------------");
		System.out.println("Press 1 to Add a New Contact");
		System.out.println("Press 2 to List all Contacts");
		System.out.println("Press 3 to Edit a Contact");
		System.out.println("Press 4 to Delete a Contact");
		System.out.println("Press 5 to Search a Contact");
		System.out.println("Press 6 to Exit");
	}

	public void displayInfo() {
		Scanner scanner = new Scanner(System.in);
		int input;
		try {
			do {
				menu();
				System.out.println("Please Select One Option : ");
				input = scanner.nextInt();
				switch (input) {
				case 1:
					new AddContactView().addContact();
					break;
				case 2:
					new ListContactView().listContacts();
					break;
				case 3:
					new EditContactView().editContact();
					break;
				case 4:
					new DeleteContactView().deleteContact();
					break;
				case 5:
					new SearchContactView().searchContact();
					break;
				case 6:
					System.out.println("Exitted Successfully...");
					break;
				default:
					System.err.println("***Please Enter Valid Number***");
				}
			} while (input != 6);
		} catch (Exception e) {
			System.err.println("***Please Enter Valid Number***");
			displayInfo();
		}
	}
}
