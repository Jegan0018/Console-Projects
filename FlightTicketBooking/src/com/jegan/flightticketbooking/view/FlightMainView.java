package view;

import java.util.Scanner;

public class FlightMainView {
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		FlightMainView mainView = new FlightMainView();
		mainView.displayDetails();
	}

	public void displayDetails() {
		int input;
		try {
			do {
				menu();
				input = scanner.nextInt();
				switch (input) {
				case 1:
					new AdminLogin().adminLogin();
					break;
				case 2:
					new PassengerBookTickets().bookTickets();
					break;
				default:
					System.err.println("Invalid Number");
				}

			} while (input != 2);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void menu() {
		System.out.println("Welcome to Indian Airways");
		System.out.println("Press 1 if you are Admin");
		System.out.println("Press 2 if you are Passenger");
		System.out.println("Press 3 to Exit Application");
	}
}
