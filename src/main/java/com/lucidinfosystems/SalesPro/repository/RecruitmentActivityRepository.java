package com.lucidinfosystems.SalesPro.repository;

import com.lucidinfosystems.SalesPro.model.Candidate;
import com.lucidinfosystems.SalesPro.model.RecruitmentActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecruitmentActivityRepository extends JpaRepository<RecruitmentActivity, Long> {
	List<RecruitmentActivity> findByCandidate(Candidate candidate);
	List<RecruitmentActivity> findByActivityTypeAndStatus(String activityType, String status);
	List<RecruitmentActivity> findByScheduledAtBetween(LocalDateTime start, LocalDateTime end);
}
