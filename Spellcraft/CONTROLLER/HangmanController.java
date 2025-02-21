package CONTROLLER;

import VIEW.HangmanView;
import MODEL.HangmanModel;
import MODEL.Statistics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanController implements ActionListener {
    private HangmanModel model;
    private Statistics statistics;
    private HangmanView view;

    public HangmanController(Statistics statistics) {
        this.model = new HangmanModel();
        this.statistics = statistics;
    }

    public void startGame() {
        this.view = new HangmanView(this, statistics);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Zurück-Button: Zurück ins PlayMenu
        if (command.equals("Back")) {
            view.dispose();
            new VIEW.PlayMenu(new HauptController(), statistics);
        }

        // Wenn ein Buchstabe angeklickt wurde
        if (command.startsWith("Letter_")) {
            char letter = command.charAt(7); // Buchstabe nach "Letter_"
            processGuess(letter, (JButton) e.getSource());
        }
    }

    private void processGuess(char letter, JButton button) {
        boolean correct = model.guessLetter(letter);
        button.setBackground(correct ? java.awt.Color.GREEN : java.awt.Color.RED);
        button.setEnabled(false);
        view.updateView();
        checkGameStatus();
    }

    private void checkGameStatus() {
        if (model.isWin()) {
            JOptionPane.showMessageDialog(view, "Glückwunsch! Du hast gewonnen!");
            statistics.incrementCorrect();
            resetGame();
        } else if (model.isGameOver()) {
            JOptionPane.showMessageDialog(view, "Game Over! Das Wort war: " + model.getWord());
            statistics.incrementIncorrect();
            resetGame();
        }
    }

    private void resetGame() {
        model.resetGame();
        view.updateView();
    }
}
