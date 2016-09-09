package io.github.dherik;

public class Controller {

	private State currentState;
	private StateMachine machine;
	
	public Controller(StateMachine machine, State currentState) {
		this.machine = machine;
		this.currentState = currentState;
	}

	public CommandChannel getCommandChannel() {
		return commandsChannel;
	}

	private CommandChannel commandsChannel = new CommandChannel();

	public void handle(String eventCode) {
		
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
