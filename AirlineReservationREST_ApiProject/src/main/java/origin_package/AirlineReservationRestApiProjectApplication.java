/* Author: S.Uma Maheswari
 * Project:Airline Reservation System 
 * This project is done using REST API where configuration and 
 * component scan is done automatically using @SpringBootApplication .
 * Also the output can be  seen in server "Postman" along with http status code. */
package origin_package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineReservationRestApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationRestApiProjectApplication.class, args);
	}
}
