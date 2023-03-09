package jdbcProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FlightDatabaseMethodsDefined {
	private static final Scanner scanner_object=new Scanner(System.in);

	/* "addAirlines" method performs insertion of airline details 
	 * to SQL through java with the help of "PreparedStatement".
	 * Whenever the values are dynamic and the user is going to give input,
	 * "PreparedStatement" is used.Any type of query can be given here. 
	 * "executeUpdate" method is used whenever a change is going to
	 *occur inside the table in the database,it returns the integer value.
	 *"set" method sets the values with respect to the number of columns given. */
	public void addAirlines( Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement prepare_state = connectionData.prepareStatement("INSERT  INTO FlightData VALUES (?,?,?,?,?,?)");
		System.out.println("Enter the Airline_id: ");
		prepare_state.setString(1,scanner_object.next());

		System.out.println("Enter the Airline_name: ");
		prepare_state.setString(2,scanner_object.next());

		System.out.println("Enter the Source: ");
		prepare_state.setString(3,scanner_object.next());

		System.out.println("Enter the Destination: ");
		prepare_state.setString(4,scanner_object.next());

		System.out.println("Enter the SeatingCapacity : ");
		prepare_state.setInt(5,scanner_object.nextInt());

		System.out.println("Enter the cost: ");
		prepare_state.setInt(6,scanner_object.nextInt());


		/*"executeUpdate" method is used, whenever a change
		 * is going to happen inside the table in the database*/
		int airline_add = prepare_state.executeUpdate();
		System.out.println(airline_add +" The details of airline was added successfully");
	}

	/* "displayAllAirlines" method displays all the records in the table
	 * from the database. "Statement" is used, whenever to write the 
	 * queries in java and read the values from the database.The result 
	 * got is stored using the "ResultSet", using which the result is displayed */
	public void displayAllAirlines(Connection connectionData) throws NullPointerException,SQLException {
		Statement stateAll=connectionData.createStatement();
		ResultSet save_result=stateAll.executeQuery("SELECT * FROM  FlightData");

		/*"next" method checks whether there is next record and 
		 * produces the record, if it is available. "getString" method
		 * prints the records by using  the column number*/
		while(save_result.next()) {
			System.out.println(save_result.getString(1)+"  "+save_result.getString(2)+"  "+save_result.getString(3)+"  "+save_result.getString(4)+"  "+save_result.getInt(5)+"  "+save_result.getInt(6));
		}
	}

	/* " displayAirlineById(" method searches whether the user given id 
	 * is available in the database or not. "executeQuery" method is
	 * used, whenever the queries in database is to be executed here,
	 * to display the result. The result got is stored using the "ResultSet",
	 * using which the result is displayed. */
	public void displayAirlineById(Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement prepare_state = connectionData.prepareStatement("SELECT * FROM FlightData WHERE airline_id=?");
		System.out.print("Enter the Airline_id to display its details: ");
		//	String display_id =scanner_object.next();
		prepare_state.setString(1,scanner_object.next());
		ResultSet record_result=prepare_state.executeQuery();
		while(record_result.next()) {
			System.out.println(record_result.getString(1)+" "+record_result.getString(2)+" "+record_result.getString(3)+" "+record_result.getString(4)+" "+record_result.getInt(5)+" "+record_result.getInt(6));
		}
	}

	/* "updateAirlineById" method updates the changes made, into the
	 * table in the database."executeUpdate" method is used whenever
	 * a change is going to occur inside the table in the database,
	 * it returns the integer value*/
	public void updateAirlineById(Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement update_value = connectionData.prepareStatement("UPDATE FlightData SET departurePlace=?,arrivalPlace=?,seating_capacity = ?,cost=? WHERE airline_id = ?");
		System.out.print("Enter the Airline_id to update its details:  ");
		update_value.setString(5,scanner_object.next());

		System.out.print("Enter the DeparturePlace to update: ");
		update_value.setString(1,scanner_object.next());

		System.out.print("Enter the ArrivalPlace to update:: ");
		update_value.setString(2,scanner_object.next());

		System.out.print("Enter the SeatingCapacity to update:: ");
		update_value.setInt(3,scanner_object.nextInt());

		System.out.print("Enter the Cost to update: ");
		update_value.setInt(4,scanner_object.nextInt());

		int airline_update = update_value.executeUpdate();
		System.out.println(airline_update +" updated successfully");
	}

	/* "deleteAirlineById" method deletes the record related to the
	 * id given by the user."executeUpdate" method is used whenever
	 * a change is going to occur inside the table in the database,
	 * it returns the integer value*/
	public void deleteAirlineById(Connection connectionData) throws NullPointerException,SQLException {
		PreparedStatement delete_state = connectionData.prepareStatement("DELETE FROM FlightData WHERE airline_id=? ");
		System.out.print("Enter the Airline_id to delete its details: ");
		delete_state.setString(1,scanner_object.next());
		int airline_delete= delete_state.executeUpdate();
		System.out.println(airline_delete+" deleted sucessfully");
	}

	// "logOut" method ends the process
	public void logOut() {
		System.out.println("Logged out successfully");
	}
}
