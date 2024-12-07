package com.lucidinfosystems.SalesPro.model;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String uniqueCandidateId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String location;
	
	@Column(columnDefinition = "TEXT")
	private String skills;
	
	private String linkedInProfileUrl;
	private String linkedInUid;
	
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	private Set<CandidateProfile> profiles = new HashSet<>();
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}

