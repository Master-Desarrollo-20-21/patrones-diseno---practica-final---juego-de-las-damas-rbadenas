package main.java.rbadenas.checkers.views;

import main.java.rbadenas.checkers.types.Error;

public class ErrorView {

	public static final String[] MESSAGES = { 
		"The coordinates are wrong", 
		"The target square is not empty",
		"There is not a piece of yours", 
		"The origin and target squares are the same",
        "Only black squares are valid destinations",
		"Can't jump over any ally piece", 
		"Can't jump over many enemy pieces", 
		"Invalid piece movement", 
        "Invalid notation. Expected letter + number", 
	};

	protected Error error;

	public ErrorView(Error error) {
		this.error = error;
	}

}