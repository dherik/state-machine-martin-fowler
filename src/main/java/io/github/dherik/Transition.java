package io.github.dherik;

public class Transition {

	
	private final State source, target;
	 private final Event trigger;
	 
	 public Transition(State source, Event trigger, State target) {
	  this.source = source;
	  this.target = target;
	  this.trigger = trigger;
	 }
	 public State getSource() {return source;}
	 public State getTarget() {return target;}
	 public Event getTrigger() {return trigger;}
	 public String getEventCode() {return trigger.getCode();}
}
