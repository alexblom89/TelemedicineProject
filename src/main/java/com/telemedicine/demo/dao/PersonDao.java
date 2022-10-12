package com.telemedicine.demo.dao;

import com.telemedicine.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    /**
     * Method to insert a person that has an id.
     * @param id Person id
     * @param person Person Object
     * @return 1 or 0
     */
    int insertPerson(UUID id, Person person);

    /**
     * Method to insert a person without an id. Creates id, then uses it to call insertPerson method.
     * @param person Person object
     * @return 1 or 0
     */
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    /**
     * Interface for GET request
     * @return List of people
     */
    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
