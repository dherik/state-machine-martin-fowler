package io.github.dherik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class State {

	private final String name;
	private final List<Command> actions = new ArrayList<>();
	private final Map<String, Transition> transitions = new HashMap<>();
	
	private Event tmp;

	public State(String name) {
		this.name = name;
	}

	void addTransition(Event event, State targetState) {
		assert null != targetState;
		transitions.put(event.getCode(), new Transition(this, event,
				targetState));
	}

	boolean hasTransition(String eventCode) {
		return transitions.containsKey(eventCode);
	}

	State targetState(String eventCode) {
		return transitions.get(eventCode).getTarget();
	}

	void executeActions(CommandChannel commandsChannel) {

		for (Command c : actions) {
			commandsChannel.send(c.getCode());
		}
		
	}

	Collection<State> getAllTargets() {
		List<State> result = new ArrayList<>();
		for (Transition t : transitions.values())
			result.add(t.getTarget());
		return result;
	}

	protected void addAction(Command command) {
		this.actions.add(command);
	}
	
	protected State transition(Event event) {
		this.tmp = event;
		return this;
	}

	State to(State state) {
		addTransition(tmp, state);
		this.tmp = null;
		return this;
	}

}
