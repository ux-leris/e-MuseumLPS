package com.lpsmuseum.service;

import com.lpsmuseum.dao.ChallengeDAO;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.entity.ChallengeDO;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides services to work with <b>challenges</b>.
 *
 * <p>
 * The services available are all the CRUD operations.
 *
 * @see Challenge
 */
public class ChallengeService {

	/**
	 * This fields provides communication with the database.
	 */
	private final ChallengeDAO dao = new ChallengeDAO();

	/**
	 * Class constructor.
	 */
	public ChallengeService() {
	}

	/**
	 * Creates a new register in the database for a <code>Challenge</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Challenge challenge = new Challenge();
	 * // Getters call on challenge
	 * ChallengeService service = new ChallengeService();
	 * service.createChallenge(challenge);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param challenge the <code>Challenge</code> instance to be registered in
	 * the database.
	 */
	public void createChallenge(Challenge challenge) throws Exception {
		ChallengeDO chalDO = challenge.getEntity();
		dao.createChallenge(chalDO);
		challenge.setChallengeId(chalDO.getId());
	}

	/**
	 * Searchs for the challenge with given <code>id</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Long id = 1L;
	 * ChallengeService service = new ChallengeService();
	 * Challenge challenge = service.findById(id);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param id the id of the challenge.
	 * @return the <code>Challenge</code> instance representing a register in
	 * the database with given <code>id</code>. If the register can't be found,
	 * <code>null</code> is returned.
	 */
	public Challenge findById(Long id) throws Exception {
		Challenge mo = new Challenge();
		mo.setChallengeId(id);
		ChallengeDO modo = findEntity(mo);
		return modo.getDto();
	}

	/**
	 * Updates an <code>Challenge</code> stored in the database.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ChallengeService service = new ChallengeService();
	 * Challenge challenge = service.findById(1L);
	 * challenge.setTitle("Which is the color of Napolean's white horse?");
	 * service.editChallenge(challenge);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param challenge the <code>Challenge</code> to be updated.
	 */
	public void editChallenge(Challenge challenge) throws Exception {
		dao.editChallenge(challenge.getEntity());
	}

	/**
	 * Searchs for the register corresponding with given <code>challenge</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Challenge challenge = new Challenge().
	 * challenge.setId(1L);
	 * ChallengeService service = new ChallengeService();
	 * challenge = service.findChallenge(challenge);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param challenge the challenge to be searched in the database.
	 * @return the <code>Challenge</code> instance representing a register in
	 * the database. If the register can't be found, <code>null</code> is
	 * returned.
	 */
	public Challenge findChallenge(Challenge challenge) throws Exception {
		ChallengeDO cdo = findEntity(challenge);
		return cdo.getDto();
	}

	/**
	 * Finds the entity corresponding to given <code>Challenge</code>.
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * Challenge challenge = new Challenge();
	 * challenge.setId(1L);
	 * ChallengeService service = new ChallengeService();
	 * ChallengeDO challengeDO = service.findEntity(challenge);
	 * </code>
	 * </pre>
	 * </p>
	 *
	 * @param challenge the challenge to be searched.
	 * @return the entity instance of given <code>Challenge</code>.
	 */
	public ChallengeDO findEntity(Challenge challenge) throws Exception {
		return (ChallengeDO) dao.findEntity(challenge.getEntity());
	}

	/**
	 * Lists all the challenges.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ChallengeService service = new ChallengeService();
	 * List&lt;Challenge&gt; challenges = service.listChallenges();
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @return the <code>List</code> of all <code>Challenge</code> stored in the 
	 * database.
	 */
	public List<Challenge> listChallenges() {
		List<ChallengeDO> cdos = dao.listChallenges();
		List<Challenge> challenges = new ArrayList<Challenge>();
		for (ChallengeDO cdo : cdos) {
			Challenge c = cdo.getDto();
			challenges.add(c);
		}
		return challenges;
	}

	/**
	 * Deletes an <code>Challenge</code> stored in the database.
	 * 
	 * <p>
	 * Example:
	 * <pre>
	 * <code>
	 * ChallengeService service = new ChallengeService();
	 * Challenge challenge = service.finById(1L);
	 * service.deleteAnnotation(challenge.getId());
	 * </code>
	 * </pre>
	 * </p>
	 * 
	 * @param id the <code>id</code> of <code>Challenge</code> to be deleted.
	 */
	public void deleteChallenge(Long id) {
		ChallengeDO obj = new ChallengeDO();

		obj.setId(id);

		dao.deleteChallenge(obj);
	}
}
