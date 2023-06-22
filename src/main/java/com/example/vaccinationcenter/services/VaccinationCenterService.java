package com.example.vaccinationcenter.services;

import com.example.vaccinationcenter.entities.Citizen;
import com.example.vaccinationcenter.entities.VaccinationCenter;
import com.example.vaccinationcenter.repository.CitizenRepository;
import com.example.vaccinationcenter.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VaccinationCenterService {

  @Autowired
  private VaccinationCenterRepository vaccinationCenterRepository;

  @Autowired
  private CitizenRepository citizenRepository;

  public VaccinationCenter addOrUpdate(VaccinationCenter center) {
    return vaccinationCenterRepository.save(center);
  }

  public List<VaccinationCenter> getVaccinationCenters() {

    List<VaccinationCenter> vaccinationCenters = StreamSupport.stream(vaccinationCenterRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());

    return vaccinationCenters;

  }

  public boolean delete(long id){
    VaccinationCenter vaccinationCenter = vaccinationCenterRepository.findById(id).get();

    List<Citizen> citizenList = citizenRepository.findAllByCenterId(id);
    citizenList.forEach(e->{
      e.setCenter(null);
      citizenRepository.save(e);
    });

    vaccinationCenterRepository.delete(vaccinationCenter);
    return true;
  }
  public VaccinationCenter getVaccinationCenter(long id) {
    return vaccinationCenterRepository.findById(id).get();
  }
}
