/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.service;

import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import com.lpsmuseum.entity.ChallengePastPresentDO;
import junit.framework.TestCase;

/**
 *
 * @author USER
 */
public class ChallengePastPresentServiceTest extends TestCase {
    
    public ChallengePastPresentServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of createChallengePastPresent method, of class ChallengePastPresentService.
     */
    public void testCreateChallengePastPresent() throws Exception {
        System.out.println("createChallengePastPresent");
        ChallengePastPresent challenge = new ChallengePastPresent();
        ImageService imageService = new ImageService();
        Image question = imageService.findById(2L);
        challenge.setImageQuestion(question);
        Image answer = imageService.findById(4L);
        challenge.setImageAnswer(answer);
        challenge.getImagesAlternativas().add(answer);
        Image wrong1 = imageService.findById(6L);
        challenge.getImagesAlternativas().add(wrong1);
        Image wrong2 = imageService.findById(8L);
        challenge.getImagesAlternativas().add(wrong2);
        ChallengePastPresentService instance = new ChallengePastPresentService();
        int preCount = instance.listChallenges().size();
        instance.createChallengePastPresent(challenge);
        if (instance.listChallenges().size() == preCount) fail(); else assertTrue(true);
    }

    /**
     * Test of findById method, of class ChallengePastPresentService.
     */
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        ChallengePastPresentService instance = new ChallengePastPresentService();
        ChallengePastPresent expResult = null;
        ChallengePastPresent result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEntity method, of class ChallengePastPresentService.
     */
    public void testFindEntity() {
        System.out.println("findEntity");
        ChallengePastPresent challenge = null;
        ChallengePastPresentService instance = new ChallengePastPresentService();
        ChallengePastPresentDO expResult = null;
        ChallengePastPresentDO result = instance.findEntity(challenge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
