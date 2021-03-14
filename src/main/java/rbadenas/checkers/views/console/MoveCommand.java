package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.PlayController;
import main.java.rbadenas.checkers.models.Coordinate;
import main.java.rbadenas.checkers.views.Message;
import main.java.rbadenas.checkers.types.Error;

public class MoveCommand extends Command {

    public MoveCommand(PlayController playController) {
        super(Message.ACTION_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {

        this.move(playController);

        if (playController.isWinner()) {
            new GameView(playController).write();
            new WinView(playController).write();
        }
    }

    private void move(PlayController playController) {
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            origin = new CoordinateView().read(Message.COORDINATE_MOVE_FROM.toString());
            target = new CoordinateView().read(Message.COORDINATE_MOVE_TO.toString());
            error = playController.move(origin, target);
            new ErrorView(error).writeln();
        } while (!error.isNull());
    }

    @Override
    protected boolean isActive() {
        return true;
    }

}