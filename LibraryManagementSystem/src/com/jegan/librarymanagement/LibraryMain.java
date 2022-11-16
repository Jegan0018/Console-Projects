package LibrarayManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {
	static int bookId = 1000, fine = 0;
	double price;
	static boolean status = true;
	static ArrayList<Books> arrayList = new ArrayList<Books>();

	public static void main(String[] args) {
		arrayList.add(new Books("DBMS", 500.0, bookId++, "", "", true));
		arrayList.add(new Books("Java", 650.0, bookId++, "", "", true));
		arrayList.add(new Books("C++", 300.0, bookId++, "", "", true));
		for (Books b : arrayList) {
			b.displayBooksInfo();
		}
		LibraryMain main = new LibraryMain();
		main.displayScreen();
	}

	public void menu() {
		System.out.println("\tLibrary Management System");
		System.out.println("Press 1 to Add a Book");
		System.out.println("Press 2 to Display the Book Details");
		System.out.println("Press 3 to Issue a Book");
		System.out.println("Press 4 to Display the Issued Book Details");
		System.out.println("Press 5 to Return a Book");
		System.out.println("Press 6 to Exit");
	}

	private void displayScreen() {
		Scanner scanner = new Scanner(System.in);
		int input;
		try {
			do {
				menu();
				System.out.println("Please Enter Any Of The  Option");
				input = scanner.nextInt();
				switch (input) {
				case 1:
					new AddBooks().addBooks(arrayList, bookId);
					break;

				case 2:
					new DisplayBooks().displayBooks(arrayList, bookId);
					break;

				case 3:
					new IssueBook().issueBook(arrayList, bookId);
					break;

				case 4:
					new DisplayIssueBooks().displayIssueBooks(arrayList, bookId);
					break;

				case 5:
					new ReturnBook().returnBook(arrayList, bookId);
					break;
				case 6:
					System.out.println("Exitted Successfully");
					break;
				default:
					System.out.println("Invalid Number... PLEASE Enter Valid Number");
				}
			} while (input != 6);
		} catch (Exception e) {
			System.out.println("Please Enter Valid Number");
			displayScreen();
		}

	}
}
