package com.nba.sample.ruleengine;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nba.sample.entity.Recommendation;
import com.nba.sample.model.RuleResponse;

@Service
public class RuleUtil {	
	
	@Autowired
	KieContainer kieContainer;
	
	public RuleResponse executeRule(Recommendation recommendation) {
		RuleResponse ruleResponse = new RuleResponse();
	    KieSession kieSession = kieContainer.newKieSession();
	    kieSession.setGlobal("ruleResponse", ruleResponse);
	    kieSession.insert(recommendation);
	    kieSession.fireAllRules();
	    kieSession.dispose();
	    return ruleResponse;
	}
}


