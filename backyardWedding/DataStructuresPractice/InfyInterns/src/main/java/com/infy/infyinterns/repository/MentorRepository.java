package com.infy.infyinterns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.infyinterns.entity.Mentor;

public interface MentorRepository extends CrudRepository<Mentor, Integer>
{
	// Method Name METHOD.
    //List<Mentor> findByNumberOfProjectsMentored (Integer nummberOfProjectsMentored);
    
    // @Query METHOD  **-> if the method is updating, deleting or adding to the database, use @Transactional and @Modifying annotations
    @Query("select m from Mentor m where c.numberOfProjectsMentored = :numberOfProjectsMentored")
    List<Mentor> findByNumberOfProjectsMentored(@Param("numberOfProjectsMentored") Integer numberOfProjectsMentored);
    
    //@NamedQuery annotation METHOD
    //Refer back to the course section. requires writing the query above in the Entity class above the class name, with the method name and query detailed in paramters.
    
}
