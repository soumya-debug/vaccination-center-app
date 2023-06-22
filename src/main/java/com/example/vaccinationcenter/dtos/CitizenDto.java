package com.example.vaccinationcenter.dtos;

import com.example.vaccinationcenter.entities.Citizen;
import com.example.vaccinationcenter.validators.antn.CitizenValidator;

@CitizenValidator
public class CitizenDto {

  private String httpMethod;

  private Long id;
  private String name;
  private String city;
  private int doesCount;
  private Long centerId;

  public String getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getDoesCount() {
    return doesCount;
  }

  public void setDoesCount(int doesCount) {
    this.doesCount = doesCount;
  }

  public Long getCenterId() {
    return centerId;
  }

  public void setCenterId(Long centerId) {
    this.centerId = centerId;
  }
}
