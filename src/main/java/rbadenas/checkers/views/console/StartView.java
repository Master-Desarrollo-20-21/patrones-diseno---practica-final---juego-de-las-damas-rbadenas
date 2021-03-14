package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.StartController;
import main.java.rbadenas.checkers.views.Message;

public class StartView {

	void interact(StartController startController) {
		Message.TITTLE.writeln();
		new GameView(startController).write();
		startController.next();
	}
}