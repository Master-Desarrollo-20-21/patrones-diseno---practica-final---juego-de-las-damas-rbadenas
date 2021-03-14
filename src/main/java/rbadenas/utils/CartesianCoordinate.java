package main.java.rbadenas.utils;

import java.util.ArrayList;
import java.util.List;

public class CartesianCoordinate {

	protected int column;
	protected int row;

	public CartesianCoordinate(int column, int row) {
		this.column = column;
		this.row = row;
	}


    public List<CartesianCoordinate> getCoordinatesPath(CartesianCoordinate target) {
		var result = new ArrayList<CartesianCoordinate>();

		var distance = this.getDistanceWith(target);
		var unitVector = this.getUnitVectorWith(target);
		var last = new CartesianCoordinate(this.column, this.row);
		result.add(last);

		for (int i = 0; i < distance; i++) {
			last = last.displaced(unitVector);
			result.add(last);
		}

		return result;
	}

    public CartesianCoordinate getUnitVectorWith(CartesianCoordinate other) {
		var direction = this.getDirectionWith(other);

		int newCol = 0;
		int newRow = 0;

		if (direction == Direction.NORTHEAST || direction == Direction.NORTHWEST) {
			newRow++;
		}
		if (direction == Direction.SOUTHEAST || direction == Direction.SOUTHWEST) {
			newRow--;
		}

		if (direction == Direction.NORTHEAST || direction == Direction.SOUTHEAST) {
			newCol++;
		}
		if (direction == Direction.NORTHWEST || direction == Direction.SOUTHWEST) {
			newCol--;
		}

		return new CartesianCoordinate(newCol, newRow);
	}

    public Direction getDirectionWith(CartesianCoordinate other) {
		var colDistance = this.colDistance(other);
		var rowDistance = this.rowDistance(other);

		if (colDistance > 0 && rowDistance > 0)
			return Direction.NORTHEAST;

		if (colDistance < 0 && rowDistance > 0)
			return Direction.NORTHWEST;

		if (colDistance > 0 && rowDistance < 0)
			return Direction.SOUTHEAST;

		if (colDistance < 0 && rowDistance < 0)
			return Direction.SOUTHWEST;

		return Direction.NULL;
	}
    
	public double getDistanceWith(CartesianCoordinate other) {
		return Math.abs(this.colDistance(other));
	}


	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public boolean equals(CartesianCoordinate other){
		return this.row == other.row && this.column == other.column;
	}

	protected int colDistance(CartesianCoordinate other) {
		return other.column - this.column;
	}

	protected int rowDistance(CartesianCoordinate other) {
		return other.row - this.row;
	}

	protected CartesianCoordinate displaced(CartesianCoordinate displacement) {
		return new CartesianCoordinate(this.column + displacement.column, this.row + displacement.row);
	}

}