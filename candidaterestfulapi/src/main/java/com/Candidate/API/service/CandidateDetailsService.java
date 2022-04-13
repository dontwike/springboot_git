package com.Candidate.API.service;

import java.util.List;

import com.Candidate.API.models.CandidateDetailsModel;
import com.Candidate.API.repository.CandidateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service annotation tells that this class is for Business Logic
@Service
public class CandidateDetailsService {

	//@Autowired annotation makes Object in Spring IOC Container
    @Autowired
	CandidateDetailsRepository candidateDetailsRepository;
	
	public CandidateDetailsModel saveCandidateDetails(CandidateDetailsModel candidateDetailsModel) {
		return candidateDetailsRepository.save(candidateDetailsModel);
	}

	public List<CandidateDetailsModel> getAllCandidateDetails() {
		return (List<CandidateDetailsModel>)candidateDetailsRepository.findAll();
	}

	public CandidateDetailsModel getCandidateDetailsById(int id) {
		return candidateDetailsRepository.findById(id);
	}

	public CandidateDetailsModel getCandidateDetailsByAddress(String address) {
		return candidateDetailsRepository.findByAddress(address);
	}

	public CandidateDetailsModel updateCandidateDetails(CandidateDetailsModel candidateDetailsModel) {
		return candidateDetailsRepository.save(candidateDetailsModel);
		//for update, we use .save() function.
	}

	public void deleteCandidateDetailsById(int id) {
		candidateDetailsRepository.deleteById(id);
	}

	public void deleteAllCandidateDetails() {
		candidateDetailsRepository.deleteAll();
		
	}

}
