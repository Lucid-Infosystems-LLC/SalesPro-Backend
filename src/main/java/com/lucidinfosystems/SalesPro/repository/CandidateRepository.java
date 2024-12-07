package com.lucidinfosystems.SalesPro.repository;

import com.lucidinfosystems.SalesPro.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	Optional<Candidate> findByUniqueCandidateId(String uniqueCandidateId);
	Optional<Candidate> findByEmail(String email);
	Optional<Candidate> findByLinkedInUid(String linkedInUid);
	List<Candidate> findBySkillsContainingIgnoreCase(String skill);
	
	@Query("SELECT c FROM Candidate c WHERE " +
			"LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
			"LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
			"LOWER(c.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
			"LOWER(c.skills) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
	List<Candidate> searchCandidates(String searchTerm);
}
