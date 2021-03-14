package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.PlayController;

public class PlayView {

    public void interact(PlayController playController) {
        new PlayMenu(playController).execute();
        new GameView(playController).write();
    }
}