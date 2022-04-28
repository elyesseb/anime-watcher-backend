package com.simplon.safety.net.alerts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplon.safety.net.alerts.model.FireStation;
import com.simplon.safety.net.alerts.model.MedicalRecord;
import com.simplon.safety.net.alerts.model.Person;
import com.simplon.safety.net.alerts.service.FireStationService;
import com.simplon.safety.net.alerts.service.MedicalRecordService;
import com.simplon.safety.net.alerts.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    CommandLineRunner runnerPerson(PersonService personService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/persons.json");
            try {
                List<Person> persons = mapper.readValue(inputStream,typeReference);
                personService.save(persons);
                System.out.println("Persons Saved!");
            } catch (IOException e){
                System.out.println("Unable to save Persons: " + e.getMessage());
            }
        };
    }

    @Bean
    CommandLineRunner runnerFireStation(FireStationService fireStationService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<FireStation>> typeReference = new TypeReference<List<FireStation>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/firestations.json");
            try {
                List<FireStation> fireStations = mapper.readValue(inputStream,typeReference);
                fireStationService.save(fireStations);
                System.out.println("FireStations Saved!");
            } catch (IOException e){
                System.out.println("Unable to save FireStations: " + e.getMessage());
            }
        };
    }

    @Bean
    CommandLineRunner runnerMedicalRecord(MedicalRecordService medicalRecordService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<MedicalRecord>> typeReference = new TypeReference<List<MedicalRecord>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/medicalrecords.json");
            try {
                List<MedicalRecord> medicalRecords = mapper.readValue(inputStream,typeReference);
                medicalRecordService.save(medicalRecords);
                System.out.println("MedicalRecords Saved!");
            } catch (IOException e){
                System.out.println("Unable to save MedicalRecords: " + e.getMessage());
            }
        };
    }

}
