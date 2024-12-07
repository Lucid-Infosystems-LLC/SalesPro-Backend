package com.lucidinfosystems.SalesPro.repository;

import com.lucidinfosystems.SalesPro.model.Candidate;
import com.lucidinfosystems.SalesPro.model.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Long> {
	List<CandidateProfile> findByCandidate(Candidate candidate);
	Optional<CandidateProfile> findByCandidateAndPlatformName(Candidate candidate, String platformName);
	List<CandidateProfile> findByLastSyncedBefore(LocalDateTime date);
}