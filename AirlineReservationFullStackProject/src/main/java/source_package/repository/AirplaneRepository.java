package source_package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import source_package.model.Airplane;

/* "AirlineRepository" interface extends "JpaRepository" interface because
 * it has inbuilt method declarations which we used in hibernate. In order to
 * make use of it, "JpaRepository" is extended. @Repository is used to interact
 * with the database  */
@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer>{

}
