package CONTROLLER;

import MODEL.QuestionManager;
import MODEL.Statistics;
import VIEW.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HauptController implements ActionListener {
    private JFrameE currentFrame;
    private Statistics statistics;
    private QuestionManager questionManager;

    public HauptController() {
        startHC();
    }

    public void startHC() {
        statistics = new Statistics();
        currentFrame = new MainMenu(this);
    }

    public static void main(String[] args) {
        new HauptController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                openPlayMenu();
                break;
            case "Stats":
                openStatistics();
                break;
            case "Options":
                openOptionsMenu();
                break;
            case "BackH":
                returnToMainMenu();
                break;
            case "Back":
                returnToOptionsMenu();
                break;
            case "Add Question":
                openQuestionAddMenu();
                break;
            case "Remove Question":
                openQuestionRemoveMenu();
                break;
            case "Hangman":
                startHangman();
                break;
            case "GuessThePic":
                startGuessThePic();
                break;
            case "Quiz":
                startQuiz();
                break;
        }
    }

    private void openPlayMenu() {
        closeCurrentFrame();
        currentFrame = new PlayMenu(this, statistics);
    }

    private void openStatistics() {
        closeCurrentFrame();
        currentFrame = new StatisticsView(this);
    }

    private void openOptionsMenu() {
        closeCurrentFrame();
        currentFrame = new OptionsMenu(this);
    }

    private void returnToMainMenu() {
        closeCurrentFrame();
        startHC();
    }

    private void returnToOptionsMenu() {
        closeCurrentFrame();
        currentFrame = new OptionsMenu(this);
        questionManager.saveQuestions();
    }

    private void openQuestionAddMenu() {
        questionManager = new QuestionManager();
        closeCurrentFrame();
        currentFrame = new QuestionAddMenu(this);
    }

    private void openQuestionRemoveMenu() {
        questionManager = new QuestionManager();
        closeCurrentFrame();
        currentFrame = new QuestionRemoveMenu(this);
    }

    private void startHangman() {
        closeCurrentFrame();
        new HangmanController(this);
    }

    private void startGuessThePic() {
        closeCurrentFrame();
        new GuessThePicController(this);
    }

    private void startQuiz() {
        closeCurrentFrame();
        new QuizController(statistics);
    }

    private void closeCurrentFrame() {
        if (currentFrame != null) {
            currentFrame.dispose();
            currentFrame = null;
        }
    }
}
