package com.example.vaccinationcenter.repository;

import com.example.vaccinationcenter.entities.Citizen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen,Long> {

  public List<Citizen> findAllByCenterId(long centerId);
}
