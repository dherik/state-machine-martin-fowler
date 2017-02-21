package io.github.dherik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class StateMachine {

	private State start;

	StateMachine(State start) {
		this.start = start;
	}

	private Collection<State> getStates() {
		List<State> result = new ArrayList<>();
		collectStates(result, start);
		return result;
	}

	private void collectStates(Collection<State> result, State s) {
		if (result.contains(s))
			return;
		result.add(s);
		for (State next : s.getAllTargets())
			collectStates(result, next);
	}

	private List<Event> resetEvents = new ArrayList<>();

	void addResetEvents(Event... events) {
		Collections.addAll(resetEvents, events);
	}

	boolean isResetEvent(String eventCode) {
		return resetEventCodes().contains(eventCode);
	}

	private List<String> resetEventCodes() {
		List<String> result = new ArrayList<>();
		for (Event e : resetEvents)
			result.add(e.getCode());
		return result;
	}

	private void addResetEvent_byAddingTransitions(Event e) {
		for (State s : getStates())
			if (!s.hasTransition(e.getCode())) {
				s.addTransition(e, start);
			}
	}
	
	State getStart() {
		return start;
	}

}
