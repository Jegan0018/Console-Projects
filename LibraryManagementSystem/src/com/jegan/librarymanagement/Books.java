package LibrarayManagement;

public class Books {
	 int bookId;
	 double price;
	 String bookName;
	 String issueDate;
	 String returnDate;
	 boolean status;
	public Books(String bookName, double price, int bookId,String issueDate,String returnDate,boolean status) {
		this.bookName = bookName;
		this.price = price;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public void displayBooksInfo() {
		System.out.println("["+"bookId= " + bookId + ", price= " + price + ", bookName= " + bookName + "]");
	}
		
}
