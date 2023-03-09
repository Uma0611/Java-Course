package origin_package.flightInterface;

import java.util.List;

import origin_package.model.Flight;

/* This interface contains only method declarations for
 * create,update,delete,search and display of the airline details*/
public interface FlightMethods {
	Flight createFlightDetails(Flight details);
	List<Flight> readAllFlightDetails();
	Flight readDetailsByFlightId(int  airline_id);
	Flight updateDetailsByFlightId(Flight update_details, int airline_id);
	void deleteDetailsByFlightId( int airline_id);
}
