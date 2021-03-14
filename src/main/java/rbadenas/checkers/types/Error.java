package main.java.rbadenas.checkers.types;

public enum Error {

	NOT_VALID, 
	TARGET_NOT_EMPTY, 
	ORIGIN_NOT_OWNER, 
	SAME_COORDINATES, 
    MOVEMENT_INVALID_SQUARE_COLOR,
	MOVEMENT_ALLY_MIDDLE_PIECES,
	MOVEMENT_ENEMY_MIDDLE_PIECES, 
	MOVEMENT_INVALID_PIECE_MOVEMENT, 
    NOTATION_NOT_VALID,
	NULL;

	public boolean isNull() {
		return this == Error.NULL;
	}

}