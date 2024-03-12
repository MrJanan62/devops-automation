package com.youtube.tutorial.ecommercebackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id" , nullable = false)
  private long id;


  @Column(name = "address_line_1" , nullable = false, length = 512)
  private String addressLine1;


  @Column(name = "address_line_2" ,length = 512)
  private String addressLine2;


  @Column(name = "city" , nullable = false)
  private String city;


  @Column(name = "country" , nullable = false, length = 75)
  private String country;


  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id" , nullable = false)
  private LocalUser user;



}
