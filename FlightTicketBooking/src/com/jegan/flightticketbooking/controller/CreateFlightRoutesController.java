package controller;

import model.Routes;
import repository.Database;
import view.AdminCreateFlightRoutes;

public class CreateFlightRoutesController {

	private AdminCreateFlightRoutes createRoutes;

	public CreateFlightRoutesController(AdminCreateFlightRoutes createRoutes) {
		this.createRoutes=createRoutes;
	}

	public void createFlightRoutesController(int flightNumber, double price, String flightName, String departureTime,
			String arrivalTime, int seats, String source, String destination) {
		Database.getInstance().setRoutesList(new Routes(flightNumber, price, flightName, departureTime, arrivalTime, seats,source,destination));
	}
}
