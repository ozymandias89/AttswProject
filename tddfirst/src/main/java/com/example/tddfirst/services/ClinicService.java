package com.example.tddfirst.services;

import com.example.tddfirst.entities.Clinic;

public interface ClinicService {


	Clinic findByFirstName(String firstName); //

	void save(Clinic clinic);

	void delete(Clinic clinic);

}
