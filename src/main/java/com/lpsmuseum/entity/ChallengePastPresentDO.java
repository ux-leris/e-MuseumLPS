/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.entity;

import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Luis Eduardo
 */
@Entity
@Table(name="challenge_pastpresent")
@SuppressWarnings("serial")
public class ChallengePastPresentDO extends ChallengeDO {    
    
    @ManyToOne(fetch=FetchType.EAGER)
    //@JoinColumn(name="id_object")
    @JoinColumn(name="id_objectquestion", referencedColumnName="id_object")
    private ImageDO imageQuestion;
    
    //@Column(name="id_objectanswer")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_objectanswer", referencedColumnName="id_object")
    private ImageDO imageAnswer;    
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="challenge_pastpresent_options", joinColumns={@JoinColumn(name="id_challenge")}, inverseJoinColumns={@JoinColumn(name="id_object")})
    private List<ImageDO> imagesAlternativas;  
    
    
    @Override
    public ChallengePastPresent getDto() {
        ChallengePastPresent obj = new ChallengePastPresent();
        obj.setChallengeId(getId());
        obj.setImageQuestion((Image) getImageQuestion().getDto());
        
        
        for (ImageDO img : getImagesAlternativas()) {
            obj.getImagesAlternativas().add((Image) img.getDto());
        }
        
        return obj;
    }

    public ChallengePastPresentDO(){
        imagesAlternativas = new ArrayList<ImageDO>();
    }

    
    /**
     * @return the imageQuestion
     */
    public ImageDO getImageQuestion() {
        return imageQuestion;
    }

    /**
     * @param imageQuestion the imageQuestion to set
     */
    public void setImageQuestion(ImageDO imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    /**
     * @return the imageAnswer
     */
    public ImageDO getImageAnswer() {
        return imageAnswer;
    }

    /**
     * @param imageAnswer the imageAnswer to set
     */
    public void setImageAnswer(ImageDO imageAnswer) {
        this.imageAnswer = imageAnswer;
    }

    /**
     * @return the imagesAlternativas
     */
    public List<ImageDO> getImagesAlternativas() {
        return imagesAlternativas;
    }

    /**
     * @param imagesAlternativas the imagesAlternativas to set
     */
    public void setImagesAlternativas(List<ImageDO> imagesAlternativas) {
        this.imagesAlternativas = imagesAlternativas;
    }

    
}
