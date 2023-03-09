/*Author: S.Uma Maheswari
 * Project: Airline Reservation System
 * The Project performs functions such as adding,displaying,
 * searching,updating and deleting airline details using Hibernate.*/

package airlineReservation.airlineReservation.hibernateProject;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AirlineTransactionMethodCall {
	private static Scanner scan = new Scanner(System.in);	

	/* main method contains session details inorder to open the session and
	 *  perform reading , writing operations from/to database. It is surrounded by try catch
	 * to handle the exception."do while" loop has switch case in which each case contains 
	 * respective method calls to perform deletion, insertion,search and display operations.*/
	public static void main( String[] args )
	{
		/*"Configuration is a class which implements "session" interface inorder to
		 * use methods in it. "configure" is a method in hibernate, which is used to read
		 * configuration file. configuration file contains username, password, url to connect
		 * with database.The given entity class must be conveyed to database using "addAnnotatedClass()",
		 * which is a predefined method in hibernate and class name for which the table to be created in
		 * database is passed as parameter."sessionFact" contains only username and password,that is given
		 * by "SessionFactory" and using the credentials stored in "sessionFact", the session is opened using
		 * "openSession()" that helps to open the session for database.*/
		try {
			Configuration config = new Configuration().configure().addAnnotatedClass(AirlineEntity.class);
			SessionFactory sessionFact = config.buildSessionFactory(); 
			Session session = sessionFact.openSession();
			AirlineEntity.logIn();
			AirlineTransaction transaction_object = new AirlineTransaction();

			System.out.println("Press 1 to add airline details");

			System.out.println("Press 2 to search airline details");

			System.out.println("Press 3 to update airline details");

			System.out.println("Press 4 to delete airline details");

			System.out.println("Press 5 to logout");

			/*"adminChoice" is a variable which is declared to hold
			 * the inputed value to be passed to switch. */
			byte adminChoice ;
			do 
			{
				adminChoice = scan.nextByte();
				switch(adminChoice) 
				{
				case 1:
					transaction_object.createAirlineDetails(session);
					break;

				case 2:
					transaction_object. displayByAirlineId(session);
					break;

				case 3:
					transaction_object.updateByAirlineId(session);
					break;

				case 4:
					transaction_object.deleteByAirlineId(session);
					break;

				case 5:
					transaction_object.logOut();
					break;
				}
			}
			while (adminChoice != 5) ;
			scan.close();
		}
		catch(HibernateException obj) 
		{

		}
		catch(Exception obj) 
		{
		}
	}	
}



