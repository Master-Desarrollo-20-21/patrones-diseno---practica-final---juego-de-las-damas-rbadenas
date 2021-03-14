package main.java.rbadenas.checkers.models;

import main.java.rbadenas.checkers.models.pieces.Pawn;
import main.java.rbadenas.checkers.types.Error;
import java.util.ArrayList;
import java.util.List;

public class Board {

	public static final int DIMENSION = 8;
    private static final int WHITE_STARTING_ROW_UPPER_LIMIT = 2;
    private static final int BLACK_STARTING_ROW_LOWER_LIMIT = 5;

	private Square[][] squares;

	public Board() {
		this.squares = new Square[DIMENSION][DIMENSION];
		for (int row = 0; row < DIMENSION; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				this.squares[col][row] = new Square(col, row);
			}
		}
		this.populateWhitePawns();
		this.populateBlackPawns();
	}

	private void populateWhitePawns(){
		
		for (int row = 0; row <= WHITE_STARTING_ROW_UPPER_LIMIT; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				if(!this.squares[col][row].isWhite())
					this.squares[col][row].setPiece(new Pawn(PlayerColor.WHITE));
			}
		}
	}
	
    private void populateBlackPawns(){
		
		for (int row = BLACK_STARTING_ROW_LOWER_LIMIT; row < DIMENSION; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				if(!this.squares[col][row].isWhite())
					this.squares[col][row].setPiece(new Pawn(PlayerColor.BLACK));
			}
		}
	}

	public boolean isOccupied(Coordinate coordinate, PlayerColor playerColor) {
		assert coordinate != null;
		return isOccupied(coordinate, playerColor.isWhite());
	}

	public boolean isOccupied(Coordinate coordinate, boolean isWhitePiece) {
		assert coordinate != null;
		return !this.isEmpty(coordinate) && isWhitePiece == this.getSquare(coordinate).isWhitePiece();
	}
	
	public boolean isEmpty(Coordinate coordinate) {
		assert coordinate != null;

		return this.getSquare(coordinate).isEmpty();
	}

	public boolean isWinner(PlayerColor pieceColor) {

		List<Coordinate> enemyCoordinates = this.getCoordinates(pieceColor.getEnemy());

		if (enemyCoordinates.size() == 0)
			return true;
		else
			return false;
	}

	
	private List<Coordinate> getCoordinates(PlayerColor pieceColor) {
		return getCoordinates(pieceColor.isWhite());
	}
	
	private List<Coordinate> getCoordinates(boolean isWhitePiece) {

		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		for (int row = 0; row < Board.DIMENSION; row++) {
			for (int col = 0; col < Board.DIMENSION; col++) {
				if(this.isOccupied(new Coordinate(col,row), isWhitePiece))
				{
					coordinates.add(new Coordinate(col, row));
				}
			}
		}
		return coordinates;
	}

	public List<Coordinate> getCoordinatesPath(Coordinate origin, Coordinate target) {
		return origin.getCoordinatesPath(target);
	}

	public Error move(Coordinate origin, Coordinate target) {

        if (getSquare(target).isWhite()) {
            return Error.MOVEMENT_INVALID_SQUARE_COLOR;
        }

		var coordinatesPath = getCoordinatesPath(origin, target);
		var pathValidator = new PathValidator(this, coordinatesPath);

		if (!pathValidator.isValid()) {
			return pathValidator.getError();
		}

		var captured = pathValidator.getCapturedCoordinate();

		this.movePiece(origin, target, captured);

		return Error.NULL;
	}

	private void movePiece(Coordinate origin, Coordinate target, Coordinate captured) {
		var originSquare = this.getSquare(origin);
		var targetSquare = this.getSquare(target);

		originSquare.movePieceTo(targetSquare);
		targetSquare.tryPromotePiece();

		if (captured != null) {
			var capturedSquare = this.getSquare(captured);
			capturedSquare.removePiece();
		}
	}

    public Square getSquare(Coordinate coordinate) {
		assert coordinate != null;

		return this.squares[coordinate.getColumn()][coordinate.getRow()];
	}


}