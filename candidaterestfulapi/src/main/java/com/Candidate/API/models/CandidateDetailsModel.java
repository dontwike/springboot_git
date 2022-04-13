package com.Candidate.API.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CandidateDetailsModel {

	//The below 2 annotations are used to make id as Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    private String firstName;
    private String lastName;
    private String ph;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressModel address;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private List<EducationDetailsModel> educationDetails = new ArrayList<EducationDetailsModel>();
}
