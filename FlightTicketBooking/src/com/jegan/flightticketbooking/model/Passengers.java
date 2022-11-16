package model;

public class Passengers {
	private String name, gender;
	private int age,passengerId,ticketId,numberOfPassengers;
	
	public Passengers(String name, String gender, int age,int passengerId,int ticketId,int numberOfPassengers) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.passengerId=passengerId;
		this.ticketId=ticketId;
		this.numberOfPassengers=numberOfPassengers;
	}
	
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
}
