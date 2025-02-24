package CONTROLLER;

import MODEL.Sound;
import VIEW.HangmanView;
import MODEL.HangmanModel;
import MODEL.Statistics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanController implements ActionListener {
    HauptController hc;

    Sound sound = new Sound();

    private HangmanModel model;
    private Statistics statistics;
    private HangmanView view;

    public HangmanController(HauptController hc) {
        this.hc=hc;

        this.model = new HangmanModel();
        this.statistics = new Statistics();
        startGame();
        hc.shutdown();
    }

    public void startGame() {
        this.view = new HangmanView(this);
        view.setCategoryLabel("TIERE - " + model.getMaskedWord());
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Zurück-Button: Zurück ins PlayMenu
        if (command.equals("Back")) {
            sound.playSound("s1");
            shutdown();
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
        int a=0;
        if(!correct){a=1;}
        view.updateView("TIERE - " + model.getMaskedWord(),a);
        checkGameStatus();
    }

    private void checkGameStatus() {
        if (model.isWin()) {
            sound.playSound("s2");
            JOptionPane.showMessageDialog(view, "Glückwunsch! Du hast gewonnen!");
            statistics.incrementCorrect();
            statistics.save();
            resetGame();
        } else if (model.isGameOver()) {
            sound.playSound("s3");
            JOptionPane.showMessageDialog(view, "Game Over! Das Wort war: " + model.getWord());
            statistics.incrementIncorrect();
            statistics.save();
            resetGame();
        }
    }

    private void resetGame() {
        shutdown();
    }

    public void shutdown() {
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        model = null;
        view = null;
        statistics=null;
        hc.startHC();
    }
}
