package com.lpsmuseum.dto.scenario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CopyOfChallenge {
	
	private int challengeId;
	private List<AbstractChallengeItem> items = new ArrayList<AbstractChallengeItem>();
	private Map<Long, Boolean> resultMap = new HashMap<Long, Boolean>();

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}
	
	public List<AbstractChallengeItem> getChallenges() {
		return items;
	}

	public void setChallenges(List<AbstractChallengeItem> items) {
		this.items = items;
		for (AbstractChallengeItem item : this.items)
			resultMap.put(item.getId(), false);
	}
	
	public void addChallenge(AbstractChallengeItem item) {
		items.add(item);
		resultMap.put(item.getId(), false);
	}
	
	public boolean removeChallenge(AbstractChallengeItem item) {
		return (items.remove(item) && resultMap.remove(item));
	}
	
	void updateResult(Long itemId, boolean answer) {
		resultMap.put(itemId, Boolean.valueOf(answer));
	}

	public ChallengeResult getResults(){
		int isOkay = 0;
		for (Iterator<Entry<Long, Boolean>> it = resultMap.entrySet().iterator(); it.hasNext(); )
			if (((Entry<Long, Boolean>) it.next()).getValue().booleanValue())
				isOkay++;
		return new ChallengeResult(isOkay, resultMap.size());
	}
	
	class ChallengeResult {
		private int okay;
		private int total;
		
		public int getOkay() {
			return okay;
		}

		public int getTotal() {
			return total;
		}

		public ChallengeResult(int okay, int total) {
			this.okay = okay;
			this.total = total;
		}
	}
}
