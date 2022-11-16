package Controller;

import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import Repository.DatabaseConnection;
import View.AddContactView;
import View.EditContactView;
import model.ContactFields;

public class EditContactController {
	private EditContactView editContactView;
	public EditContactController(EditContactView editContactView) {
		this.editContactView=editContactView;
	}
	
	public void editContactController(String name, String contactNumber, String mailId) {
		DatabaseConnection.getInstance().setArrayList(new ContactFields(contactNumber,name,mailId));
		try {
			DatabaseConnection.connection = DatabaseConnection.getConnection();
			String sql = "Update contactstable set contactNumber=?,name=?,mailId=? where name='" + name + "' ";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			statement.setString(1, contactNumber);
			statement.setString(2, name);
			statement.setString(3, mailId);
			statement.executeUpdate();
		} catch (Exception e1) {
			System.out.println("Entered Name is Not Found");
			System.out.println(e1);
		}
	}
	
	public boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}

	public boolean contactNumberValidation(String contactNumber) {
		Pattern contactPattern = Pattern.compile("^\\d{10}$");
		if (!contactPattern.matcher(contactNumber).matches()) {
			return false;
		}
		return true;
	}

	public boolean mailIdValidation(String mailId) {
		Pattern mailIdPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		if (!mailIdPattern.matcher(mailId).matches()) {
			return false;
		}
		return true;
	}
}
