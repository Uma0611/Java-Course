package jdbcProject;

import java.util.Scanner;

public class FlightData {

	/*Created all attributes in private so that no one can access them, 
	 * only inside the class we can have the access.*/
	private String airline_id,airline_name,departurePlace,arrivalPlace;
	private int seating_capacity, cost;
	private static Scanner scan=new Scanner(System.in);

	/* Here we used setter method for all the attributes  to set the value.
	 * "this" keyword refers to the current class object and also as the names 
	 * of attribute & variable in parameters  are similar we used "this" keyword 
	 * to differentiate between them. Here we used getter method for  all the 
	 * attributes to return it's value.*/
	public  String getAirline_id() {
		return airline_id;
	}
	public void setAirline_id(String  airline_id) {
		this.airline_id=airline_id;
	}

	public  String getAirline_name() {
		return airline_name;
	}
	public void setAirline_name(String  airline_name) {
		this.airline_name=airline_name;
	}

	public  String getDeparturePlace() {
		return departurePlace;
	}
	public void setDeparturePlace(String  departurePlace) {
		this.departurePlace=departurePlace;
	}

	public  String getArrivalPlace() {
		return arrivalPlace;
	}
	public void setArrivalPlace(String  arrivalPlace) {
		this.arrivalPlace=arrivalPlace;
	}

	public  int getSeatingCapacity() {
		return seating_capacity;
	}
	public void setSeatingCapacity(int seating_capacity) {
		this. seating_capacity= seating_capacity;
	}

	public  int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost=cost;
	}

	/* "logIn" method enables to perform login operation by
	 * getting name and password from the user.To check whether 
	 * the name and the password given is correct or not,
	 * "checkCredentials" method is called and the given credentials 
	 * are passed to that method*/
	public static void logIn() {
		System.out.print("Holder name: ");
		String holder_name=scan.next();

		System.out.print("Holder password: ");
		String holder_password=scan.next();

		checkCredentials(holder_name,holder_password);
	}

	/* "checkCredentials" method checks whether the given name
	 * and password is correct, if not, the "logIn" method is called
	 * to re-enter the credentials again*/
	public static void checkCredentials(String holder_name,String holder_password) {

		if(holder_name.equals("Traveller") && holder_password.equals("journey90" )) {
			System.out.println("Logged In Successfully");
		}
		else {
			System.out.println("Check your credentials and Enter correct holder_name, holder_password again");
			System.out.println();
			logIn(); 
		}
	}
}
