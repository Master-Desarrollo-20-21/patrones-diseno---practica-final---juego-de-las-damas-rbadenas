package main.java.rbadenas.checkers.controllers;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.PlayerColor;
import main.java.rbadenas.checkers.models.Session;
import main.java.rbadenas.checkers.types.Error;

public class ActionController extends UseCaseController {

	public ActionController(Session session) {
		super(session);
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public PlayerColor getColor() {
		return this.session.getColor();
	}

	public Error move(Coordinate origin, Coordinate target) {
		Error error = this.session.move(origin, target);
		if (error.isNull() && this.session.isWinner()) {
			this.session.next();
		}
		return error;
	}
}