package source_package.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import source_package.exceptionHandling.RecordNotFoundException;
import source_package.model.Airplane;
import source_package.repository.AirplaneRepository;

@CrossOrigin(origins ="http://localhost:4200")

/* @RestController combines @Controller and @ResponseBody in it. When the 
 * server started, the controller with their related mappings are stored in the IOC container.
 * @ResponseBody responds here by sending java object,which is converted into JSON object using
 *  http message converter, for the request received from the server */
@RestController
@RequestMapping("/AirlineReservation/")
public class AirplaneController {

	private AirplaneRepository airplaneReposit;

	/* Post,Get,Put and delete mappings are http request methods. @PostMapping is used 
	 *  when we want to create or save a particular detail or record into the database.
	 *  "HttpStatus.CREATED" is the 201 http status code, which is displayed in the 
	 *  server , when the record is created successfully.By default, 200 http status code 
	 *  "Successful" is displayed, if the record is created successfully */
	@PostMapping("/storeDetails")
	public Airplane  createAirplaneDetails(@RequestBody  Airplane flightDetails) {
		return airplaneReposit .save(flightDetails);
	}

	/* @GetMapping is used when we need to read the records 
	 *  from the database and display it in the server */
	@GetMapping("/showAllDetails")
	public List<Airplane> readAllAirplaneDetails(){
		return airplaneReposit.findAll();
	}		

	/* @GetMapping is used when we need to read the records 
	 *  from the database and display it in the server. Here, record is read
	 *  for the id received from the server. @PathVariable
	 *  is used  to take only the value,when the server sends 
	 * the url as a request along with some value."ResponseEntity"
	 * is an inbuilt class, which is used here, in order to return https status code as response*/
	@GetMapping("/showIdDetail/{id}")
	public ResponseEntity<Airplane> readDetailsByAirplaneId(@PathVariable int id) {
		Airplane recordStored= airplaneReposit.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("The record for id "+id+" does not exist"));
		return ResponseEntity.ok(recordStored);
	}

	/* @PutMapping is used whenever we do any updation or 
	 * changes in the existing record. @RequestBody is used to receive the
	 *  request sended by the server. "orElseThrow()" is the predefined method in
	 *  inbuilt "Optional" class. "orElseThrow()" returns the record, if it is present 
	 *  in the database. If not, it throws customized exception which is passed to
	 *  parameterized constructor of "RecordNotFoundException" class */
	@PutMapping("/changeIdDetail/{id}")
	public ResponseEntity<Airplane> updateDetailsByAirplaneId(@PathVariable int id, @RequestBody Airplane detailsOfFlight){
		Airplane storedRecord= airplaneReposit.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("The record for id "+id+" does not exist"));

		storedRecord.setAirplaneName(detailsOfFlight.getAirplaneName());
		storedRecord.setSource(detailsOfFlight.getSource());
		storedRecord.setDestination(detailsOfFlight.getDestination());
		storedRecord.setSeatingCapacity(detailsOfFlight.getSeatingCapacity());
		storedRecord.setCost(detailsOfFlight.getCost());

		Airplane updatedDetail = airplaneReposit.save(storedRecord);
		return ResponseEntity.ok(updatedDetail);
	}

	/* @DeleteMapping is used when we need to delete a  
	 * existing record in the database */
	@DeleteMapping("/deleteIdDetail/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDetailsByAirplaneId(@PathVariable int id){
		Airplane existingRecord= airplaneReposit.findById(id)
				.orElseThrow(() -> new  RecordNotFoundException("The record for id "+id+" does not exist"));
		airplaneReposit.delete(existingRecord);
		Map<String, Boolean> responseMessage = new HashMap<>();
		responseMessage.put("The record for id "+id+" was deleted successfully", Boolean.TRUE);
		return ResponseEntity.ok(responseMessage);
	}
}



