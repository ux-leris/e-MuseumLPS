package com.lpsmuseum.dao;

import com.lpsmuseum.entity.ChallengeDO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * This class provides a easy way to work with persistence of challenges.
 * <p>
 * All the <b>CRUD (Create, Retrieve, Update and Delete)</b> operations are 
 * supported.
 * @see BasicDAO
 */
public class ChallengeDAO extends BasicDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Object findEntity(Object obj) {
		ChallengeDO cdo = (ChallengeDO) obj;
		EntityManager em = PersistenceUtil.getEntityManager();
		if (cdo.getId() != null) {
			cdo = em.find(cdo.getClass(), cdo.getId());
		} else {
			if (cdo.getId() != null) {
				List<ChallengeDO> cdos = (List<ChallengeDO>) em.createQuery(
						"SELECT s "
						+ "FROM ChallengeDO s "
						+ "WHERE s.id_challenge = " + cdo.getId()
				).getResultList();
				cdo = cdos.isEmpty() ? null : cdos.get(0);
			} else {
				cdo = null;
			}
		}
		em.close();
		return cdo;
	}

	/**
	 * <b>Persists</b> a <b>new</b> challenge to the datadase, <u>if only if</u>
	 * the object is not persisted yet.
	 *
	 * @param challenge the challenge to be persisted.
	 */
	public void createChallenge(ChallengeDO challenge) {
		create(challenge);
	}

	/**
	 * <b>Merge</b> the challenge's state to the database.
	 *
	 * @param challenge the challenge to have your state updated on the
	 * database.
	 */
	public void editChallenge(ChallengeDO challenge) {
		merge(challenge);
	}

	/**
	 * <b>Delete</b> the <u>persisted</u> challenge from the database.
	 *
	 * @param challenge the challenge to be deleted.
	 */
	public void deleteChallenge(ChallengeDO scenario) {
		delete(scenario);
	}

	/**
	 * Lists <b>all</b> the persisted challenges.
	 *
	 * @return the <code>List</code> with <b>all</b> persisted challenges.
	 */
	@SuppressWarnings("unchecked")
	public List<ChallengeDO> listChallenges() {
		return list("ChallengeDO");
	}

}
