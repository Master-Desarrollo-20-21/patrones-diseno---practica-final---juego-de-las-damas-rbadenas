package main.java.rbadenas.checkers.models;

import java.util.ArrayList;
import java.util.List;

import main.java.rbadenas.checkers.types.Error;
import main.java.rbadenas.utils.CartesianCoordinate;

public class Coordinate extends main.java.rbadenas.utils.CartesianCoordinate{

    public Coordinate(int column, int row) {
        super(column, row);
    }

    public Coordinate(SquareNotation notation) {
        super(
            ((int) notation.getNotation().charAt(0)) - 65, 
            ((int) notation.getNotation().charAt(1)) - 49
            );
	}
    
    private Coordinate(CartesianCoordinate cartesianCoordinate) {
        super(cartesianCoordinate.getColumn(), cartesianCoordinate.getRow());
	}

    public Error isValid() {
		if (!isInsideLimits(this.row) || !isInsideLimits(this.column)) {
			return Error.NOT_VALID;
		}
		return Error.NULL;
	}

    private boolean isInsideLimits(int value) {
		return 0 <= value && value <= Board.DIMENSION - 1;
	}

    public List<Coordinate> getCoordinatesPath(Coordinate target){

        var coordinates = new ArrayList<Coordinate>();

        var cartesians = this.getCartessian().getCoordinatesPath(target.getCartessian());
        for (CartesianCoordinate cartesian : cartesians) {
            coordinates.add(new Coordinate(cartesian));
        }
        return coordinates;
    }

    private CartesianCoordinate getCartessian(){
        return (CartesianCoordinate)this;
    }
    
    public boolean isWhiteOnCheckersBoard(){
		return ((this.getColumn() + this.getRow()) % 2 == 1);
	}
}