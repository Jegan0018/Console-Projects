package view;

import java.util.Scanner;

import controller.PassengerSearchController;
import model.Passengers;
import model.Routes;

public class PassengerSearchView {
	private Scanner scanner=new Scanner(System.in);
	private PassengerSearchController passengerSearchController;
	
	PassengerSearchView() {
		passengerSearchController=new PassengerSearchController(this);
	}
	
	public void searchPassenger() {
		int passengerId;
		System.out.println("Enter PassengerId");
		passengerId=scanner.nextInt();
		passengerSearchController.searchFlights(passengerId);
	}

	public void displayData(Passengers passengers, Routes routes) {
		System.out.println("Name :" + passengers.getName());
		System.out.println("Age :" + passengers.getAge());
		System.out.println("Gender :" + passengers.getGender());
		System.out.println("Passenger Id :" + passengers.getPassengerId());
		System.out.println("Flight Number : "+routes.getFlightNumber());
	}

}
