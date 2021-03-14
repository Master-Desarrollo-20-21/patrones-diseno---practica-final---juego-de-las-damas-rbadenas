package main.java.rbadenas.checkers.views;

import main.java.rbadenas.utils.Console;

public enum Message {
    TITTLE("  ------------ CHECKERS -----------"), 
    HORIZONTAL_LINE("  +---+---+---+---+---+---+---+---+"),
    COLUMN_NAMES("    A   B   C   D   E   F   G   H  "), 
    VERTICAL_LINE_LEFT("| "), 
    VERTICAL_LINE_CENTER(" | "),
    ACTION_COMMAND("Do a action"), 
    EXIT_COMMAND("Exit game"), 
    COORDINATE_MOVE_FROM("Origin coordinate"),
    COORDINATE_MOVE_TO("Target coordinate"), 
    PLAYER_WIN(" Player: You win!!! :-)"), 
    RESUME("Do you want to continue");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void write() {
        Console.instance().write(this.message);
    }

    public void writeln() {
        Console.instance().writeln(this.message);
    }

    @Override
    public String toString() {
        return this.message;
    }
}