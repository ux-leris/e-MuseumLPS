/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.dao;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import com.lpsmuseum.entity.ChallengeDO;
import com.lpsmuseum.entity.ChallengePastPresentDO;
import com.lpsmuseum.service.ImageService;
import com.lpsmuseum.service.MuseologicalObjectService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class ChallengePastPresentDAOTest {
    
    public ChallengePastPresentDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createChallengePastPresent method, of class ChallengePastPresentDAO.
     */
    @Test
    public void testCreateChallengePastPresent() {
        System.out.println("createChallengePastPresent");
        ChallengePastPresent challenge = new ChallengePastPresent();
        ImageService imageService = new ImageService();
        Image question = imageService.findById(11L);
        challenge.setImageQuestion(question);
        Image answer = imageService.findById(13L);
        challenge.setImageAnswer(answer);
        challenge.getImagesAlternativas().add(answer);
        Image wrong1 = imageService.findById(15L);
        challenge.getImagesAlternativas().add(wrong1);
        Image wrong2 = imageService.findById(17L);
        challenge.getImagesAlternativas().add(wrong2);
        ChallengePastPresentDAO instance = new ChallengePastPresentDAO();
        instance.createChallengePastPresent(challenge.getEntity());
        ChallengePastPresentDO cdo = new ChallengePastPresentDO();
        cdo.setId(challenge.getChallengeId());
        assertNotNull(instance.findEntity(cdo));
    }

    /**
     * Test of editChallengePastPresent method, of class ChallengePastPresentDAO.
     */
    @Test
    public void testEditChallengePastPresent() {
        System.out.println("editChallengePastPresent");
        ChallengePastPresentDO challenge = null;
        ChallengePastPresentDAO instance = new ChallengePastPresentDAO();
        instance.editChallengePastPresent(challenge);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEntity method, of class ChallengePastPresentDAO.
     */
    @Test
    public void testFindEntity() {
        System.out.println("findEntity");
        Object obj = null;
        ChallengePastPresentDAO instance = new ChallengePastPresentDAO();
        Object expResult = null;
        Object result = instance.findEntity(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listChallenges method, of class ChallengePastPresentDAO.
     */
    @Test
    public void testListChallenges() {
        System.out.println("listChallenges");
        ChallengePastPresentDAO instance = new ChallengePastPresentDAO();
        List<ChallengeDO> expResult = null;
        List<ChallengeDO> result = instance.listChallenges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteChallengePastPresent method, of class ChallengePastPresentDAO.
     */
    @Test
    public void testDeleteChallengePastPresent() {
        System.out.println("deleteChallengePastPresent");
        ChallengePastPresentDO challenge = null;
        ChallengePastPresentDAO instance = new ChallengePastPresentDAO();
        instance.deleteChallengePastPresent(challenge);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
