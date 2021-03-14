package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.types.Error;

public class Turn {

	public static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int currentPlayerIndex;

	public Turn(Board board) {
		this.players = new Player[Turn.NUMBER_PLAYERS];

		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(PlayerColor.get(i), board);
		}
		this.currentPlayerIndex = 0;
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.getPlayer().move(origin, target);
	}

	public void next() {
		this.currentPlayerIndex = (this.currentPlayerIndex + 1) % Turn.NUMBER_PLAYERS;
	}

	public Player getPlayer() {
		return this.players[this.currentPlayerIndex];
	}

	public PlayerColor getColor() {
		return this.getPlayer().getColor();
	}
}