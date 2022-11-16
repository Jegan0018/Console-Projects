package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Routes;

public class AdminView {
	
	private Scanner scanner = new Scanner(System.in);
	public void adminDisplay() {
		int input;
		try {
			do {
				menu();
				input = scanner.nextInt();
				switch(input) {
				case 1:
					new AdminCreateFlightRoutes().createRoutes();
					break;
				case 2:
					new AdminSearchFlightView().searchFlight();
					break;
				case 3:
					new AdminListRoutes().listRoutes();
					break;
				case 4:
					new PassengerSearchView().searchPassenger();
					break;
				case 5:
					new FlightMainView().displayDetails();
					break;
				default :
					System.out.println("Invalid Number");
				}
			} while (input != 5);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	private void menu() {
		System.out.println("Press 1 to CreateFlightRoutes");
		System.out.println("Press 2 to SearchFlights");
		System.out.println("Press 3 to ListTicketsBooked");
		System.out.println("Press 4 to SearchPassengerById");
		System.out.println("Press 5 to Exit");
	}

}
