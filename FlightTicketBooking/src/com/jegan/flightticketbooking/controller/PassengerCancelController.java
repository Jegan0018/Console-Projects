package controller;

import model.Passengers;
import model.Routes;
import repository.Database;
import view.PassengerCancelTickets;

public class PassengerCancelController {
	private PassengerCancelTickets passengerCancelTicket;
	public PassengerCancelController(PassengerCancelTickets passengerCancelTicket) {
		this.passengerCancelTicket=passengerCancelTicket;
	}

	public void passengerDetailsController(int flightNumber, String name, String gender, int age, int passengerId, int ticketId, int numberOfPassengers) {
		Database.getInstance().setPassengersList(new Passengers(name,gender,age,passengerId,ticketId++,numberOfPassengers));
	}
	
	public void cancelSeats(int ticketId, int flightNumber) {
		int size=Database.getInstance().getRoutesList().size();
		for(int index=0;index<size;index++) {
			Passengers passengers=Database.getInstance().getPassengersList().get(index);
			Routes routes = Database.getInstance().getRoutesList().get(index);
			if(ticketId==passengers.getTicketId() && flightNumber==routes.getFlightNumber()) {
				routes.setSeats(routes.getSeats()+passengers.getNumberOfPassengers());
				System.out.println("Tickets Cancelled Successfully");
				System.out.println("The Amount "+routes.getPrice()+" will Refunded Soon");
				break;
			}
		}
	}
}
