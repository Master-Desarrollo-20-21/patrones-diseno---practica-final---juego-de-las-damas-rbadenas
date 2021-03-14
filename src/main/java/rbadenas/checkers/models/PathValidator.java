package main.java.rbadenas.checkers.models;

import java.util.List;

import main.java.rbadenas.checkers.types.Error;

public class PathValidator {

    private Board board;
    private Square origin;
    private List<Coordinate> coordinates;
    private boolean isAllyWhitePiece;

    public PathValidator(Board board, List<Coordinate> coordinates) {
        this.board = board;
        this.coordinates = coordinates;
        this.origin = this.board.getSquare(getOriginCoordinate());
        this.isAllyWhitePiece = this.origin.isWhitePiece();
    }

    public Error getError() {

        if (isAnyAllyPieceOnPath()) {
            return Error.MOVEMENT_ALLY_MIDDLE_PIECES;
        }

        if (isManyEnemyPieceOnPath()) {
            return Error.MOVEMENT_ENEMY_MIDDLE_PIECES;
        }

        if (!isPieceMovementValid()) {
            return Error.MOVEMENT_INVALID_PIECE_MOVEMENT;
        }

        return Error.NULL;
    }

    public boolean isValid() {

        if (isAnyAllyPieceOnPath() || isManyEnemyPieceOnPath() || !isPieceMovementValid()) {
            return false;
        }

        return true;
    }

    public boolean isCapturing() {
        return countPiecesOnPath(this.isAllyWhitePiece) == 0 && countPiecesOnPath(!this.isAllyWhitePiece) == 1;
    }

    public Coordinate getCapturedCoordinate() {

        for (int i = 1; i < coordinates.size() - 1; i++) {
            var square = this.board.getSquare(coordinates.get(i));
            if (!square.isEmpty())
                return coordinates.get(i);
        }

        return null;
    }

    private boolean isAnyAllyPieceOnPath() {
        return countPiecesOnPath(this.isAllyWhitePiece) > 0;
    }

    private boolean isManyEnemyPieceOnPath() {
        return countPiecesOnPath(!this.isAllyWhitePiece) > 1;
    }

    private int countPiecesOnPath(boolean isWhitePiece) {
        int result = 0;
        for (int i = 1; i < coordinates.size() - 1; i++) {
            if(board.isOccupied(coordinates.get(i), isWhitePiece))
                result++;
        }

        return result;
    }

    private boolean isPieceMovementValid() {
        return this.origin.pieceCanMove(getTargetCoordinate(), isCapturing());
    }

    private Coordinate getOriginCoordinate() {
        return this.coordinates.get(0);
    }

    private Coordinate getTargetCoordinate() {
        return this.coordinates.get(this.coordinates.size() - 1);
    }

}