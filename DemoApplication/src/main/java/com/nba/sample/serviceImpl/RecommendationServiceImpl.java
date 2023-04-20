/**
 * 
 */
package com.nba.sample.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nba.sample.entity.Recommendation;
import com.nba.sample.model.RuleResponse;
import com.nba.sample.ruleengine.RuleUtil;
import com.nba.sample.service.RecommendationService;

/**
 * @author Suresh A K
 *
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {
	
	@Autowired
	RuleUtil ruleUtil;

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
					RuleResponse ruleResponse = ruleUtil.executeRule(recommendation);
					System.out.println(ruleResponse.toString());
					if (ruleResponse.getSelectedUsecase().equalsIgnoreCase("use case 1")) {
						return "Cross-Sell Umbrella";
					} else if (ruleResponse.getSelectedUsecase().equalsIgnoreCase("use case 2")) {
						return "UW Misclassification";
					} else if (ruleResponse.getSelectedUsecase().equalsIgnoreCase("use case 3")) {
						return "Differentiated Service Handling";
					}
				}
			}
		}
		return null;
	}

	public List<Recommendation> readJsonData() throws JsonParseException, JsonMappingException, IOException {
		File file = ResourceUtils.getFile("classpath:RecommendationData.json");
		// Read File Content
		String content = new String(Files.readAllBytes(file.toPath()));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(content);
		List<Recommendation> recommendationList = objectMapper.convertValue(jsonNode,
				new com.fasterxml.jackson.core.type.TypeReference<List<Recommendation>>() {
				});
		return recommendationList;
	}

}
