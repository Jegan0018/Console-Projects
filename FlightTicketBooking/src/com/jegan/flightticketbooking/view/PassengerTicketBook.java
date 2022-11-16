package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Routes;
import repository.Database;

public class PassengerTicketBook {
	private Scanner scanner = new Scanner(System.in);
	public void ticketBook() {
		String source, destination;
		System.out.println("Enter From Station");
		source = scanner.nextLine();
		System.out.println("Enter To Station");
		destination = scanner.nextLine();
		int size=Database.getInstance().getRoutesList().size();
		for (int index = 0; index < size; index++) {
			Routes routes=Database.getInstance().getRoutesList().get(index);
			if (source.equals(routes.getSource()) && destination.equals(routes.getDestination())) {
				System.out.println("Available Flights : ");
				System.out.println("Flight Number :" + routes.getFlightNumber());
				System.out.println("Price :" + routes.getPrice());
				System.out.println("Flight Name :" + routes.getFlightName());
				System.out.println("Departure Time :" + routes.getDepartureTime());
				System.out.println("Arrival Time :" + routes.getArrivalTime());
				System.out.println("seats :" + routes.getSeats());
				System.out.println("Source :" + routes.getSource());
				System.out.println("Destination :" + routes.getDestination());
				System.out.println("******************");
			}
		}
		System.out.println("Enter Flight Number to Book Tickets");
		int flightNumber,numberOfPassengers;
		flightNumber=scanner.nextInt();
		System.out.println("Enter Number of Passengers");
		numberOfPassengers=scanner.nextInt();
		new PassengerDetailsView().passengerDetailsView(flightNumber,numberOfPassengers);
	}
}
