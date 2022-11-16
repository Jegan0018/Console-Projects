package View;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Controller.ListContactController;
import Repository.DatabaseConnection;
import model.ContactFields;

public class ListContactView {
	private ListContactController listContactController;
	ListContactView() {
		listContactController=new ListContactController(this);
	}
	public void listContacts() {
		try {
			listContactController.listContact();
			for(int index=0;index<DatabaseConnection.getInstance().getArrayList().size();index++) {
				ContactFields object=DatabaseConnection.getInstance().getArrayList().get(index);
				System.out.println("Contact Name :" + object.getName());
				System.out.println("Contact Number:" + object.getContactNumber());
				System.out.println("Mail Id :" + object.getMailId());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}