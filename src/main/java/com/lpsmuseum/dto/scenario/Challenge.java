package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.entity.ChallengeDO;
import com.lpsmuseum.entity.AnswerDO;
import java.util.ArrayList;
import java.util.List;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;

public class Challenge {

	private Long challengeId;
	private String description;
	private List<Answer> answers;

	public Challenge() {
	}

	public Challenge(Long challengeId) {
		this.challengeId = challengeId;
	}

	public void getResults() {

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

	public ChallengeDO getEntity() throws Exception {
		ChallengeDO challengeDO = new ChallengeDO();

		List<AnswerDO> challengeItems = new ArrayList<AnswerDO>();
		for (Answer answer : answers) {
			challengeItems.add(answer.getEntity());
		}
		challengeDO.setAnswers(challengeItems);
		challengeDO.setDescription(description);
		challengeDO.setId(challengeId);

		return challengeDO;
	}
}
