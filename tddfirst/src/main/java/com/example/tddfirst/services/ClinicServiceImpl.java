package com.example.tddfirst.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tddfirst.entities.Clinic;
import com.example.tddfirst.repository.ClinicRepository;

@Service
public class ClinicServiceImpl implements ClinicService {
	@Autowired
	ClinicRepository clinicrepository;

	@Override
	public Clinic findByFirstName(String firstName) {
		return clinicrepository.findByFirstName(firstName);
		}

	@Override
	public void save(Clinic clinic) {
		clinicrepository.save(clinic);
	}

	@Override
	public void delete(Clinic clinic) {
		clinicrepository.delete(clinic);
		
	}

}
