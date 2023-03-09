package consoleBasedProject;

import java.util.Scanner;

public class AirlineReservation {
	/*The attributes used are airline_id,airline_name,source,
	 * destination,seating_capacity and cost which has accessibility
	 * as private, that is, it is accessible only within the class.
	 * Inbuilt class "ArrayList"  is used from Collections framework in which
	 *the object groups multiple elements into a single unit using which
	 *it enables us to perform storing, retrieving and manipulation of data*/

	private String airline_id,airline_name,source,destination;
	private int seating_capacity, cost;
	private static Scanner scan=new Scanner(System.in);
	
	/*when the object is created for the class "Airline", after assigning default
	 * values to the attributes of the class by default constructor, the control comes 
	 * to no argument constructor "Airline" and prints the statements inside it. */
	public AirlineReservation() {
	}

	/*The details which are entered by the user, is passed to the parameterized 
	 * constructor which assigns values to the attributes of the class "Airline".
	 * "this" keyword is used to differentiate the parameter and the attribute,
	 * when both having same name and it represents the current class object.*/
	public AirlineReservation(String airline_name, String airline_id, String source,String destination,int seating_capacity,int cost){
		this.airline_name=airline_name ;
		this.airline_id=airline_id ;
		this.source =source ;
		this.destination=destination;
		this.seating_capacity=seating_capacity;
		this.cost=cost;
	}

	/*A getter method enables to obtain and return the values of private 
	 * attributes.Getter method is always preceded by the keyword "get".
	 * A setter method  enables to set and modify the values of private
	 * attributes.Setter method is always preceded by the keyword "set".
	 * "this" keyword refers to the current class object and also as the names 
	 * of attribute & variable in parameters  are similar we used "this" keyword 
	 * to differentiate between them.*/
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

	public  String getSource() {
		return source;
	}
	public void setSource(String  source) {
		this.source=source;
	}

	public  String getDestination() {
		return destination;
	}
	public void setDestination(String  destination) {
		this.destination=destination;
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

	/*"toString" is the predefined method in "Object" class, which 
	 * returns all the values in the string format */
	public String toString() {
		return airline_id+ " "+ airline_name +" "+ source+" "+destination+" "+seating_capacity+" "+cost;
	}
	
	public static void displayInstructions() {
		System.out.println();
		
		System.out.println("Press 1 to add an airline");

		System.out.println("Press 2 to display all the airlines");

		System.out.println("Press 3 to search an airline");

		System.out.println("Press 4 to delete an  airline");

		System.out.println("Press 5 to update an airline");

		System.out.println("Press 6 to logout");

		System.out.println();
	}

	/*"logIn" method enables to perform login operation by
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
		
		displayInstructions();
	}

	/*"checkCredentials" method checks whether the given name
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
