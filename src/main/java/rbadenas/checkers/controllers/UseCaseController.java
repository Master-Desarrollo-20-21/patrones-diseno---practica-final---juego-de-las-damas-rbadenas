package main.java.rbadenas.checkers.controllers;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.Session;
import main.java.rbadenas.checkers.models.Square;

public abstract class UseCaseController {

	protected Session session;

	public UseCaseController(Session session) {
		this.session = session;
	}

	public Square getSquare(Coordinate coordinate) {
		return this.session.getSquare(coordinate);
	}

}