package main.java.rbadenas.checkers.controllers;

import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.models.Session;
import main.java.rbadenas.checkers.models.PlayerColor;
import main.java.rbadenas.checkers.types.Error;

public class PlayController extends UseCaseController implements AcceptorController {

	private ActionController actionController;

	public PlayController(Session session) {
		super(session);
		this.actionController = new ActionController(session);
	}

	public boolean isWinner() {
		return this.actionController.isWinner();
	}

	public PlayerColor getColor() {
		return this.actionController.getColor();
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.actionController.move(origin, target);
	}

	public void exit() {
		this.session.exit();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}