package com.lpsmuseum.service;

import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import junit.framework.TestCase;

/**
 *
 * @author USER
 */
public class PastPresentServiceTest extends TestCase {
    
    ChallengePastPresentService challengeService = new ChallengePastPresentService();
    ImageService imageService    = new ImageService();
    
    public void testInsert() throws Exception {
        int preCount = challengeService.listChallenges().size();
        ChallengePastPresent challenge = new ChallengePastPresent();
        Image question = imageService.findById(2L);
        challenge.setImageQuestion(question);
        Image answer = imageService.findById(4L);
        challenge.setImageAnswer(answer);
        challenge.getImagesAlternativas().add(answer);
        Image wrong1 = imageService.findById(6L);
        challenge.getImagesAlternativas().add(wrong1);
        Image wrong2 = imageService.findById(8L);
        challenge.getImagesAlternativas().add(wrong2);
        challengeService.createChallengePastPresent(challenge);
        if (challengeService.listChallenges().size() == preCount) fail(); else assertTrue(true);
    }
    
}
