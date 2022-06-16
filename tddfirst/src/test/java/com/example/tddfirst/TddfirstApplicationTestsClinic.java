package com.example.tddfirst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tddfirst.entities.Clinic;
import com.example.tddfirst.repository.ClinicRepository;
@SpringBootTest
class TddfirstApplicationTestsClinic {
    @Autowired
    private ClinicRepository clinicServiceRepository;

    @BeforeEach																		//annotazione che dice al framework spring di eseguire ogni volta che deve eseguire un test di unità "prima di eseguire questo test esegui contentload"
    void contextLoads() {
        clinicServiceRepository.deleteAll();
    }

    @Test
    public void ClinicInsert() {
        clinicServiceRepository.save(new Clinic("Radiology"));
        assertEquals("Radiology", clinicServiceRepository.findByFirstName("Radiology").getFirstName());
    }

    @Test
    public void ClinicModify() {
        clinicServiceRepository.save(new Clinic("Radiology"));
        assertEquals("Radiology", clinicServiceRepository.findByFirstName("Radiology").getFirstName());
        Clinic clinic = clinicServiceRepository.findByFirstName("Radiology");
        clinic.setFirstName("Cardiology");
        clinicServiceRepository.save(clinic);
        assertEquals("Cardiology", clinicServiceRepository.findByFirstName("Cardiology").getFirstName());
    }

    @Test
    public void ClinicDelete() {
        clinicServiceRepository.save(new Clinic("Radiology"));
        Clinic clinic= clinicServiceRepository.findByFirstName("Radiology");
        clinicServiceRepository.delete(clinic);
        assertNull(clinicServiceRepository.findByFirstName("Radiology"));							//il test sarà corretto solo se passerà l'assertNull (non ci dovrà essere nessun dottore all'interno del repository con il cognome richiesto)
    }

    

}
