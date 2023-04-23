package com.nba.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.nba.sample.controller.RecommendationController;
import com.nba.sample.model.RecommendationResponse;
import com.nba.sample.service.RecommendationService;

@ExtendWith(MockitoExtension.class)
public class RecommendationControllerTest {

	@InjectMocks
	RecommendationController recommendationController;
	
	@Mock
	RecommendationService recommendationService;
	

	@Test
	public void testGetRecommendation() {
		RecommendationResponse recommendationResponse=new RecommendationResponse();
		recommendationResponse.setMessage("test data");	
		when(recommendationService.getRecommendation(anyString())).thenReturn(recommendationResponse);
		ResponseEntity<RecommendationResponse> responseEntity = recommendationController.getRecommendation("1234");
		assertThat(responseEntity.getBody().getMessage()).isEqualTo("test data");
	}
}
