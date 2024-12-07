package com.lucidinfosystems.SalesPro.controller;

import com.lucidinfosystems.SalesPro.service.LinkedInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/linkedin")
@RequiredArgsConstructor
public class LinkedInController {
	private final LinkedInService linkedInService;
	
	@GetMapping("/uid")
	public ResponseEntity<String> getLinkedInUID(@RequestParam String profileUrl) {
		return ResponseEntity.ok(linkedInService.getCandidateLinkedInUID(profileUrl));
	}
	
	@PostMapping("/sync/{candidateId}")
	public ResponseEntity<Void> syncLinkedInProfile(@PathVariable Long candidateId) {
		//TODO: Implementation to sync LinkedIn profile
		return ResponseEntity.ok().build();
	}
}