package com.youtube.tutorial.ecommercebackend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "web_order_entities")
@Getter
@Setter
public class WebOrderQuantities {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id" , nullable = false)
  private long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id" , nullable = false)
  private WebOrder order;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;


  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id" , nullable = false)
  private Product product;



}
