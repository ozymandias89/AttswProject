package com.example.tddfirst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tddfirst.entities.Clinic;
import com.example.tddfirst.entities.Doctor;
import com.example.tddfirst.repository.ClinicRepository;
import com.example.tddfirst.services.ClinicService;
import com.example.tddfirst.services.DoctorServiceImpl;
@SpringBootTest
class TddfirstApplicationClinicTest {
    @Autowired
    private ClinicRepository clinicServiceRepository;
    @Autowired
    private ClinicService clinicServiceServiceImpl;

    @BeforeEach																		//annotazione che dice al framework spring di eseguire ogni volta che deve eseguire un test di unità "prima di eseguire questo test esegui contentload"
    void contextLoads() {
        clinicServiceRepository.deleteAll();
    }

    @Test
    void ClinicInsert() {
        clinicServiceServiceImpl.save(new Clinic("Radiology"));
        assertEquals("Radiology", clinicServiceServiceImpl.findByFirstName("Radiology").getFirstName());
    }
    
    @Test
    void getId () {
    	
    }
    
    @Test
    void insertDoctor() {
        clinicServiceServiceImpl.save(new Clinic("Radiology"));
        Clinic clinic = clinicServiceServiceImpl.findByFirstName("Radiology");
        clinic.insertDoctor(new Doctor("Ugo","Sghella"));
        assertEquals(1, clinic.getDoctor().size());
        Doctor doctor = clinic.getDoctor().get(0);
        assertTrue(doctor.toString().contains(""));
    }
    
    @Test
    void removeDoctor() {
    	//CREAZIONE E INSERIMENTO
    	clinicServiceServiceImpl.save(new Clinic("Radiology"));
        Clinic clinic= clinicServiceServiceImpl.findByFirstName("Radiology");
        clinic.insertDoctor(new Doctor ("Ugo", "Sghella"));
        
        //RECUPERO DOTTORE E SUA CANCELLAZIONE
        Doctor doctor = clinic.getDoctor().get(0);
        clinic.removeDoctor(doctor.getId());
        
        //ASSERT
        assertEquals(0, clinic.getDoctor().size());
    }


    @Test
    void ClinicModify() {
        clinicServiceServiceImpl.save(new Clinic("Radiology"));
        assertEquals("Radiology", clinicServiceServiceImpl.findByFirstName("Radiology").getFirstName());
        Clinic clinic = clinicServiceServiceImpl.findByFirstName("Radiology");
        clinic.setFirstName("Cardiology");
        clinicServiceServiceImpl.save(clinic);
        assertEquals("Cardiology", clinicServiceServiceImpl.findByFirstName("Cardiology").getFirstName());
    }

    @Test
    void ClinicDelete() {
        clinicServiceServiceImpl.save(new Clinic("Radiology"));
        Clinic clinic= clinicServiceServiceImpl.findByFirstName("Radiology");
        clinicServiceServiceImpl.delete(clinic);
        assertNull(clinicServiceServiceImpl.findByFirstName("Radiology"));							//il test sarà corretto solo se passerà l'assertNull (non ci dovrà essere nessun dottore all'interno del repository con il cognome richiesto)
    }

    

}
