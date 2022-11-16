package controller;

import java.util.ArrayList;
import model.Passengers;
import model.Routes;
import repository.Database;
import view.PassengerDetailsView;

public class PassengerBookingController {
	private PassengerDetailsView passengerDetailsView;
	public PassengerBookingController(PassengerDetailsView passengerDetailsView) {
		this.passengerDetailsView=passengerDetailsView;
	}

	public void passengerDetailsController(int flightNumber, String name, String gender, int age, int passengerId, int ticketId, int numberOfPassengers) {
		Database.getInstance().setPassengersList(new Passengers(name,gender,age,passengerId,ticketId++,numberOfPassengers));
	}
	
	public void flightSeats(int flightNumber, int numberOfPassengers) {
		int size=Database.getInstance().getRoutesList().size();
		for(int index=0;index<size;index++) {
			Routes routes = Database.getInstance().getRoutesList().get(index);
			if(flightNumber==routes.getFlightNumber()) {
				routes.setSeats(routes.getSeats()-numberOfPassengers);
				passengerDetailsView.display();
				break;
			}
		}
	}
}
