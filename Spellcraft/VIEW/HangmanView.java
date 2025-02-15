package VIEW;
import MODEL.HangmanModel;

import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanView {
    private JFrame frame;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JTextField inputField;
    private JButton guessButton;
    private HangmanModel model;

    public HangmanView(HangmanModel model) {
        this.model = model;
        frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        wordLabel = new JLabel(model.getMaskedWord(), SwingConstants.CENTER);
        attemptsLabel = new JLabel("Versuche übrig: " + model.getAttemptsLeft(), SwingConstants.CENTER);
        inputField = new JTextField();
        guessButton = new JButton("Rate");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText().toLowerCase();
                if (text.length() == 1) {
                    model.guessLetter(text.charAt(0));
                    updateView();
                }
                inputField.setText("");
            }
        });

        frame.add(wordLabel);
        frame.add(attemptsLabel);
        frame.add(inputField);
        frame.add(guessButton);

        frame.setVisible(true);
    }

    public void updateView() {
        wordLabel.setText(model.getMaskedWord());
        attemptsLabel.setText("Versuche übrig: " + model.getAttemptsLeft());
        if (model.isGameOver()) {
            JOptionPane.showMessageDialog(frame, model.isWordGuessed() ? "Gewonnen!" : "Verloren! Das Wort war: " + model.getMaskedWord());
            frame.dispose();
        }
    }
}