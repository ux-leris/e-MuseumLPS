package com.lpsmuseum.entity;

import com.lpsmuseum.dto.scenario.Challenge;
import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    @JoinColumn(name = "id_scenario")
    private ScenarioDO scenario;
    
    @Column(name = "answer")
    private String answer;
    
    @Column(name = "description")
    private String description;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public ScenarioDO getScenario() {
        return scenario;
    }
    
    public void setScenario(ScenarioDO scenario) {
        this.scenario = scenario;
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
    
    public Challenge getDto() {
        Challenge c = new Challenge();
        c.setChallengeId(id);
        c.setScenario(getScenario().getDto());
        c.setAnswer(getAnswer());
        c.setDescription(getDescription());
        return c;
    }
}
