package com.Candidate.API.controller;

import java.util.List;

import com.Candidate.API.models.CandidateDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Candidate.API.service.CandidateDetailsService;

@RestController
@RequestMapping(value="/api")
public class CandidateDetailsController {

	@Autowired
	CandidateDetailsService candidateDetailsService;
	@PostMapping("/candidateDetails")
	public CandidateDetailsModel saveCandidateDetails(@RequestBody CandidateDetailsModel candidateDetailsModel) {
		/**
		 * @RequestBody : The data we get is in Jason format,
		 * so this annotation converts it into the
		 * from of CandidateDetailsModel's java object format.
		 * */
		CandidateDetailsModel candDetails =candidateDetailsService.saveCandidateDetails(candidateDetailsModel);
		return candDetails;
		
	}
	
	@GetMapping("/getAllCandidateDetails")
	public List<CandidateDetailsModel> getAllCandidateDetails(){
		List<CandidateDetailsModel> candDetails=candidateDetailsService.getAllCandidateDetails();
		return candDetails;
		
	}
	
	@GetMapping("/getCandidateDetailsById/{id}")
	public CandidateDetailsModel getCandidateDetailsById(@PathVariable int id) {
		CandidateDetailsModel candDetails=candidateDetailsService.getCandidateDetailsById(id);
		return candDetails;
		
	}
	@GetMapping("/getCandidateDetailsByAddress/{address}")
	public CandidateDetailsModel getCandidateDetailsByAddress(@PathVariable String address) {
		CandidateDetailsModel candDetails=candidateDetailsService.getCandidateDetailsByAddress(address);
		return candDetails;
	}
	
	@PutMapping("/updateCandidateDetails")
	public CandidateDetailsModel updateCandidateDetails(@RequestBody CandidateDetailsModel candidateDetailsModel) {
		CandidateDetailsModel candDetails = candidateDetailsService.updateCandidateDetails(candidateDetailsModel);
		return candDetails;
	}
	
	@DeleteMapping("/deleteCandidateDetails/{id}")
	public void deleteCandidateDetailsById(@PathVariable int id) {
		candidateDetailsService.deleteCandidateDetailsById(id);
	}
	
	@DeleteMapping("/deleteAllCandidateDetails")
	public void deleteAllCandidateDetails() {
		candidateDetailsService.deleteAllCandidateDetails();
	}
	
}
                                 