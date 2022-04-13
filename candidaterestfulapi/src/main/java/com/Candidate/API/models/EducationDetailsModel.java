package com.Candidate.API.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="education_details")
public class EducationDetailsModel {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String qualification;
	private String cgpa;
	private String subject;
	private String specialization;
}
