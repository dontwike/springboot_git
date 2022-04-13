package com.Candidate.API.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Candidate.API.models.CandidateDetailsModel;
//Primary Key of CandidateDetailsModel is id(Integer) which is annotated with @Id

@Repository
public interface CandidateDetailsRepository extends CrudRepository<CandidateDetailsModel, Integer> {

  CandidateDetailsModel findById(int id);
  CandidateDetailsModel findByAddress(String address);
}
