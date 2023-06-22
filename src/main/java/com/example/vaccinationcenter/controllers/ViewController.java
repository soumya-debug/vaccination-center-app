package com.example.vaccinationcenter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {


  @GetMapping("citizens")
  public String citizensPage() {
    return "citizens";
  }

  @GetMapping("citizens/{id}")
  public String citizensPage(@PathVariable int id, Model model) {
    model.addAttribute("id", id);
    return "view_citizen";
  }


  @GetMapping("citizens/center/{id}")
  public String citizensPageByCenterId(@PathVariable int id, Model model) {
    model.addAttribute("id", id);
    return "citizen_center";
  }

  @GetMapping("vaccinationcenter/{id}")
  public String vaccinationcenterByCenterId(@PathVariable int id, Model model) {
    model.addAttribute("id", id);
    return "citizen_center";
  }

  @GetMapping("vaccinationcenter")
  public String vaccinationCenterPage() {
    return "vaccination_center";
  }

  @GetMapping(value = {"/","/login"})
  public String loginPage() {
    return "login";
  }

  @GetMapping("/register")
  public String registrationPage() {
    return "register";
  }



}
