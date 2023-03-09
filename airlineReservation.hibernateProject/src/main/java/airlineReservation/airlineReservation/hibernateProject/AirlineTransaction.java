package airlineReservation.airlineReservation.hibernateProject;

import java.util.Scanner;

import org.hibernate.Session;

public class AirlineTransaction {
	private static Scanner scan = new Scanner(System.in);	

	/*"createAirlineDetails" method is used to insert airlines details to database.
	 * "beginTransaction()" is used to start and record the process. The details
	 * entered is passed through "getAirlineDetails()". "commit()"
	 * is used to make the permanent changes in the database".*/
	public void createAirlineDetails(Session session) {
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Integer id = (Integer) session.save(getAirlineDetails());
		System.out.println("Airline detail is created with id : "+id);
		session.getTransaction().commit();
	}

	/*"displayByAirlineId" method is used to display the airline to database by
	 * entering specific id. If the id entered is available, it performs the
	 * specified operation or it will display the id not found prompt.
	 * "beginTransaction()" is used to start and record the process.
	 * "commit()" is used to make the permanent changes in the database.*/
	public void displayByAirlineId(Session session) {
		System.out.print("Enter the Airline id to search: ");
		AirlineEntity showRecord= session.get(AirlineEntity.class, scan.nextInt());
		if(showRecord!= null) {
			System.out.println(showRecord);
		}
		else {
			System.out.println("Airline id doesn't exists..");
		}	
	}

	/*"updateByAirlineId" method is used to update the airline to database by
	 * entering specific id. If the id entered is available, it performs the
	 * specified operation or it will display the id not found prompt.
	 * "beginTransaction()" is used to start and record the process.
	 * "commit()" is used to make the permanent changes in the database.*/
	public void updateByAirlineId(Session session) {
		System.out.print("Enter the Airline id to update: ");
		AirlineEntity updateRecord= session.get(AirlineEntity.class, scan.nextInt());

		if(updateRecord != null) {
			System.out.print("Enter the Source to update: ");
			updateRecord.setSource(scan.next());

			System.out.print("Enter the Destination to update: ");
			updateRecord.setDestination(scan.next());

			System.out.print("Enter the Seating capacity to update: ");
			updateRecord.setSeatingCapacity(scan.nextInt());

			System.out.print("Enter the Cost to update: ");
			updateRecord.setCost(scan.nextInt());

			session.beginTransaction();
			session.persist(updateRecord);
			session.getTransaction().commit();
		}
		else {
			System.out.println("Airline id doesn't exists..");
		}	
	}

	/* "deleteByAirlineId" method is used to delete the airline to database by
	 * entering specific id. If the id entered is available, it performs the
	 * specified operation or it will display the id not found prompt.
	 * "beginTransaction()" is used to start and record the process.
	 * "commit()"is used to make the permanent changes in the database.*/
	public void deleteByAirlineId(Session session) {
		System.out.print("Enter the Airline id to delete: ");
		AirlineEntity deleteRecord= session.get(AirlineEntity.class, scan.nextInt());
		if(deleteRecord != null) {
			session.beginTransaction();
			session.remove(deleteRecord);
			session.getTransaction().commit();
			System.out.println("Airline detail was deleted successfully");
		}
		else {
			System.out.println("Airline id doesn't exists..");
		}	
	}

	/* "getAirlineDetails" performs operation of getting
	 * input from the user and returning it through object of class type.*/
	public static AirlineEntity getAirlineDetails(){
		AirlineEntity object_airline=new AirlineEntity();
		System.out.print("Enter the Airline name: ");
		object_airline.setAirlineName(scan.next());

		System.out.print("Enter the Airline source: ");
		object_airline.setSource(scan.next());

		System.out.print("Enter the Airline destination: ");
		object_airline.setDestination(scan.next());

		System.out.print("Enter the Airline seating_capacity: ");
		object_airline.setSeatingCapacity(scan.nextInt());

		System.out.print("Enter the Airline cost: ");
		object_airline.setCost(scan.nextInt());
		return object_airline;
	}
	// "logOut" method ends the process
	public void logOut() {
		System.out.println("Logged out successfully");
	}
}



