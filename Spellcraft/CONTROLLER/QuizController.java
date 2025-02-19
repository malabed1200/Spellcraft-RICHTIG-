package CONTROLLER;

import VIEW.QuizView;
import MODEL.Statistics;

public class QuizController {
    private Statistics statistics;
    private QuizView view;

    public QuizController() {
        this.statistics = new Statistics();
        this.view = new QuizView(statistics);
        view.setVisible(true);
    }
}