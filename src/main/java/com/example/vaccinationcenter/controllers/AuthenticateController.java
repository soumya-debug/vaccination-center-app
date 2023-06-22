package com.example.vaccinationcenter.controllers;

import com.example.vaccinationcenter.dtos.LoginRequestDto;
import com.example.vaccinationcenter.dtos.LoginResponse;
import com.example.vaccinationcenter.dtos.RegistrationRequestDto;
import com.example.vaccinationcenter.entities.User;
import com.example.vaccinationcenter.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

@RestController
@RequestMapping
public class AuthenticateController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping(value = "/authenticate", produces = "application/json")
  public LoginResponse authenticate(@Valid @RequestBody LoginRequestDto loginRequest, HttpServletRequest request, HttpServletResponse response) {
    LoginResponse loginResponse = new LoginResponse();
    User user = userRepository.findByEmail(loginRequest.getEmail());
    if(user == null)
    {
      throw new RuntimeException("user not found with email: "+loginRequest.getEmail());
    }
    if(!Objects.equals(user.getPassword(), loginRequest.getPassword()))
    {
      throw new RuntimeException("password not matching with email: "+loginRequest.getEmail());
    }
    String token = Base64.getEncoder().encodeToString(user.getEmail().getBytes(StandardCharsets.UTF_8));
    loginResponse.setName(user.getName());
    loginResponse.setEncodedToken(token);
    return loginResponse;
  }

  @PostMapping(value = "/registration", produces = "application/json")
  public int register(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) {
    User user = new User();
    user.setEmail(registrationRequestDto.getEmail());
    user.setName(registrationRequestDto.getName());
    user.setPassword(registrationRequestDto.getPassword());
    if (userRepository.findByEmail(user.getEmail()) != null) {
      throw new RuntimeException("user already exists with email: " + user.getEmail());
    }
    userRepository.save(user);
    return 1;
  }

  @GetMapping(value = "/me", produces = "application/json")
  public LoginResponse me(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String authorizationHeader = request.getHeader("authorization");

    byte emailBytes[] = Base64.getDecoder().decode(authorizationHeader.getBytes(StandardCharsets.UTF_8));
    String email = new String(emailBytes);
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new RuntimeException("user not found with email: " + email);
    }

    LoginResponse loginResponse = new LoginResponse();
    loginResponse.setEmail(email);
    loginResponse.setName(user.getName());
    loginResponse.setEncodedToken(authorizationHeader);
    return loginResponse;

  }
}
