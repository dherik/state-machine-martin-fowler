package io.github.dherik.states;

import io.github.dherik.State;
import io.github.dherik.commands.LockDoor;
import io.github.dherik.commands.UnlockPanel;

public class UnlockedPanel extends State {

	public UnlockedPanel(String name) {
		super(name);
	}

	public State actions(UnlockPanel unlockPanel, LockDoor lockDoor) {
		addAction(unlockPanel);
		addAction(lockDoor);
		return this;
	}

}
