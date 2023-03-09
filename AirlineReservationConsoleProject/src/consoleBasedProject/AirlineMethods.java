package consoleBasedProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirlineMethods {
	/* Inbuilt class "ArrayList"  is used from Collections framework in which
	 * the object groups multiple elements into a single unit using which
	 *it enables us to perform storing, retrieving and manipulation of data */
	private static Scanner scan=new Scanner(System.in);
	List<AirlineReservation> airline_object= new ArrayList<AirlineReservation>();

	/* "addAirlines" method is called , when the airline 
	 * details needs to be added to the Arraylist such as 
	 * name,id,source destination,seating capacity and cost.*/
	public void addAirlines() {
		System.out.print("Enter airline_name: ");
		String airline_name=scan.next();

		System.out.print("Enter airline_id: ");
		String airline_id=scan.next();

		System.out.print("Enter source: ");
		String source=scan.next();

		System.out.print("Enter destination: ");
		String destination=scan.next();

		System.out.print("Enter seating capacity: ");
		int seating_capacity=scan.nextInt();

		System.out.print("Enter cost: ");
		int cost=scan.nextInt();

		airline_object.add(new AirlineReservation(airline_name,airline_id,source,destination,seating_capacity,cost));
	}

	/* "displayAirlines" method lists, all the airlines that 
	 * has been already added in the list, by using "Iterator".
	 * "Iterator" is an interface which displays all the elements
	 * stored and it has a predefined method "next" and"has next".
	 * "next" prints the elements and "has next" checks if there is 
	 * next element. */
	public void displayAirlines() {
		Iterator<AirlineReservation> show = airline_object.iterator();
		while(show.hasNext()) 
			System.out.println(show.next());
	}

	/* "searchAirlines" method, searches whether the airline detail
	 * corresponding to the entered id is available or not, by checking
	 * the id entered with the already stored airline id from the list.
	 *"enhanced for loop" stores the elements from the "ArrayList'
	 *to the variable declared and performs looping operation by
	 *passing each element .*/

	public void searchAirlines() {
		boolean search_flag=false;
		System.out.println("Type unique id to search the details");
		String searched_id= scan.next();

		for(AirlineReservation content: airline_object) {
			if(content.getAirline_id().equals(searched_id)) {
				search_flag=true;
				System.out.println("Airline detail found");
				break;
			}
		}
		if(search_flag== false) 
			System.out.println("Airline detail not found");
	}

	/* "deleteAirlines" method removes the airline detail corresponding
	 * to the entered id from the list,by checking the id entered with 
	 * the already stored airline id from the list.*/
	public void deleteAirlines() {
		boolean delete_flag= false;

		System.out.println("Type unique id to delete the details");
		String delete_id= scan.next();

		for(AirlineReservation content:airline_object) {
			if(content.getAirline_id().equals(delete_id)) {
				delete_flag = true;
				airline_object.remove(content);
				System.out.println("deleted succesfully");
				break;
			}
		}
		if(delete_flag == false) 
			System.out.println("Airline detail not found");
	}

	/*"updateAirlines" method updates the details of the airline , 
	 * if there is any change in the inputs. For updating, it first
	 * checks for the availability of the airline by checking the id 
	 * entered with the already stored airline id from the list */
	public void updateAirlines() {
		boolean update_flag=false;

		System.out.println("Type unique id to update the details: ");
		String unique_id=scan.next();

		System.out.println("Type airline name to update the details: ");
		String airline=scan.next();

		int timer=-1;
		for(AirlineReservation details:airline_object) {
			timer++;
			if(details.getAirline_id().equals(unique_id)) {
				update_flag=true;
				System.out.println("Type the updated seating capacity: ");
				int update_seatingCapacity = scan.nextInt();

				System.out.println("Type the updated source: ");
				String update_source = scan.next();

				System.out.println("Type the updated destination: ");
				String update_destination= scan.next();

				System.out.println("Type the updated cost: ");
				int update_cost= scan.nextInt();

				airline_object.set(timer, new AirlineReservation(airline,unique_id,update_source,update_destination,update_seatingCapacity,update_cost));
				break;
			}
		}
		if(update_flag == false) 
			System.out.println("ID not found");
	}

	// "logOut" method closes the process successfully
	public void logOut() {
		System.out.println("Logged out successfully");
	}
}
