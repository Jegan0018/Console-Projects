package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.SearchFlightController;
import model.Routes;

public class AdminSearchFlightView {
	private Scanner scanner=new Scanner(System.in);
	private SearchFlightController searchFlight;
	AdminSearchFlightView() {
		searchFlight=new SearchFlightController(this);
	}

	public void searchFlight() {
		String source,destination,date;
		System.out.println("Enter Source");
		source=scanner.nextLine();
		System.out.println("Enter Destination");
		destination=scanner.nextLine();
		System.out.println("Enter Date");
		date=scanner.nextLine();
		searchFlight.searchFlights(source,destination,date);
	}

	public void displayDetails(Routes routes) {
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
