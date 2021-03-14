package main.java.rbadenas.checkers.views.console.squares;

import main.java.rbadenas.checkers.models.Square;
import main.java.rbadenas.checkers.models.pieces.Piece;

public class QueenView extends SquareViewBase {

	private Piece piece;

	public QueenView(Square square) {
		super(square);
		this.piece = square.getPiece();
	}

	@Override
	protected boolean canHandle() {
		return this.piece.isQueen();
	}

	@Override
	protected void print() {
		var symbol = this.piece.isWhite() ? '\u2605' : '\u2606';

		this.console.write(symbol);
	}

}