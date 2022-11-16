package LibrarayManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IssueBook {
	public void issueBook(ArrayList<Books> arrayList,int bookId) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Book Id");
			try {
				bookId = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Enter Proper Book Id");
				break;
			}
			
			for (int index = 0; index < arrayList.size(); index++) {
				Books b = arrayList.get(index);
				if (bookId == b.bookId && b.status == true) {
					String bookName = scanner.nextLine();
					System.out.println("Issue Date(dd-mm-yyyy)");
					String issueDate = scanner.nextLine();
					Pattern issueDatePattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
					if (!issueDatePattern.matcher(issueDate).matches()) {
						System.out.println("Invalid Date Format");
						break;
					}
					System.out.println("Return Book Date(dd-mm-yyyy)");
					String returnDate = scanner.nextLine();
					Pattern returnDatePattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
					if (!returnDatePattern.matcher(issueDate).matches()) {
						System.out.println("Invalid Date Format");
						break;
					}
					b.issueDate=issueDate;
					b.returnDate=returnDate;
					b.status=false;
					break;
				} else if(bookId == b.bookId && b.status == false) {
					System.out.println("The Given Book is not Available in this Library");
				}
			}
			break;
		}
	}
}
