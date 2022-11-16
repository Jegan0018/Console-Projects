package LibrarayManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReturnBook {
	static int fine = 0;
	public void returnBook(ArrayList<Books> arrayList,int bookId) {
		while(true) {
			System.out.println("----------------------------------------------");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Book Id");
			try {
				bookId = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Enter Proper Book Id");
				break;
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = new Date();
			for (int i = 0; i < arrayList.size(); i++) {
				Books list = (Books) arrayList.get(i);
				try {
					date1 = dateFormat.parse(list.returnDate);
				} catch (ParseException e) {}
				if (bookId == list.bookId && !(list.issueDate.equals(""))) {
					System.out.println("Book Id :" + list.bookId);
					System.out.println("Book Name :" + list.bookName);
					System.out.println("Issued Book Date :" +list.issueDate);
					System.out.println("Book Due Date :" + list.returnDate);
					System.out.println("**********************");
				}
			}
			System.out.println("----------------------------------------------");
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDateTime now = LocalDateTime.now();

			Date date2 = new Date();
			try {
				date2 = dateFormat.parse(dateFormatter.format(now));
			} catch (ParseException e) {}
			long differenceInTime = date2.getTime() - date1.getTime();
			long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInTime) % 365;
			if (differenceInDays <= 0) {
				for (int i = 0; i < arrayList.size(); i++) {
					Books list = arrayList.get(i);
					if (bookId == list.bookId && !(list.issueDate.equals(""))) {
						System.out.println("Book Returned Date :"+dateFormatter.format(now));
						System.out.println("Book has Returned Succesfully");
						list.status = true;
					}
				}
				
			} else {
				fine += 10 * differenceInDays;
				for (int i = 0; i < arrayList.size(); i++) {
					Books list =  arrayList.get(i);
					if (bookId == list.bookId && !(list.issueDate.equals(""))) {
						System.out.println("Book Returned Date :"+dateFormatter.format(now));
						System.out.println("Book has Returned Succesfully");
						list.status = true;
						System.out.println("Fine Amount for the User is " + fine);
					}
				}
			}
			break;
		}
	}
}
