package origin_package.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;

/* To differentiate java file and database related java file we use @Entity
 * for  the database know to which class the object created belongs. The table will be 
 * created automatically and by default it creates table name same as the class name.
 * @DynamicUpdate, avoids checking for changes in values in all the columns,
 * by checking and updating only the specific column's value that is said to update.*/
@Entity
@DynamicUpdate
public class Flight {
	/* @Id must be given to the entity classes, which makes
	 * the attributes to act as primary key.In @GeneratedValue, what
	 * type of primary key to be generated is given in it. Here, primary key
	 * type IDENTITY is given which starts by 1 and increments by 1.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airlineId;

	private String airlineName;
	private String source;
	private String destination;
	private Integer seatingCapacity;
	private Integer cost;

	public Flight() {
	}

	public Flight(String airlineName, String source, String destination, Integer seatingCapacity,Integer cost) 
	{
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.seatingCapacity = seatingCapacity;
		this.cost = cost;
	}

	/* Here we used setter method for all the attributes  to set the value.
	 * "this" keyword refers to the current class object and also as the names 
	 * of attribute & variable in parameters  are similar we used "this" keyword 
	 * to differentiate between them. Here we used getter method for  all the 
	 * attributes to return it's value.*/
	public String getAirlineName() {
		return  airlineName;
	}
	public void setAirlineName(String airlineName) {
		this. airlineName =  airlineName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source ) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination ) {
		this. destination=  destination;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity= seatingCapacity;
	}
	public Integer getCost() {
		return  cost;
	}
	public void setCost(Integer cost) {
		this. cost=cost;
	}
}


