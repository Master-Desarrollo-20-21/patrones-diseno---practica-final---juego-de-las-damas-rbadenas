package main.java.rbadenas.checkers.views.console;

import main.java.rbadenas.checkers.controllers.ResumeController;
import main.java.rbadenas.checkers.views.Message;
import main.java.rbadenas.utils.YesNoDialog;

public class ResumeView {

	public boolean interact(ResumeController resumeController) {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		resumeController.resume(isResumed);
		return isResumed;
	}
}