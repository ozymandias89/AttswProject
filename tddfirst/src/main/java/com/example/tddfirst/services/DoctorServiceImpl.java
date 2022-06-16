package com.example.tddfirst.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tddfirst.entities.Doctor;
import com.example.tddfirst.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorrepository;

	@Override
	public Doctor findBySurName(String surName) {
		return doctorrepository.findBySurName(surName);
	}

	@Override
	public List<Doctor> findByFirstName(String firstName) {
		return doctorrepository.findByFirstName(firstName);
		}

	@Override
	public void save(Doctor doctor) {
		doctorrepository.save(doctor);
	}

	@Override
	public void delete(Doctor doctor) {
		doctorrepository.delete(doctor);
		
	}

	@Override
	public void deleteAll() {
		doctorrepository.deleteAll();
		
	}

}
