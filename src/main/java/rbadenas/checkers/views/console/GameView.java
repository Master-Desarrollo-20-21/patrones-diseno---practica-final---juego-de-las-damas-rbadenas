package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.UseCaseController;
import main.java.rbadenas.checkers.models.Board;
import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.views.Message;
import main.java.rbadenas.checkers.views.console.squares.SquareView;
import main.java.rbadenas.utils.Console;

public class GameView {

	private UseCaseController controller;

	public GameView(UseCaseController controller) {
		this.controller = controller;
	}

	public void write() {
		Message.COLUMN_NAMES.writeln();
		Message.HORIZONTAL_LINE.writeln();
		for (int row = Board.DIMENSION - 1; row >= 0; row--) {
			String rowNumber = (row + 1) + " ";
			Console.instance().write(rowNumber);
			Message.VERTICAL_LINE_LEFT.write();

			for (int col = 0; col < Board.DIMENSION; col++) {
				var square = this.controller.getSquare(new Coordinate(col, row));
				new SquareView(square).handle();

				Message.VERTICAL_LINE_CENTER.write();
			}
			Console.instance().writeln(rowNumber);
			Message.HORIZONTAL_LINE.writeln();
		}
		Message.COLUMN_NAMES.writeln();
	}
}