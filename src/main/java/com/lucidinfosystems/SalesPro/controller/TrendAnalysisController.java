package com.lucidinfosystems.SalesPro.controller;

import com.lucidinfosystems.SalesPro.model.MarketTrend;
import com.lucidinfosystems.SalesPro.service.TrendAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/trends")
@RequiredArgsConstructor
public class TrendAnalysisController {
	private final TrendAnalysisService trendService;
	
	@PostMapping("/{category}")
	public ResponseEntity<MarketTrend> generateTrend(@PathVariable String category) {
		return ResponseEntity.ok(trendService.generateTrend(category));
	}
	
	@GetMapping("/projections")
	public ResponseEntity<List<MarketTrend>> projectTrends(
			@RequestParam String category,
			@RequestParam LocalDateTime startDate,
			@RequestParam LocalDateTime endDate) {
		return ResponseEntity.ok(trendService.projectTrends(category, startDate, endDate));
	}
}
