package com.example.vaccinationcenter.controllers;

import com.example.vaccinationcenter.dtos.VaccinationCenterDto;
import com.example.vaccinationcenter.entities.VaccinationCenter;
import com.example.vaccinationcenter.services.VaccinationCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "vaccinationcenter", produces = "application/json")
public class VaccinationCenterController {

  @Autowired
  private VaccinationCenterService vaccinationCenterService;

  @GetMapping("/{id}")
  public VaccinationCenter findVaccinationCenter(@PathVariable long id) {
    return vaccinationCenterService.getVaccinationCenter(id);
  }
  @DeleteMapping("/{id}")
  public boolean deleteVaccinationCenter(@PathVariable long id) {
    return vaccinationCenterService.delete(id);
  }

  @GetMapping()
  public List<VaccinationCenter> findVaccinationCenters() {
    return vaccinationCenterService.getVaccinationCenters();
  }

  @PostMapping
  public VaccinationCenter addNewVaccinationCenter(@Valid @RequestBody VaccinationCenterDto vaccinationCenterDto) {

    VaccinationCenter vaccinationCenter = new VaccinationCenter();
    vaccinationCenter.setName(vaccinationCenterDto.getName());
    vaccinationCenter.setAddress(vaccinationCenterDto.getCity());
    return vaccinationCenterService.addOrUpdate(vaccinationCenter);
  }

  @PutMapping
  public VaccinationCenter updateVaccinationCenter(@Valid @RequestBody VaccinationCenterDto vaccinationCenterDto) {
    VaccinationCenter vaccinationCenter = vaccinationCenterService.
        getVaccinationCenter(vaccinationCenterDto.getId());
    vaccinationCenter.setName(vaccinationCenterDto.getName());
    vaccinationCenter.setAddress(vaccinationCenterDto.getCity());
    return vaccinationCenterService.addOrUpdate(vaccinationCenter);
  }
}
