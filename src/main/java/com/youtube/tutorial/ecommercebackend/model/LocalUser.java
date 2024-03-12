package com.youtube.tutorial.ecommercebackend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="local_user")
@Getter
@Setter
public class LocalUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id" , nullable = false)
  private long id;


  @Column(name = "username" , nullable = false, unique = true)
  private String username;


  @Column(name = "password" , nullable = false,length = 1000)
  private String password;


  @Column(name = "first_name" , nullable = false)
  private String firstName;


  @Column(name = "last_name" , nullable = false)
  private String lastName;


  @Column(name = "email" , nullable = false, length = 320, unique = true)
  private String email;

  @OneToMany(mappedBy = "user" , cascade = CascadeType.REMOVE , orphanRemoval = true)
  private List<Address> addresses = new ArrayList<>();



}
