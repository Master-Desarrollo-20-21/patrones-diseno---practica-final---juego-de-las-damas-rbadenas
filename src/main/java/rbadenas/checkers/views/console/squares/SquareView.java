package main.java.rbadenas.checkers.views.console.squares;

import main.java.rbadenas.checkers.models.Square;

public class SquareView extends SquareViewBase {

	public SquareView(Square square) {
		super(square, new PieceView(square));
	}

	@Override
	protected boolean canHandle() {
		return square.isEmpty();
	}

	@Override
	protected void print() {
		var symbol = square.isWhite() ? " " : "·";
		this.console.write(symbol);
	}
}