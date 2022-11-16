package Controller;

import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import Repository.DatabaseConnection;
import View.AddContactView;
import model.ContactFields;


public class AddContactController {
	private AddContactView contactView;
	public AddContactController(AddContactView contactView) {
		this.contactView=contactView;
	}

	public void addContactController(String contactNumber, String name, String mailId) {
		DatabaseConnection.getInstance().setArrayList(new ContactFields(contactNumber,name,mailId));
		try {
			DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
			String sql = "insert into contactstable(contactNumber,name,mailId)values(?,?,?)";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			statement.setString(1, contactNumber);
			statement.setString(2, name);
			statement.setString(3, mailId);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean contactNumberValidation(String contactNumber) {
		Pattern contactPattern = Pattern.compile("^\\d{10}$");
		if (!contactPattern.matcher(contactNumber).matches()) {
			return false;
		}
		return true;
	}

	public boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if (!namePattern.matcher(name).matches()) {
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
