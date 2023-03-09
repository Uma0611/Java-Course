package source_package.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/* To differentiate java file and database related java file we use @Entity
 * for  the database know to which class the object created belongs. The table will be 
 * created automatically and by default it creates table name same as the class name.
 * @DynamicUpdate, avoids checking for changes in values in all the columns,
 * by checking and updating only the specific column's value that is said to update.
 * @Table is used to create our own name for the table which has been created in the 
 * database, if class name is not required as a table name */
@Entity
@Table(name ="Airplane_system")
@DynamicUpdate
public class Airplane {


	/* @Id must be given to the entity classes, which makes
	 * the attributes to act as primary key.In @GeneratedValue, what
	 * type of primary key to be generated is given in it. Here, primary key
	 * type IDENTITY is given which starts by 1 and increments by 1. @Column
	 * is used to create our own name for the column of the table which has
	 *  been created in the database, if attribute name is not required as a column name */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airplaneId;

	@Column(name = "flightName")
	private String airplaneName;

	@Column(name = "sourcePoint")
	private String source;

	@Column(name = "destinationPoint")
	private String destination;

	private Integer seatingCapacity;
	private Integer cost;

	public Airplane() {
	}

	public Airplane(String airplaneName, String source, String destination, Integer seatingCapacity,Integer cost) {
		this.airplaneName = airplaneName;
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
	public String getAirplaneName() {
		return airplaneName;
	}
	public void setAirplaneName(String airplaneName) {
		this. airplaneName =  airplaneName;
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


