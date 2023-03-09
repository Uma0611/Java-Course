package airlineReservation.airlineReservation.hibernateProject;

import java.util.Scanner;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/* To differentiate java file and database related java file we use @Entity
 * through the database know to which class the object created belongs.
 * @DynamicUpdate, avoids checking for changes in values in all the columns,
 * by checking and updating only the specific column value that is said to update.*/
@Entity(name="AirlineDetails")
@DynamicUpdate
public class AirlineEntity {
	private static Scanner scan=new Scanner(System.in);

	/* @Id must be given to the entity classes, in which makes
	 * the attributes to act as primary key. In @GeneratedValue, what
	 * type of primary key to be generated is given in it. Here, primary key
	 * type IDENTITY is given which starts by 1 and increments by 1.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airlineId;
	private String airlineName;
	private String source;
	private String destination;
	private Integer seatingCapacity;
	private Integer cost;

	/* Here we used setter method for all the attributes  to set the value.
	 * "this" keyword refers to the current class object and also as the names 
	 * of attribute & variable in parameters  are similar we used "this" keyword 
	 * to differentiate between them. Here we used getter method for  all the 
	 * attributes to return it's value.*/
	public String getAirlineName() {
		return  airlineName;
	}
	public void setAirlineName(String airlineName) {
		this. airlineName =  airlineName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source ) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination ) {
		this. destination=  destination;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity= seatingCapacity;
	}
	public Integer getCost() {
		return  cost;
	}
	public void setCost(Integer cost) {
		this. cost=cost;
	}

	@Override
	public String toString() {
		return "AirlineReservation [airlineName=" + airlineName + ", source=" + source+ ", destination=" 
				+ destination + ", seatingCapacity=" + seatingCapacity + ", cost=" + cost + "]";
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
