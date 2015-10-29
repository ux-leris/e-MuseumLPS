package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.entity.ChallengeDO;
import com.lpsmuseum.entity.AnswerDO;
import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private Long challengeId;
    private Scenario scenario;
    private String description;
	private List<Answer> answers;
	private Answer correctAnswer;
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

    public ChallengeDO getEntity() throws Exception {
        ChallengeDO challengeDO = new ChallengeDO();
        
        challengeDO.setCorrectAnswer(getCorrectAnswer().getEntity());
		List<AnswerDO> challengeItems = new ArrayList<AnswerDO>();
		for (Answer answer : answers)
			challengeItems.add(answer.getEntity());
		challengeDO.setAnswers(challengeItems);
        challengeDO.setDescription(getDescription());
        challengeDO.setScenario(getScenario().getEntity());
        challengeDO.setId(getChallengeId());

        return challengeDO;
    }
}
