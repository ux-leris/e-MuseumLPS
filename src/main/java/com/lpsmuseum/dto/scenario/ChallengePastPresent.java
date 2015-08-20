/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.dto.scenario;

import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.entity.ChallengePastPresentDO;
import com.lpsmuseum.entity.ImageDO;
import com.lpsmuseum.service.ChallengePastPresentService;
import com.lpsmuseum.service.ImageService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Eduardo
 */
public class ChallengePastPresent extends Challenge {
    private Image imageQuestion;
    private Image imageAnswer;
    private List<Image> imagesAlternativas;

    public ChallengePastPresent() {
        imagesAlternativas = new ArrayList<Image>();
    }
    
    /**
     * @return the imageQuestion
     */
    public Image getImageQuestion() {
        return imageQuestion;
    }

    /**
     * @param imageQuestion the imageQuestion to set
     */
    public void setImageQuestion(Image imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    /**
     * @return the imagesAlternativas
     */
    public List<Image> getImagesAlternativas() {
        return imagesAlternativas;
    }


    /**
     * @return the imageAnswer
     */
    public Image getImageAnswer() {
        return imageAnswer;
    }

    /**
     * @param imageAnswer the imageAnswer to set
     */
    public void setImageAnswer(Image imageAnswer) {
        this.imageAnswer = imageAnswer;
    }
    
    /**
     * @param imagesAlternativas the imagesAlternativas to set
     */
    public void setImagesAlternativas(List<Image> imagesAlternativas) {
        this.imagesAlternativas = imagesAlternativas;
    }
    
    @Override
    public ChallengePastPresentDO getEntity() {
        ChallengePastPresentDO obj = new ChallengePastPresentDO();
        obj.setId(getChallengeId());
        
	ImageService svc = new ImageService();
        
        obj.setImageQuestion(svc.findEntity(getImageQuestion()));
        obj.setImageAnswer(svc.findEntity(getImageAnswer()));
        
        for (Image img : getImagesAlternativas())
        {
            ImageDO imgDO = svc.findEntity(img);
            if(imgDO != null) 
                obj.getImagesAlternativas().add(imgDO);
            else try {
                throw new Exception("Could not find object " + img.getName() + "!");
            } catch (Exception ex) {
                Logger.getLogger(ChallengePastPresent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return obj;
    }
}
