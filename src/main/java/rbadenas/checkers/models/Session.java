package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.types.Error;
import main.java.rbadenas.checkers.types.StateValue;

public class Session {

    private Game game;
    private State state;

    public Session() {
        this.state = new State();
        this.game = new Game();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public Square getSquare(Coordinate coordinate) {
        return this.game.getSquare(coordinate);
    }

    public PlayerColor getColor() {
        return this.game.getColor();
    }

    public void exit() {
        this.state.exit();
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public Error move(Coordinate origin, Coordinate target) {
        return this.game.move(origin, target);
    }

}