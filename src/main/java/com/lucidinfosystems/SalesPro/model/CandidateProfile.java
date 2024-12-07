package com.lucidinfosystems.SalesPro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "candidate_profiles")
public class CandidateProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	private String platformName; // e.g., LinkedIn, GitHub
	private String profileUrl;
	private LocalDateTime lastSynced;
	
	@Column(columnDefinition = "TEXT")
	private String rawProfileData;
}