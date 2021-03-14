package main.java.rbadenas.checkers;

import main.java.rbadenas.checkers.views.console.View;

class ConsoleCheckers extends Checkers {

	@Override
	protected View createView() {
		return new View();
	}

	public static void main(String[] args) {

		new ConsoleCheckers().play();
	}

}