package LibrarayManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddBooks {
	double price;
	static int bookId = 1000;

	public void addBooks(ArrayList<Books> arrayList, int bookId) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Book Name:");
			String bookName = scanner.nextLine();
			Pattern pattern = Pattern.compile("[a-zA-Z\\s,]+");
			if (!pattern.matcher(bookName).matches()) {
				System.out.println("Invalid String");
				break;
			}
			System.out.print("Enter Book Price:");
			try {
				price = scanner.nextDouble();
			} catch (Exception e) {
				System.out.println("Enter Valid Price");
			}
			System.out.print("The Entered Book Details are Book Name " + bookName + " Price: " + price);
			arrayList.add(new Books(bookName, price, bookId++, "", "", true));
			break;
		}
	}
}
