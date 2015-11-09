package com.lpsmuseum.service;

import com.lpsmuseum.dao.ChallengeDAO;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.entity.ChallengeDO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Realtime
 */
public class ChallengeService {
    ChallengeDAO dao = new ChallengeDAO();
	
	public void createChallenge(Challenge challenge) throws Exception{
		/*ChallengeDO chalDO = challenge.getEntity();
		dao.createChallenge(chalDO);
		challenge.setChallengeId(chalDO.getId());*/
	}
	
	public Challenge findById(Long id) throws Exception {
		Challenge mo = new Challenge();
		mo.setChallengeId(id);
		ChallengeDO modo = findEntity(mo);
		return modo.getDto();
	}
	
	public void editChallenge(Challenge challenge) throws Exception{
		/*ChallengeDO objDO = challenge.getEntity();
		dao.editChallenge(objDO);*/
	}
	
	public Challenge findChallenge(Challenge challenge) throws Exception{
		ChallengeDO cdo = findEntity(challenge);
		return cdo.getDto();
	}

	public ChallengeDO findEntity(Challenge challenge) throws Exception {
		ChallengeDO challengeDO = new ChallengeDO();
		challengeDO.setId(challenge.getChallengeId());
		return (ChallengeDO)dao.findEntity(challengeDO);
	}
	
	public ArrayList<Challenge> listChallenges(){
		List<ChallengeDO> odos = dao.listChallenges();
		ArrayList<Challenge> objects = new ArrayList<Challenge>();
		for(ChallengeDO odo : odos){
			Challenge o = odo.getDto();
			objects.add(o);
		}
		return objects;
	}
	
	public void deleteChallenge(Long id){
		ChallengeDO obj = new ChallengeDO();
		obj.setId(id);
		
		dao.deleteChallenge(obj);
	}
}
