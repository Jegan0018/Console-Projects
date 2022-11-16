package repository;

import java.util.ArrayList;

import model.Passengers;
import model.Routes;

public class Database {
	private static Database database = null;
	private ArrayList<Routes> routesList;
	private ArrayList<Passengers> passengersList;
	private static Routes routes1, routes2, routes3;

	private Database() {
		routesList = new ArrayList<Routes>();
		passengersList = new ArrayList<Passengers>();
	}

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
			routes1 = new Routes(1, 100.0, "Kolkatta Airways", "1.00", "11.00", 10, "Chennai", "Kolkata");
			database.setRoutesList(routes1);
			routes2 = new Routes(2, 100.0, "Delhi Airways", "23.00", "05.30", 10, "Chennai", "Delhi");
			database.setRoutesList(routes2);
			routes3 = new Routes(3, 100.0, "Kovai Airways", "23.00", "05.00", 10, "Chennai", "Ahmedabad");
			database.setRoutesList(routes3);
		}
		return database;
	}

	public ArrayList<Routes> getRoutesList() {
		return routesList;
	}

	public void setRoutesList(Routes routes) {
		this.routesList.add(routes);
	}
	
	public ArrayList<Passengers> getPassengersList() {
		return passengersList;
	}

	public void setPassengersList(Passengers passengers) {
		this.passengersList.add(passengers);
	}
}
