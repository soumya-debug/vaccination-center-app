package com.example.vaccinationcenter.repository;

import com.example.vaccinationcenter.entities.Citizen;
import com.example.vaccinationcenter.entities.VaccinationCenter;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationCenterRepository extends CrudRepository<VaccinationCenter,Long> {
}
