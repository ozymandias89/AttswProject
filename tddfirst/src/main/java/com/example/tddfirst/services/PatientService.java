package com.example.tddfirst.services;

import java.util.List;

import com.example.tddfirst.entities.Patient;

public interface PatientService {


	Patient findBySurName(String surName); //

	List<Patient> findByFirstName(String firstName); //

	void save(Patient patient);

	void delete(Patient patient);
	
	void deleteAll();

}
