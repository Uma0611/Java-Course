package origin_package.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import origin_package.flightInterface.FlightMethods;
import origin_package.model.Flight;
import origin_package.repository.FlightRepository;

/* @Service  tells the server that it has a class which has implemented 
 *  an interface and provided the method definitions for those methods 
 *  declared in that interface.*/
@Service
public class FlightMethodDefinitions implements FlightMethods{
	FlightRepository  flightReposit;

	public FlightMethodDefinitions(FlightRepository  flightReposit) {
		this.flightReposit=flightReposit;

	}

	/* "createAirlineDetails" method saves the details sended from
	 * the server into the database by using "save" method in hibernate */
	public Flight createFlightDetails(Flight details) {
		return  flightReposit.save(details);
	}

	/*  "displayAllAirlineDetails" method displays all the details stored in
	 * the database in the server by using "findAll" method in hibernate*/
	public List<Flight>   readAllFlightDetails(){
		return  flightReposit.findAll();
	}

	/* "displayByAirlineId" method displays a particular record stored in
	 * the database in the server , with respect to the id sended as request 
	 * to the server, by using "findById" method in hibernate*/
	public	 Flight readDetailsByFlightId(int airline_id) {
		Optional<Flight> airline_detail = flightReposit. findById(airline_id);
		if(airline_detail.isPresent()) {
			return airline_detail.get();
		}
		else {
			return null;
		}
	}

	/* "updateByAirlineId" method updates the changes made in existing
	 * record stored in  the database from the server side , with respect to 
	 * the id sended as request  to the server, by using "findById" method in hibernate*/
	public Flight updateDetailsByFlightId(Flight update_details, int airline_id) {
		Optional<Flight> updateAirline_detail  =flightReposit.findById(airline_id);
		if(updateAirline_detail.isPresent()) {
			Flight existingAirline = updateAirline_detail.get(); 

			existingAirline.setSource(update_details.getSource());
			existingAirline. setDestination(update_details.getDestination());
			existingAirline. setSeatingCapacity(update_details.getSeatingCapacity());
			existingAirline.setCost (update_details.getCost());
			flightReposit.save( existingAirline);
			return  existingAirline;
		}
		else {
			return null;
		}
	}

	/* "deleteByAirlineId" method deletes a particular record stored in  the 
	 * database, from the server side with respect to the id sended as request 
	 *  to the server, by using "findById" method in hibernate*/
	public void  deleteDetailsByFlightId(int airline_id) {
		Optional<Flight> deleteAirline_detail =  flightReposit.findById(airline_id);
		if(deleteAirline_detail .isPresent()) {
			flightReposit.deleteById( airline_id);
		}	
	}
}


