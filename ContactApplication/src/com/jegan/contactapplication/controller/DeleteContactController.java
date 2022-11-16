package Controller;

import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import Repository.DatabaseConnection;
import View.DeleteContactView;

public class DeleteContactController {
	private DeleteContactView deleteContactView;
	public DeleteContactController(DeleteContactView deleteContactView) {
		this.deleteContactView=deleteContactView;
	}
	
	public void deleteContactController(String name) {
		try {
			DatabaseConnection.connection = DatabaseConnection.getConnection();
			String sql = "delete from contactstable where name = '"+name+"'";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println("Deleted Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean nameValidation(String name) {
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s,]+");
		if(!namePattern.matcher(name).matches()) {
			return false;
		}
		return true;
	}

}
