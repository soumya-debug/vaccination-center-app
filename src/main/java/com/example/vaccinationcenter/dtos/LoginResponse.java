package com.example.vaccinationcenter.dtos;

public class LoginResponse {

  private String email;
  private String name;
  private String encodedToken;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEncodedToken() {
    return encodedToken;
  }

  public void setEncodedToken(String encodedToken) {
    this.encodedToken = encodedToken;
  }
}
