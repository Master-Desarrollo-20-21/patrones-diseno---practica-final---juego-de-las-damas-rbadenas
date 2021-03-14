package main.java.rbadenas.checkers.controllers;

import main.java.rbadenas.checkers.models.Session;

public class StartController extends UseCaseController implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public void next() {
        this.session.next();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}