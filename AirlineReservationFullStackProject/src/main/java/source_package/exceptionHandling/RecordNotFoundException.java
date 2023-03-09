package source_package.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* "@ResponseStatus" is used when need to pass only http status code to 
 * the server. The status code for "HttpStatus.NOT_FOUND is 404. This class 
 * extends  "RuntimeException" inbuit class, which has static final  long attribute 
 * "serialVersionUID" , as it has implemented "Serializable" interface in which 
 * this attribute has been declared. "serialVersionUID" is defined to identify the
 * objects created from which class. The parameterized constructor  of 
 * " RecordNotFoundException" receives the customized message from Controller (if record was 
 * not found for the particular which has been sent as request from the server) 
 * and throws exception with this customized message */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public RecordNotFoundException(String message) {
		super(message);
	}
}
