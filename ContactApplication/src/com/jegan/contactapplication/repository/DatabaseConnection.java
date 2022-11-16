package Repository;

import java.sql.Connection;
import java.util.ArrayList;

import model.ContactFields;

public class DatabaseConnection {
	private static DatabaseConnection databaseConnection;
	public static Connection connection;
	private ArrayList<ContactFields> arrayList;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3307/zohoassignment", "root", "");
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return connection;
	}

	private DatabaseConnection() {
		arrayList = new ArrayList<ContactFields>();
	}

	public static DatabaseConnection getInstance() {
		if (databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection;
	}

	public ArrayList<ContactFields> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ContactFields contactFields) {
		this.arrayList.add(contactFields);
	}

}
