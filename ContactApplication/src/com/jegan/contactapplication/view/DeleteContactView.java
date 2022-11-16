package View;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Pattern;

import Controller.DeleteContactController;
import Repository.DatabaseConnection;

public class DeleteContactView {
	public void deleteContact() {
		delete();
	}
	private DeleteContactController deleteContactController;
	DeleteContactView() {
		deleteContactController=new DeleteContactController(this);
	}
	private void delete() {
		Scanner scanner = new Scanner(System.in);
		String name;
		boolean flag;
		do {
			System.out.println("Enter Existing Name");
			name = scanner.nextLine();
			flag = deleteContactController.nameValidation(name);
			if(flag == false) {
				System.err.println("***Invalid String***");
			}
		} while(flag != true);
		deleteContactController.deleteContactController(name);
	}
}