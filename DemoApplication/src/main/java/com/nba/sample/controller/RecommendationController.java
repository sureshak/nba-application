package com.nba.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nba.sample.model.RecommendationResponse;
import com.nba.sample.service.RecommendationService;

/**
 * @author suresh A K
 * @version 1.0.0
 *
 */
@RestController
public class RecommendationController {
	
	@Autowired
	RecommendationService recommendationService;
	
	@GetMapping(value="/recommendation/{customerId}")
	public ResponseEntity<RecommendationResponse> getRecommendation(@PathVariable String customerId) {
		System.out.println("test command");
		return new ResponseEntity<>(recommendationService.getRecommendation(customerId), HttpStatus.OK);
	}

}
