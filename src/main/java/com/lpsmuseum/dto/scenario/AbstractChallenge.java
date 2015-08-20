package com.lpsmuseum.dto.scenario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractChallenge<T> {
	private Long id;
	protected List<AbstractChallengeItem<T>> items;
	protected List<T> userAnswers;
	
	public AbstractChallenge(Long id) {
		super();
		this.id = id;
		this.items = new ArrayList<AbstractChallengeItem<T>>();
		
		this.userAnswers = new ArrayList<T>();
		initUserAnswers();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AbstractChallengeItem<T>> getItems() {
		return items;
	}

	public void setItems(List<AbstractChallengeItem<T>> items) {
		this.items = items;
	}

	public List<T> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<T> userAnswers) {
		this.userAnswers = userAnswers;
	}
	
	protected abstract void initUserAnswers();
	
	public Map<Long, Boolean> getResult() {
		Map<Long, Boolean> result = new HashMap<Long, Boolean>();
		
		for (AbstractChallengeItem<T> item : items)
			result.put(item.getId(), item.checkAnswer(userAnswers.get(items.indexOf(item))));
		
		return result;
	}
	
	public void answer(Long challengeItemId, T answer) {
		int i = 0;
		
		for (AbstractChallengeItem<T> item : items) {
			if (item.getId().compareTo(challengeItemId) == 0)
				break;
			i++;
		}
		
		userAnswers.set(i, answer);
	}

}
