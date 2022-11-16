package controller;

import model.Passengers;
import model.Routes;
import repository.Database;
import view.PassengerSearchView;

public class PassengerSearchController {
	private PassengerSearchView passengerSearchView;
	public PassengerSearchController(PassengerSearchView passengerSearchView) {
		this.passengerSearchView=passengerSearchView;
	}
	public void searchFlights(int passengerId) {
		int size=Database.getInstance().getPassengersList().size();
		for (int index = 0; index < size; index++) {
			Passengers passengers = Database.getInstance().getPassengersList().get(index);
			Routes routes = Database.getInstance().getRoutesList().get(index);
			if (passengerId == passengers.getPassengerId()) {
				passengerSearchView.displayData(passengers,routes);
			}
		}
	}
	
}
