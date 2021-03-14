package main.java.rbadenas.checkers.models.pieces;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.PlayerColor;
import main.java.rbadenas.utils.Direction;

public class Pawn extends Piece {

    public Pawn(PlayerColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean canMove(Coordinate origin, Coordinate target, boolean isCapturing) {

        var distance = origin.getDistanceWith(target);
        var direction = origin.getDirectionWith(target);

        boolean isValidDirection = this.color.isWhite() 
                ? isWhiteDirection(direction)
                : isBlackDirection(direction);

        if ((distance == 1 || (distance == 2 && isCapturing)) 
            && isValidDirection) {
            return true;
        }

        return false;
    }

    private boolean isWhiteDirection(Direction direction) {
        return Direction.NORTHEAST == direction || Direction.NORTHWEST == direction;
    }

    private boolean isBlackDirection(Direction direction) {
        return Direction.SOUTHEAST == direction || Direction.SOUTHWEST == direction;
    }

    @Override
    public boolean isQueen() {
        return false;
    }

}