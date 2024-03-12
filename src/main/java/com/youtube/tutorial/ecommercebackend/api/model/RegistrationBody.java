package com.youtube.tutorial.ecommercebackend.api.model;


import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationBody {

  private String username;
  private String email;
  private String password;
  private String firstName;
  private String lastName;


}
