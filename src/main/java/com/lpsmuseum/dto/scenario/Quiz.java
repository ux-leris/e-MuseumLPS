package com.lpsmuseum.dto.scenario;

import java.util.ArrayList;
import java.util.List;

import com.lpsmuseum.dto.scenario.challenge.Question;

public class Quiz extends Question {
	
	public Quiz(Long id, String enunciation) {
		super(id, enunciation);
		// TODO Auto-generated constructor stub
	}

	private List<String> alternatives = new ArrayList<String>();

	public List<String> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<String> alternatives) {
		this.alternatives = alternatives;
	}
	
	public void addAlternative(String alternative) {
		alternatives.add(alternative);
	}
	
	public boolean removeAlternative(String alternative) {
		return alternatives.remove(alternative);
	}
	
	public boolean checkAnswer() {
		String answer = "";// getAnswer();
		for (String alternative : alternatives)
			if (alternative.equals(answer))
				return true;
		return false;
	}

}
