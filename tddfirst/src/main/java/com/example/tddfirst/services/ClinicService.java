package com.example.tddfirst.services;

import com.example.tddfirst.entities.Clinic;
import com.example.tddfirst.entities.Doctor;

public interface ClinicService {


	Clinic findByFirstName(String firstName); //

	void save(Clinic clinic);

	void delete(Clinic clinic);
	
	Clinic insertDoctor(Clinic clinic, Doctor doctor);

}
