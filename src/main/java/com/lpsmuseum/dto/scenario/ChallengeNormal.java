/*
 * DONE: Criado ChallengeNormal para converter ChallengeNormalDO
 */
package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.dto.Scenario;

public class ChallengeNormal extends Challenge {

    public ChallengeNormal() {
    }

    public ChallengeNormal(Long id, Scenario scenario, String question, String answer) {
        super(id, scenario);
        this.question = question;
        this.answer = answer;
    }

    public ChallengeNormal(String question, String answer) {
        this.question = question;
        this.answer = answer;
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

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    private String question;
    private String answer;
}
