package CONTROLLER;

import MODEL.Statistics;
import VIEW.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class HauptController implements ActionListener {
    private JFrameE currentFrame;
    private Statistics statistics;


    public HauptController() {
        this.statistics = new Statistics(); // Initialisiere die Statistiken
        currentFrame = new MainMenu(this);
    }

    public static void main(String[] args) {
        new HauptController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                currentFrame.dispose();
                currentFrame = new PlayMenu(this);
                break;
            case "Stats":
                currentFrame.dispose();
                currentFrame = new StatisticsView(statistics);
                break;
            case "Options":
                currentFrame.dispose();
                currentFrame = new OptionsMenu(this);
                break;
            case "BackH":
                currentFrame.dispose();
                currentFrame = new MainMenu(this);
                break;
            case "Add Question":
                currentFrame.dispose();
                currentFrame = new QuestionAddMenu(this);
                break;
            case "Remove Question":
                currentFrame.dispose();
                currentFrame = new QuestionRemoveMenu(this);
                break;
        }
    }
}