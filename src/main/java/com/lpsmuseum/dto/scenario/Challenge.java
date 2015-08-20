package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.ChallengeDO;

public class Challenge {

    private Long challengeId;
    private Scenario scenario;
    private String answer;
    private String description;
    
    public Challenge() {
    }
    
    public Challenge(Long challengeId, Scenario scenario) {
        this.challengeId = challengeId;
        this.scenario = scenario;
    }
        
    public void getResults() {

    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChallengeDO getEntity() throws Exception {
        ChallengeDO challengeDO = new ChallengeDO();
        
        challengeDO.setAnswer(getAnswer());
        challengeDO.setDescription(getDescription());
        challengeDO.setScenario(getScenario().getEntity());
        challengeDO.setId(getChallengeId());

        return challengeDO;
    }
}
