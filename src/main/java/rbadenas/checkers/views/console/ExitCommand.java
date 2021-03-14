package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.PlayController;
import main.java.rbadenas.checkers.views.Message;

public class ExitCommand extends Command {

    public ExitCommand(PlayController playController) {
        super(Message.EXIT_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        playController.exit();
    }

    @Override
    protected boolean isActive() {
        return true;
    }

}