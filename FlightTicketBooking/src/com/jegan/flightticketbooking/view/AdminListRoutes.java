package view;

import java.util.ArrayList;
import model.Routes;
import repository.Database;

public class AdminListRoutes {
	public void listRoutes() {
		int size=Database.getInstance().getRoutesList().size();
		for (int index = 0; index < size; index++) {
			Routes routes = Database.getInstance().getRoutesList().get(index);
			System.out.println("******************");
			System.out.println("\tFlight Number :" + routes.getFlightNumber());
			System.out.println("\tPrice :" + routes.getPrice());
			System.out.println("\tFlight Name :" + routes.getFlightName());
			System.out.println("\tDeparture Time :" + routes.getDepartureTime());
			System.out.println("\tArrival Time :" + routes.getArrivalTime());
			System.out.println("\tseats :" + routes.getSeats());
			System.out.println("Source :" + routes.getSource());
			System.out.println("Destination :" + routes.getDestination());
			System.out.println("******************");
		}
	}
}

