package com.example.tddfirst.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tddfirst.entities.Patient;
import com.example.tddfirst.repository.PatientsRepository;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientsRepository patientrepository;

	@Override
	public Patient findBySurName(String surName) {
		return patientrepository.findBySurName(surName);
	}

	@Override
	public List<Patient> findByFirstName(String firstName) {
		return patientrepository.findByFirstName(firstName);
		}

	@Override
	public void save(Patient patient) {
		patientrepository.save(patient);
	}

	@Override
	public void delete(Patient patient) {
		patientrepository.delete(patient);
		
	}

	@Override
	public void deleteAll() {
		patientrepository.deleteAll();
		
	}

}
