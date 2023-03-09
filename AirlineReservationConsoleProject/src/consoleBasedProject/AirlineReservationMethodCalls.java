/*Author: S.Uma Maheswari
 * Project: Airline Reservation System
 * The Project performs functions such as adding,displaying,
 * searching,updating and deleting airline details.*/
package consoleBasedProject;

import java.util.Scanner;

public class AirlineReservationMethodCalls {
	private static Scanner scan=new Scanner(System.in);

	public static void main(String[] array_name) {

		/* "logIn" method is called using class name "AirlineReservation"
		 * because it is  static method.*/
		AirlineReservation.logIn();

		AirlineMethods call_methods=new  AirlineMethods();

		/*"typeChoice" is a variable which is declared to hold
		 * the inputed value to be passed to switch. */
		byte typeChoice;

		/*"do while" loop is used here, because it executes the statements
		 * inside it atleast once and stops the looping when the condition
		 * fails at the exit check.*/
		do {
			typeChoice = scan.nextByte();

			/*calls the non static method using object of the class 
			 * "AirlineMethods" based on the value on "typeChoice" that is 
			 * given by the user and performs the corresponding process.*/
			switch(typeChoice) {
			case 1:
				call_methods.addAirlines();
				break;

			case 2:
				call_methods.displayAirlines();
				break;

			case 3:
				call_methods.searchAirlines();
				break;

			case 4:
				call_methods.deleteAirlines();
				break;

			case 5:
				call_methods.updateAirlines();
				break;

			case 6:
				call_methods.logOut();
			}
		}while(typeChoice!=6);
	}
}
