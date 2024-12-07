package com.lucidinfosystems.SalesPro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "recruitment_activities")
public class RecruitmentActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	private String activityType;
	private String status;
	private LocalDateTime scheduledAt;
	private String notes;
	private LocalDateTime createdAt;
	private String createdBy;
}