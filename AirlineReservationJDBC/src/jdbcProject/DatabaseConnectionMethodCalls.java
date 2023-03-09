/*Author: S.Uma Maheswari
 * Project: Airline Reservation System
 * The Project performs functions such as adding,displaying,
 * searching,updating and deleting airline details using JDBC.*/

package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/*	There are some  rules to connect a java program to the database,they are
 * 1.Load the driver
 * 2.Register the driver
 * 3.Create the connection
 * 4.Create the statements
 * 5.Execute the queries
 * 6.Get the resultSet
 * 7.Close the connection*/
public class DatabaseConnectionMethodCalls {

	/*"createConnection" method performs operations such as 
	 * register the driver and create the connection. The first step is
	 * "load the driver" is performed by loading JDBC into the Classpath.
	 * These  operations are surrounded by "try catch" as there is a
	 * chance of exception, if the connection did not open*/
	public static Connection createConnection() {
		Connection connection=null;
		try {
			String userName = "root";
			String password = "Gooseberry9811#";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline_Reservation_JDBC", userName, password);
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
		return connection;
	}

	public static void main(String[] args)throws NullPointerException,SQLException{
		FlightDatabaseMethodsDefined  access_data=new FlightDatabaseMethodsDefined ();
		Connection connectionData=createConnection() ;
		Scanner scan_object=new Scanner(System.in);
		FlightData.logIn();

		System.out.println("Press 1 to add airlineDetails");

		System.out.println("Press 2 to display all airlineDetails");

		System.out.println("Press 3 to search airlineDetails");

		System.out.println("Press 4 to update airlineDetails ");

		System.out.println("Press 5 to delete airlineDetails");

		System.out.println("Press 6 to logout");


		/*" typeChoice" is a variable which is declared to hold
		 * the inputed value to be passed to switch. */
		byte typeChoice;
		do {
			/*calls the non static method using object of the class 
			 * "FlightDatabaseMethodsDefined" based on the value on "typeChoice" that is 
			 * given by the user and performs the corresponding process.*/
			typeChoice= scan_object.nextByte();
			switch(typeChoice) {
			case 1:
				access_data.addAirlines(connectionData);
				break;
			case 2:
				access_data.displayAllAirlines(connectionData);
				break;
			case 3:
				access_data.displayAirlineById(connectionData);
				break;
			case 4:
				access_data. updateAirlineById(connectionData);
				break;
			case 5:
				access_data.deleteAirlineById(connectionData);
				break;
			case 6:
				access_data.logOut();
			}
		}while(typeChoice!=6);
		connectionData.close();
		scan_object.close();
	}
}
