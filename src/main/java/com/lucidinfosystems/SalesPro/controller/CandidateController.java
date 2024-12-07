package com.lucidinfosystems.SalesPro.controller;

import com.lucidinfosystems.SalesPro.model.Candidate;
import com.lucidinfosystems.SalesPro.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {
	private final CandidateService candidateService;
	
	@PostMapping
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
		return ResponseEntity.ok(candidateService.createCandidateProfile(candidate));
	}
	
	@PutMapping("/{uniqueCandidateId}")
	public ResponseEntity<Candidate> updateCandidate(
			@PathVariable String uniqueCandidateId,
			@RequestBody Candidate candidate) {
		return ResponseEntity.ok(candidateService.updateCandidateProfile(uniqueCandidateId, candidate));
	}
	
	@DeleteMapping("/{uniqueCandidateId}")
	public ResponseEntity<Void> deleteCandidate(@PathVariable String uniqueCandidateId) {
		candidateService.deleteCandidateProfile(uniqueCandidateId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{uniqueCandidateId}")
	public ResponseEntity<Candidate> getCandidate(@PathVariable String uniqueCandidateId) {
		return ResponseEntity.ok(candidateService.getCandidateProfile(uniqueCandidateId));
	}
}
