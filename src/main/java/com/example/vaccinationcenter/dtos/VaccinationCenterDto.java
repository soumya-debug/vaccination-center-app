package com.example.vaccinationcenter.dtos;

import com.example.vaccinationcenter.validators.antn.VaccinationCenterValidator;

@VaccinationCenterValidator
public class VaccinationCenterDto {

  private String httpMethod;
  private Long id;

  private String name;
  private String city;

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
}
