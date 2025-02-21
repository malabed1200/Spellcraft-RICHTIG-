package CONTROLLER;

import MODEL.Statistics;
import VIEW.PlayMenu;
import VIEW.QuizView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizController implements ActionListener {
    private Statistics statistics;
    private QuizView view;
    private HauptController hc;

    public QuizController(HauptController hc, Statistics statistics) {
        this.hc = hc;

        this.statistics = statistics;
        this.view = new QuizView(this, statistics);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Submit":
                view.checkAnswer();
                break;
            case "Back":
                shutdown();// Zurück zum PlayMenu
                break;
        }
    }

    public void shutdown() {
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        view = null;
        hc.startHC();
    }
}
