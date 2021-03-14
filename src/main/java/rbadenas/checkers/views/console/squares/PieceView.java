package main.java.rbadenas.checkers.views.console.squares;

import main.java.rbadenas.checkers.models.Square;
import main.java.rbadenas.checkers.models.pieces.Piece;

public class PieceView extends SquareViewBase {

	private Piece piece;

	public PieceView(Square square) {
		super(square, new QueenView(square));
		this.piece = square.getPiece();
	}

	@Override
	protected boolean canHandle() {
		return !this.piece.isQueen();
	}

	@Override
	protected void print() {
		var symbol = this.piece.isWhite() ? '\u25B2' : '\u25B3';

		this.console.write(symbol);
	}
}