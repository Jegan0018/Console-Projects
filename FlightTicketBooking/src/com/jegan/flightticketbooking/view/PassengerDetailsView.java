package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.PassengerBookingController;
import model.Passengers;
import model.Routes;
import repository.Database;

public class PassengerDetailsView {
	private Scanner scanner=new Scanner(System.in);
	static int passengerId=1000,ticketId=1;
	PassengerBookingController passengerBooking;
	
	PassengerDetailsView() {
		passengerBooking=new PassengerBookingController(this);
	}
	
	public void passengerDetailsView(int flightNumber, int numberOfPassengers) {
		int times=1;
		String name = "",gender = "";
		int age = 0;
		while(times<=numberOfPassengers) {
			scanner.nextLine();
			System.out.println("Enter Name");
			name=scanner.nextLine();
			scanner.nextLine();
			System.out.println("Enter Gender");
			gender=scanner.nextLine();
			System.out.println("Enter Age");
			age=scanner.nextInt();
			times++;
			passengerId++;
			passengerBooking.passengerDetailsController(flightNumber,name,gender,age,passengerId,ticketId,numberOfPassengers);
		}
		passengerBooking.flightSeats(flightNumber,numberOfPassengers);
	}

	public void display() {
		int size=Database.getInstance().getPassengersList().size();
		int routesSize=Database.getInstance().getRoutesList().size();
		for (int index = 0; index < size; index++) {
			Passengers passengers = Database.getInstance().getPassengersList().get(index);
			System.out.println("Name :" + passengers.getName());
			System.out.println("Age :" + passengers.getAge());
			System.out.println("Gender :" + passengers.getGender());
			System.out.println("Passenger Id :" + passengers.getPassengerId());
			System.out.println("Ticket Id :" + passengers.getTicketId());
		}
		System.out.println("Tickets Booked Succesfully");
	}
}
