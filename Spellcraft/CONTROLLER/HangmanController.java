package CONTROLLER;

import VIEW.HangmanView;
import MODEL.HangmanModel;
import MODEL.Statistics;

public class HangmanController {
    private HangmanModel model;
    private Statistics statistics;
    private HangmanView view;

    public HangmanController() {
        this.model = new HangmanModel();
        this.statistics = new Statistics();
        this.view = new HangmanView(model, statistics);
        view.setVisible(true);
    }
}