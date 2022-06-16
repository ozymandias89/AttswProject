/**
 * Firma di metodo Patient
 */
package com.example.tddfirst.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tddfirst.entities.Patient;

/**
 * @author Banjoman
 *
 */
public interface PatientsRepository extends MongoRepository<Patient, String> {
	Patient findBySurName(String surName); // Ritorna lista di pazienti dal cognome

	List<Patient> findByFirstName(String firstName); // Ritorna lista di pazienti dal nome

}
