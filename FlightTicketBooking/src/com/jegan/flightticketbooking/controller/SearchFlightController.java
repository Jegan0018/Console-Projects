package controller;

import java.util.ArrayList;

import model.Routes;
import repository.Database;
import view.AdminSearchFlightView;

public class SearchFlightController {

	private AdminSearchFlightView searchFlightView;

	public SearchFlightController(AdminSearchFlightView searchFlightView) {
		this.searchFlightView=searchFlightView;
	}

	public void searchFlights(String source, String destination,String date) {
		int size=Database.getInstance().getRoutesList().size();
		for (int index = 0; index < size; index++) {
			Routes routes = Database.getInstance().getRoutesList().get(index);
			if (source.equals(routes.getSource())&& destination.equals(routes.getDestination())) {
				searchFlightView.displayDetails(routes);
			}
		}
	}
}
