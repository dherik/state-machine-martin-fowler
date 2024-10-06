package io.github.dherik;

class Controller {

	private State currentState;
	private final StateMachine machine;
	private final CommandChannel commandsChannel = new CommandChannel();

	Controller(StateMachine machine, State currentState) {
		this.machine = machine;
		this.currentState = currentState;
	}

	public CommandChannel getCommandChannel() {
		return commandsChannel;
	}

	void handle(String eventCode) {
		
		if (currentState.hasTransition(eventCode)) {
			transitionTo(currentState.targetState(eventCode));
		} else if (machine.isResetEvent(eventCode)) {
			transitionTo(machine.getStart());
		}
		
		// ignore unknown events

	}

	private void transitionTo(State target) {
		currentState = target;
		currentState.executeActions(commandsChannel);

	}

}
