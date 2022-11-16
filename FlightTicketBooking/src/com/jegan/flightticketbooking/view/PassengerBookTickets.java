package view;

import java.util.Scanner;

public class PassengerBookTickets {
	private Scanner scanner = new Scanner(System.in);

	public void bookTickets() {
		int input;
		do {
			menu();
			input = scanner.nextInt();
			try {
				switch (input) {
				case 1:
					new PassengerTicketBook().ticketBook();
					break;
				case 2:
					new PassengerCancelTickets().cancelTicket();
					break;
				case 3:
					new FlightMainView().displayDetails();
					break;
				default:
					System.out.println("Invalid Number");
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		} while (input != 3);

	}

	private void menu() {
		System.out.println("To Book Tickets Enter 1");
		System.out.println("To Cancel Tickets Enter 2");
		System.out.println("Enter 3 to Exit");
	}
}

class CancelTicket {

}
