/**
 * 
 */
package com.nba.sample.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nba.sample.entity.Recommendation;
import com.nba.sample.service.RecommendationService;

/**
 * @author Suresh A K
 *
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Override
	public Object getRecommendation(String customerId) {
		List<Recommendation> result = new ArrayList<>();
		try {
			result = readJsonData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null) {
			for (Recommendation recommendation : result) {
				if (customerId.equalsIgnoreCase(recommendation.getCustomerId())) {
					if (recommendation.getUsecaseOne().equalsIgnoreCase("Y")) {
						return "Cross-Sell Umbrella";
					} else if (recommendation.getUsecaseTwo().equalsIgnoreCase("Y")) {
						return "UW Misclassification";
					} else if (recommendation.getUsecaseThree().equalsIgnoreCase("Y")) {
						return "Differentiated Service Handling";
					}
				}
			}
		}
		return null;
	}

	private List<Recommendation> readJsonData() throws JsonParseException, JsonMappingException, IOException {
		File file = ResourceUtils.getFile("classpath:RecommendationData.json");
		// Read File Content
		String content = new String(Files.readAllBytes(file.toPath()));
		System.out.println(content);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(content);
		List<Recommendation> recommendationList = objectMapper.convertValue(jsonNode,
				new com.fasterxml.jackson.core.type.TypeReference<List<Recommendation>>() {
				});
		return recommendationList;
	}

}
