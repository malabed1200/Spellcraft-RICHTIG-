package CONTROLLER;

import VIEW.QuizView;
import MODEL.Statistics;

public class QuizController {
    private Statistics statistics;
    private QuizView view;

    public QuizController(Statistics statistics) {
        this.statistics = statistics;
    }

    public void startGame() {
        this.view = new QuizView(statistics);
        view.setVisible(true);
    }
}