package com.lucidinfosystems.SalesPro.service;

import com.lucidinfosystems.SalesPro.model.Candidate;
import com.lucidinfosystems.SalesPro.repository.CandidateProfileRepository;
import com.lucidinfosystems.SalesPro.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CandidateService {
	private final CandidateRepository candidateRepository;
	private final CandidateProfileRepository profileRepository;
	private final LinkedInService linkedInService;
	private final EmailService emailService;
	
	@Transactional
	public Candidate createCandidateProfile(Candidate candidate) {
		candidate.setUniqueCandidateId(generateUniqueCandidateId());
		Candidate savedCandidate = candidateRepository.save(candidate);
		emailService.sendCandidateId(savedCandidate.getEmail(), savedCandidate.getUniqueCandidateId());
		return savedCandidate;
	}
	
	@Transactional
	public Candidate updateCandidateProfile(String uniqueCandidateId, Candidate updatedCandidate) {
		Candidate existing = candidateRepository.findByUniqueCandidateId(uniqueCandidateId)
				.orElseThrow(() -> new RuntimeException("Candidate not found"));
		
		// Update fields
		existing.setFirstName(updatedCandidate.getFirstName());
		existing.setLastName(updatedCandidate.getLastName());
		existing.setEmail(updatedCandidate.getEmail());
		existing.setPhone(updatedCandidate.getPhone());
		existing.setLocation(updatedCandidate.getLocation());
		existing.setSkills(updatedCandidate.getSkills());
		
		return candidateRepository.save(existing);
	}
	
	@Transactional
	public void deleteCandidateProfile(String uniqueCandidateId) {
		Candidate candidate = candidateRepository.findByUniqueCandidateId(uniqueCandidateId)
				.orElseThrow(() -> new RuntimeException("Candidate not found"));
		candidateRepository.delete(candidate);
	}
	
	public Candidate getCandidateProfile(String uniqueCandidateId) {
		return candidateRepository.findByUniqueCandidateId(uniqueCandidateId)
				.orElseThrow(() -> new RuntimeException("Candidate not found"));
	}
	
	private String generateUniqueCandidateId() {
		return "CAND-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
}
