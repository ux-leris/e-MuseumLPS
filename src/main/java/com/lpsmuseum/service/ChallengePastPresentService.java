/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.service;

import com.lpsmuseum.dao.ChallengePastPresentDAO;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import com.lpsmuseum.entity.ChallengePastPresentDO;

/**
 *
 * @author Luis Eduardo
 */
public class ChallengePastPresentService extends ChallengeService {
    ChallengePastPresentDAO dao = new ChallengePastPresentDAO();
    
    
    public void createChallengePastPresent(ChallengePastPresent challenge) throws Exception{
        ChallengePastPresentDO challengeDO = challenge.getEntity();

        dao.createChallenge(challengeDO);
        challengeDO.setId(challengeDO.getId());
    }

    public void editChallengePastPresent(ChallengePastPresent challenge) throws Exception {
        ChallengePastPresentDO cppdo = challenge.getEntity();
        dao.editChallengePastPresent(cppdo);
    }
    
    @Override
    public ChallengePastPresent findById(Long id){
        ChallengePastPresent s = new ChallengePastPresent();
        s.setChallengeId(id);
        ChallengePastPresentDO cdo = findEntity(s);
        return cdo.getDto();
    }

    public ChallengePastPresentDO findEntity(ChallengePastPresent challenge){
        ChallengePastPresentDO sdo = new ChallengePastPresentDO();
        sdo.setId(challenge.getChallengeId());
        return (ChallengePastPresentDO)dao.findEntity(sdo);
    }

    public void deleteChallengePastPresent(Long id) {
        ChallengePastPresentDO cppdo = findById(id).getEntity();
        dao.deleteChallengePastPresent(cppdo);
    }
}
