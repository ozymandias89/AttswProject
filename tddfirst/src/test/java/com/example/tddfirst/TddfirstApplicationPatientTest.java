package com.example.tddfirst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tddfirst.entities.Patient;
import com.example.tddfirst.services.PatientService;

@SpringBootTest
class TddfirstApplicationPatientTest {
    @Autowired
    private PatientService patientService;   // classe bean istanziata con nome oggetto repository
    
  
    

    @BeforeEach
    void contextLoads() {
		patientService.deleteAll();
    }

    @Test
    public void PatientInsert() {
        patientService.save(new Patient("Orazio", "Picentini", 5));
        assertEquals("Orazio", patientService.findBySurName("Picentini").firstName);	// trova i pazienti con nome Orazio
        assertEquals("Picentini", patientService.findBySurName("Picentini").surName);	// trova i pazienti con cognome "Picentini
        assertEquals(5, patientService.findBySurName("Picentini").vacancyDays);			// trova i pazienti con giorni di riposo 5
    }

    @Test
    public void PatientModify() {
		patientService.save(new Patient("Orazio", "Picentini", 5));
        Patient patient = patientService.findBySurName("Picentini");					// accedo al repository e chiedo entita paziente
        patient.setVacancyDays(6);													// setto il valore del paziente e lo modifico
        patientService.save(patient);
		patient = patientService.findBySurName("Picentini");
		assertEquals(6, patient.getVacancyDays());
    }
    
    @Test
    public void PatientModifySetFirstName() {
		patientService.save(new Patient("Orazio", "Picentini", 5));
        Patient patient = patientService.findBySurName("Picentini");
        patient.setFirstName("Claudio");
        patient.setSurName("Gottardo");
		assertEquals("Claudio", patient.getFirstName());
		assertEquals("Gottardo", patient.getSurName());
    }
    
    @Test
    public void PatientDelete() {
		patientService.save(new Patient("Orazio", "Picentini", 5));
		Patient patient = patientService.findBySurName("Picentini");
		patientService.delete(patient);													//delete patient
		assertNull(patientService.findBySurName("Picentini"));							//assert null in quanto l'ho cancellato precedentemente

    }

}
