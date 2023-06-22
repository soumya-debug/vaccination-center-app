package com.example.vaccinationcenter.dtos;

import com.example.vaccinationcenter.validators.antn.RegistrationRequestValidator;

@RegistrationRequestValidator
public class RegistrationRequestDto extends LoginRequestDto {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
