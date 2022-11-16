package view;

import java.util.Scanner;

import controller.CreateFlightRoutesController;

public class AdminCreateFlightRoutes {
	CreateFlightRoutesController createRoutes;
	private Scanner scanner = new Scanner(System.in);

	public AdminCreateFlightRoutes() {
		createRoutes = new CreateFlightRoutesController(this);
	}

	public void createRoutes() {
		int flightNumber, seats;
		double price;
		String source, destination, arrivalTime, departureTime, flightName;
		System.out.println("Enter Flight Number");
		flightNumber = scanner.nextInt();
		System.out.println("Enter Price");
		scanner.nextLine();
		price = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter Flight Name");
		flightName = scanner.nextLine();
		System.out.println("Enter Departure Time");
		departureTime = scanner.nextLine();
		System.out.println("Enter Arrival Time");
		arrivalTime = scanner.nextLine();
		System.out.println("Enter Seats");
		seats = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Source");
		source = scanner.nextLine();
		System.out.println("Enter Destination");
		destination = scanner.nextLine();
		createRoutes.createFlightRoutesController(flightNumber, price, flightName, departureTime, arrivalTime, seats,
				source, destination);
	}
}
