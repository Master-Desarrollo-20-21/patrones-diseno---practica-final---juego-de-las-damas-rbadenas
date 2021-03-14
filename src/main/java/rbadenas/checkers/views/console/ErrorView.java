package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.types.Error;
import main.java.rbadenas.utils.Console;

public class ErrorView extends main.java.rbadenas.checkers.views.ErrorView {

	public ErrorView(Error error) {
		super(error);
	}

	public void writeln() {
		if (!error.isNull()) {
			Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}

}