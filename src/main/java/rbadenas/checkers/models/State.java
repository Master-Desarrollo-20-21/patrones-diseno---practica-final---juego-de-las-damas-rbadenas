package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.types.StateValue;

public class State {

    private StateValue stateValue;

    public State() {
        this.reset();
    }

    public void reset() {
        this.stateValue = StateValue.INITIAL;
    }

    public void next() {
        this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
    }

    public void exit() {
        this.stateValue = StateValue.EXIT;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }
}