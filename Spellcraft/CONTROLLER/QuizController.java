package CONTROLLER;

import MODEL.Statistics;
import VIEW.PlayMenu;
import VIEW.QuizView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizController implements ActionListener {
    private Statistics statistics;
    private QuizView view;

    public QuizController(Statistics statistics) {
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
                view.dispose();
                new PlayMenu(new HauptController(), statistics); // Zurück zum PlayMenu
                break;
        }
    }
}
