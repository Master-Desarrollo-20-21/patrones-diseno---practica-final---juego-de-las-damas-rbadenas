package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.PlayController;

public abstract class Command extends main.java.rbadenas.utils.Command {

    protected PlayController playController;

    protected Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }

}