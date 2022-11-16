package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Repository.DatabaseConnection;
import View.ListContactView;
import model.ContactFields;

public class ListContactController {
	private ListContactView listContactView;
	public ListContactController(ListContactView listContactView) {
		this.listContactView=listContactView;
	}

	public void listContact() {
		try {
			DatabaseConnection.getInstance().connection = DatabaseConnection.getConnection();
			String sql = "SELECT id,name,contactNumber,mailId FROM contactstable Order By name Asc";
			PreparedStatement statement = DatabaseConnection.getInstance().connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if (DatabaseConnection.getInstance().getArrayList().size() == 0) {
				while (resultset.next()) {
					DatabaseConnection.getInstance().setArrayList((new ContactFields(resultset.getString("contactNumber"),resultset.getString("name"),resultset.getString("mailId"))));
				}
			} else {
				DatabaseConnection.getInstance().getArrayList().removeAll(DatabaseConnection.getInstance().getArrayList());
				while (resultset.next()) {
					DatabaseConnection.getInstance().setArrayList(new ContactFields(resultset.getString("contactNumber"),resultset.getString("name"),resultset.getString("mailId")));
				}
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
	}
}
