package com.lpsmuseum.behaviour.museum;

import java.util.List;

import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Scenario;

public interface Navigation {
	Node getNavigation(List<Scenario> scenarios);
}
