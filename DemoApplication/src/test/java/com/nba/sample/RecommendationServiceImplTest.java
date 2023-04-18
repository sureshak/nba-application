package com.nba.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nba.sample.entity.Recommendation;
import com.nba.sample.serviceImpl.RecommendationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceImplTest {
	
	@InjectMocks
	RecommendationServiceImpl recommendationServiceImpl;
	
	@Test
	public void recommendationServiceImplTest() {
		List<Recommendation> recommendationList = new ArrayList<>();
		Recommendation recommendation = new Recommendation();
		recommendation.setCustomerId("001");
		recommendation.setUsecaseOne("Y");
		recommendation.setUsecaseTwo("N");
		recommendation.setUsecaseThree("N");
		recommendationList.add(recommendation);
		try { 
			Object response = recommendationServiceImpl.getRecommendation("001");
			assertThat(response.toString()).isEqualTo("Cross-Sell Umbrella");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
