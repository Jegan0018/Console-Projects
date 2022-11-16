package view;

import java.util.Scanner;

import controller.PassengerBookingController;
import controller.PassengerCancelController;
import model.Passengers;
import repository.Database;

public class PassengerCancelTickets {
	PassengerCancelController passengerCancelController;
	private Scanner scanner=new Scanner(System.in);
	PassengerCancelTickets() {
		passengerCancelController=new PassengerCancelController(this);
	}

	public void passengerDetailsController(int flightNumber, String name, String gender, int age, int passengerId, int ticketId, int numberOfPassengers) {
		Database.getInstance().setPassengersList(new Passengers(name,gender,age,passengerId,ticketId++,numberOfPassengers));
	}
	public void cancelTicket() {
		int ticketId,flightNumber;
		System.out.println("Enter TicketId");
		ticketId = scanner.nextInt();
		System.out.println("Enter Flight Number");
		flightNumber = scanner.nextInt();
		passengerCancelController.cancelSeats(ticketId,flightNumber);
	}

}
