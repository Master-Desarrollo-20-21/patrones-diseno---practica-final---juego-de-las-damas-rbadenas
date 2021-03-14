package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.types.Error;

public class Player {

	private PlayerColor color;
	Board board;

	public Player(PlayerColor playerColor, Board board) {
		this.color = playerColor;
		this.board = board;
	}

	public Error move(Coordinate origin, Coordinate target) {
		assert origin != null;
		assert target != null;

		if (!this.board.isOccupied(origin, this.color)) {
			return Error.ORIGIN_NOT_OWNER;
		}
		if (origin.equals(target)) {
			return Error.SAME_COORDINATES;
		}
		if (!this.board.isEmpty(target)) {
			return Error.TARGET_NOT_EMPTY;
		}

		return board.move(origin, target);
	}

	public PlayerColor getColor() {
		return this.color;
	}

}