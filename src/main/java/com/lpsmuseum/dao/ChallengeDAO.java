package com.lpsmuseum.dao;

import com.lpsmuseum.entity.ChallengeDO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Realtime
 */
public class ChallengeDAO extends BasicDAO {
    
	public void createChallenge(ChallengeDO challenge){
		create(challenge);
	}
	
	public void editChallenge(ChallengeDO challenge){
		merge(challenge);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		ChallengeDO cdo = (ChallengeDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if(cdo.getId() != null){
			cdo =  em.find(cdo.getClass(), cdo.getId());
		} else{
                    if(cdo.getId() != null){
			List<ChallengeDO> cdos = (List<ChallengeDO>)em.createQuery("SELECT s FROM ChallengeDO s WHERE s.id_challenge = " + cdo.getId()+ "")
				.getResultList();
			cdo = cdos.isEmpty() ? null : cdos.get(0);
                    }
                    else
                        cdo = null;
		}
		em.close();
		return cdo;
	}
	
	@SuppressWarnings("unchecked")
	public List<ChallengeDO> listChallenges(){
                return list("ChallengeDO");
	}
	
	public void deleteChallenge(ChallengeDO scenario){
		delete(scenario);
	}
    
}
