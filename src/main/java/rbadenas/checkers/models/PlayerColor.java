package main.java.rbadenas.checkers.models;

public enum PlayerColor {
	WHITE, 
	BLACK;

	public static PlayerColor get(int ordinal) {
		assert 0 <= ordinal && ordinal <= 1;
		return PlayerColor.values()[ordinal];
	}

	public boolean isWhite() {
		return this == PlayerColor.WHITE;
	}

	public PlayerColor getEnemy() {
		return isWhite() ? PlayerColor.BLACK : PlayerColor.WHITE;
	}

}