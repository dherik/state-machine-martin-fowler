package io.github.dherik;

record Transition(State source, Event trigger, State target) {
    public String getEventCode() {
        return trigger.getCode();
    }
}
