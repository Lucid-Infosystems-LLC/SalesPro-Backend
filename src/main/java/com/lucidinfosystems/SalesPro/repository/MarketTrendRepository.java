package com.lucidinfosystems.SalesPro.repository;

import com.lucidinfosystems.SalesPro.model.MarketTrend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MarketTrendRepository extends JpaRepository<MarketTrend, Long> {
	List<MarketTrend> findByCategory(String category);
	List<MarketTrend> findByPredictedForBetween(LocalDateTime start, LocalDateTime end);
	List<MarketTrend> findByConfidenceGreaterThanEqual(Double confidenceThreshold);
}
