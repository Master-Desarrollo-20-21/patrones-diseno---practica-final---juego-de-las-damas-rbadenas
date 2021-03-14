package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.PlayController;
import main.java.rbadenas.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController) {
        this.addCommand(new MoveCommand(playController));
        this.addCommand(new ExitCommand(playController));
    }
}