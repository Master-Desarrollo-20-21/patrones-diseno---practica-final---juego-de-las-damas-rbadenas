package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.types.Error;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.reset();
    }

    public void reset() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.turn.move(origin, target);

        var boardIsWinner = this.isWinner();
        if (error.isNull() && !boardIsWinner) {
            this.turn.next();
        }

        return error;
    }

    public boolean isWinner() {
        return this.board.isWinner(this.getColor());
    }

    public PlayerColor getColor() {
        return this.turn.getColor();
    }

    public Square getSquare(Coordinate coordinate) {
        return this.board.getSquare(coordinate);
    }

}