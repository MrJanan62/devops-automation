package com.youtube.tutorial.ecommercebackend.api.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationBody {

  @NotNull
  @NotBlank
  private String username;

  @NotNull
  @NotBlank
  private String email;

  @NotNull
  @NotBlank
  private String password;

  @NotNull
  @NotBlank
  private String firstName;

  @NotNull
  @NotBlank
  private String lastName;

}
