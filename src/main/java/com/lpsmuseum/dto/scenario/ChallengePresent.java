/*
 * DONE: Criado ChallengePresent para converter ChallengeNormalDO
 */
package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.dto.Scenario;
import java.util.List;

public class ChallengePresent extends Challenge {

    public ChallengePresent() {
    }

    public ChallengePresent(Long id, Scenario scenario, String question, String answer, List<String> alternatives) {
        super(id, scenario);
        this.question = question;
        this.answer = answer;
        this.alternatives = alternatives;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    private String question;
    private String answer;
    private List<String> alternatives;
}
