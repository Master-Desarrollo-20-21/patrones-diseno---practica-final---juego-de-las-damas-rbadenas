package main.java.rbadenas.checkers.views.console.squares;

import main.java.rbadenas.checkers.models.Square;
import main.java.rbadenas.utils.Console;

public abstract class SquareViewBase {

	protected Square square;
	protected Console console = Console.instance();
	private SquareViewBase successor;

	protected SquareViewBase(Square square) {
		this.square = square;
	}

	protected SquareViewBase(Square square, SquareViewBase successor) {
		this(square);
		this.successor = successor;
	}

	public void handle() {

		if (this.canHandle())
			this.print();
		else if (this.hasSuccessor())
			this.successor.handle();
	}

	protected abstract boolean canHandle();

	protected abstract void print();

	private boolean hasSuccessor() {
		return this.successor != null;
	}

}