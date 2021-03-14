package main.java.rbadenas.checkers.models.pieces;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.PlayerColor;
import main.java.rbadenas.utils.Direction;

public class Queen extends Piece {

    public Queen(PlayerColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean canMove(Coordinate origin, Coordinate target, boolean isCapturing) {

        var direction = origin.getDirectionWith(target);

        if (Direction.NORTHEAST == direction 
            || Direction.NORTHWEST == direction 
            || Direction.SOUTHEAST == direction
            || Direction.SOUTHWEST == direction) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isQueen() {
        return true;
    }

}