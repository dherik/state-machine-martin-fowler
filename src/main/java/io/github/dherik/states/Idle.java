package io.github.dherik.states;

import io.github.dherik.Event;
import io.github.dherik.State;
import io.github.dherik.commands.LockPanel;
import io.github.dherik.commands.UnlockDoor;

public class Idle extends State {
	
	Event tmp;

	public Idle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Idle actions(UnlockDoor unlockDoor, LockPanel lockPanel) {
		addAction(unlockDoor);
		addAction(lockPanel);
		return this;
	}


}
