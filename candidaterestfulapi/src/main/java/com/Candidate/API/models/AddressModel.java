package com.Candidate.API.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="address")
public class AddressModel {
  @Id
  @GeneratedValue
  private int hno;
  private String block;
  private String lane;

}
