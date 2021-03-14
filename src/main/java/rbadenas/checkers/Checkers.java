package main.java.rbadenas.checkers;

import main.java.rbadenas.checkers.controllers.AcceptorController;
import main.java.rbadenas.checkers.controllers.Logic;
import main.java.rbadenas.checkers.views.View;

public abstract class Checkers {

    private Logic logic;
    private View view;

    protected Checkers() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        AcceptorController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

}