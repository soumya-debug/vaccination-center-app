package com.example.vaccinationcenter;

import com.example.vaccinationcenter.entities.Citizen;
import com.example.vaccinationcenter.entities.VaccinationCenter;
import com.example.vaccinationcenter.repository.CitizenRepository;
import com.example.vaccinationcenter.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccinationCenterApplication implements CommandLineRunner {

	@Autowired
	private CitizenRepository citizenRepository;

	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepository;

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Citizen citizen = new Citizen();
		citizen.setCity("CITY_1");
		citizen.setName("NAME_1");

		citizenRepository.save(citizen);

		VaccinationCenter vc = new VaccinationCenter();
		vc.setName("CLINIC_1");
		vc.setAddress("BLR1");

		vaccinationCenterRepository.save(vc);

		citizen.setCenter(vc);

		citizenRepository.save(citizen);
	}
}
