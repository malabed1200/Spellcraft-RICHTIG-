package CONTROLLER;

import VIEW.HangmanView;
import MODEL.HangmanModel;
import MODEL.Statistics;

public class HangmanController {
    private HangmanModel model;
    private Statistics statistics;
    private HangmanView view;

    public HangmanController(Statistics statistics) {
        this.model = new HangmanModel();
        this.statistics = statistics;
    }

    public void startGame() {
        this.view = new HangmanView(model, statistics);
        view.setVisible(true);
    }
}
