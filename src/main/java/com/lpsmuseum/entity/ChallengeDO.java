	package com.lpsmuseum.entity;

import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.Answer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "challenge")
@Inheritance
@SuppressWarnings("serial")
public class ChallengeDO implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_challenge")
    private Long id;
    
    @Column(name = "description")
    private String description;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="challenge_answer", joinColumns={@JoinColumn(name="id_challenge")}, inverseJoinColumns={@JoinColumn(name="id_answer")})
	private List<AnswerDO> answers;
	
	@OneToOne
	@JoinColumn(name = "id_challenge")
    private AnswerDO correctAnswer;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public List<AnswerDO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDO> answers) {
		this.answers = answers;
	}

	public AnswerDO getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(AnswerDO correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
    
    public Challenge getDto() {
        Challenge c = new Challenge();
        c.setChallengeId(id);
        c.setDescription(getDescription());
		List<Answer> challengeItems = new ArrayList<Answer>();
		for (AnswerDO answer : answers)
			challengeItems.add(answer.getDto());
		c.setAnswers(challengeItems);
		if (getCorrectAnswer() != null )c.setCorrectAnswer(getCorrectAnswer().getDto());
        return c;
    }
}
