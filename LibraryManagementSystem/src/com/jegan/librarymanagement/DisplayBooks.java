package LibrarayManagement;

import java.util.ArrayList;

public class DisplayBooks {
	public void displayBooks(ArrayList<Books> arrayList,int bookId) {
		System.out.println("---------------------------------------------------");
		for (int index = 0; index < arrayList.size(); index++) {
			Books book = arrayList.get(index);
			System.out.println("Book Id :" + book.bookId);
			System.out.println("Book Name :" + book.bookName);
			System.out.println("Price :" + book.price);
			System.out.println("*************************");
		}
		System.out.println("---------------------------------------------------");
	}
}
