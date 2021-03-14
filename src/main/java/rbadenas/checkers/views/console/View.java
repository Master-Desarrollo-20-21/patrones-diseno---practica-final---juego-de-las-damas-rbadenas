package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.AcceptorController;
import main.java.rbadenas.checkers.controllers.ControllerVisitor;
import main.java.rbadenas.checkers.controllers.PlayController;
import main.java.rbadenas.checkers.controllers.ResumeController;
import main.java.rbadenas.checkers.controllers.StartController;

public class View extends main.java.rbadenas.checkers.views.View implements ControllerVisitor {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}