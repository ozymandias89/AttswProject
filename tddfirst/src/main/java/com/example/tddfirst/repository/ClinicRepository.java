/**
 * Firma di metodo Patient
 */
package com.example.tddfirst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tddfirst.entities.Clinic;

/**
 * @author Banjoman
 *
 */
public interface ClinicRepository extends MongoRepository<Clinic, String> {
	Clinic findByFirstName(String firstName); // Ritorna lista degli ambulatori dalla tipologia
}