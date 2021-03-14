package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.PlayController;
import main.java.rbadenas.checkers.views.Message;
import main.java.rbadenas.utils.Console;

public class WinView {

    private PlayController controller;

    public WinView(PlayController controller) {
        this.controller = controller;
    }

    public void write() {
        var player = this.controller.getColor().isWhite() ? "White" : "Black";

        Console.instance().write("\n" + player + " ");
        Message.PLAYER_WIN.writeln();
    }
}