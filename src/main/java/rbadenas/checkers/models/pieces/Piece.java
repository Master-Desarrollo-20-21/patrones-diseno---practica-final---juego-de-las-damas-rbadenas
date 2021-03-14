package main.java.rbadenas.checkers.models.pieces;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.PlayerColor;

public abstract class Piece {

    protected PlayerColor color;

    protected Piece(PlayerColor pieceColor) {
        this.color = pieceColor;
    }

    public abstract boolean isQueen();

    public abstract boolean canMove(Coordinate origin, Coordinate target, boolean isCapturing);

    public boolean isWhite() {
        return this.color.isWhite();
    }

    public final Queen promote() {
        return new Queen(color);
    }

}