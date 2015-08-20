/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.dao;

import com.lpsmuseum.entity.ChallengeDO;
import com.lpsmuseum.entity.ChallengePastPresentDO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Luis Eduardo
 */
public class ChallengePastPresentDAO extends ChallengeDAO {
    
    public void createChallengePastPresent(ChallengePastPresentDO challenge){
        create(challenge);
    }

    public void editChallengePastPresent(ChallengePastPresentDO challenge){
        merge(challenge);
    }
    
    @Override
    public Object findEntity(Object obj) {
        ChallengePastPresentDO sdo = (ChallengePastPresentDO) obj;
        EntityManager em = PersistenceUtil.getEntityManager();
        if(sdo.getId() != null){
            sdo =  em.find(sdo.getClass(), sdo.getId());
        } else{
            List<ChallengePastPresentDO> sdos = (List<ChallengePastPresentDO>)em.createQuery("SELECT s FROM ChallengeDO s WHERE s.id = '" + sdo.getId()+ "'")
                    .getResultList();
            sdo = sdos.isEmpty() ? null : sdos.get(0);
        }
        em.close();
        return sdo;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<ChallengeDO> listChallenges(){
        return list("ChallengePastPresentDO");
    }

    public void deleteChallengePastPresent(ChallengePastPresentDO challenge){
        delete(challenge);
    }
}
