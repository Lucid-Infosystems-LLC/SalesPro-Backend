package com.lucidinfosystems.SalesPro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "market_trends")
public class MarketTrend {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String trendName;
	private String category;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private Double confidence;
	private LocalDateTime predictedFor;
	private LocalDateTime createdAt;
	
	@Column(columnDefinition = "TEXT")
	private String aiAnalysis;
}