package origin_package.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import origin_package.model.Flight;
import origin_package.service.FlightMethodDefinitions;

/* @RestController combines @Controller and @ResponseBody in it. When the 
 * server started, the controller with their related mappings are stored in the IOC container.
 * @ResponseBody responds here by sending java object,which is converted into JSON object using
 *  http message converter, to the request received from the server */
@RestController
public class FlightController {
	public FlightMethodDefinitions method_defined;
	public FlightController(FlightMethodDefinitions method_defined) {
		this.method_defined= method_defined;
	}

	/* Post,Get,Put and delete mappings are http requests. @PostMapping is used 
	 *  when we want to create or save a particular detail or record into the database.
	 *  "HttpStatus.CREATED" is the 201 http status code, which is displayed in the 
	 *  server , when the record is created successfully.By default, 200 http status code 
	 *  " Successful" is displayed, if the record is created successfully */
	@PostMapping("/saveFlightDetails")
	public ResponseEntity<Flight > saveFlightDetails(@RequestBody Flight  detailsOfFlight){
		return new ResponseEntity<Flight >(method_defined.createFlightDetails(detailsOfFlight), HttpStatus.CREATED);
	}

	/* @GetMapping is used when we need to read the records 
	 *  from the database and display it in the server */
	@GetMapping("/readAllFlightDetails")
	public List<Flight > receiveAllFlightDetails(){
		return method_defined. readAllFlightDetails();
	}

	/* @GetMapping is used when we need to read the records 
	 *  from the database and display it in the server. Here, record is read
	 *  for the id received from the server. @PathVariable
	 *  is used  to take only the value,when the server sends 
	 * the url as a request along with some value."ResponseEntity"
	 * is an inbuilt class, which is used here, in order to return https status code as response*/
	@GetMapping("/readFlightDetailById/{id}")
	public ResponseEntity<Flight >  receiveDetailByFlightId(@PathVariable("id")  int airlineId){
		return new ResponseEntity<Flight >( method_defined. readDetailsByFlightId(airlineId), HttpStatus.OK);
	}

	/* @PutMapping is used whenever we do any updation or 
	 * changes in the existing record. @RequestBody is used to receive the
	 *  request sended by the server*/
	@PutMapping("/updateFlightDetailById/{id}")
	public ResponseEntity<Flight > updateDetailByFlightId(@PathVariable("id") int airlineId,
			@RequestBody Flight updatedDetails){
		return new ResponseEntity<Flight>(method_defined.updateDetailsByFlightId(updatedDetails,airlineId), HttpStatus.OK);
	}

	/* @DeleteMapping is used when we need to delete a record
	 * in the database*/
	@DeleteMapping("/deleteFlightDetailById/{id}")
	public ResponseEntity<String> deleteDetails(@PathVariable("id")  int airlineId){
		method_defined.deleteDetailsByFlightId(airlineId);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
	}
}




