package com.nba.sample.service;

import com.nba.sample.model.RecommendationResponse;

/**
 * @author Suresh A K
 *
 */
public interface RecommendationService {
	
	RecommendationResponse getRecommendation(String customerId);

}
