package VIEW;

import MODEL.HangmanModel;
import MODEL.Statistics;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class HangmanView extends JFrame {
    private JLabel wordLabel, categoryLabel;
    private JPanel keyboardPanel;
    private HangmanPanel hangmanPanel;
    private HangmanModel model;
    private Statistics statistics;
    private JButton backButton;

    public HangmanView(HangmanModel model, Statistics statistics) {
        this.model = model;
        this.statistics = statistics;

        setTitle("Hangman Game");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Oberer Bereich mit Kategorie und Zurück-Button
        JPanel topPanel = new JPanel(new BorderLayout());
        categoryLabel = new JLabel("ANIMALS - " + model.getMaskedWord(), SwingConstants.CENTER);
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(Color.ORANGE);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(categoryLabel, BorderLayout.CENTER);

        // Zurück-Button oben links
        Button buttonFactory = new Button();
        backButton = buttonFactory.createButton("Zurück");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(e -> goToMainMenu());
        topPanel.add(backButton, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);

        // Hangman-Panel (Zeichnung)
        hangmanPanel = new HangmanPanel(model);
        add(hangmanPanel, BorderLayout.CENTER);

        // Tastatur unten
        keyboardPanel = new JPanel(new GridLayout(4, 7));
        addKeyboard();
        add(keyboardPanel, BorderLayout.SOUTH);
    }

    private void addKeyboard() {
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton button = new JButton(String.valueOf(c));
            button.setFont(new Font("Arial", Font.BOLD, 18));
            char finalC = c;
            button.addActionListener(e -> processGuess(finalC, button));
            keyboardPanel.add(button);
        }
    }

    private void processGuess(char letter, JButton button) {
        boolean correct = model.guessLetter(letter);
        button.setBackground(correct ? Color.GREEN : Color.RED);
        button.setEnabled(false);
        updateView();
        checkGameStatus();
    }

    private void checkGameStatus() {
        if (model.isWin()) {
            JOptionPane.showMessageDialog(this, "Glückwunsch! Du hast gewonnen!");
            statistics.incrementCorrect(); // Richtige Antwort speichern
            resetGame();
        } else if (model.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Game Over! Das Wort war: " + model.getWord());
            statistics.incrementIncorrect(); // Falsche Antwort speichern
            resetGame();
        }
    }

    private void resetGame() {
        model.resetGame();
        updateView();
        resetKeyboard();
    }

    private void resetKeyboard() {
        keyboardPanel.removeAll();
        addKeyboard();
        keyboardPanel.revalidate();
        keyboardPanel.repaint();
    }

    private void goToMainMenu() {
        this.dispose();
        new MainMenu(statistics); // Zurück zum Hauptmenü mit gespeicherten Statistiken
    }

    public void updateView() {
        categoryLabel.setText("ANIMALS - " + model.getMaskedWord());
        hangmanPanel.repaint();
    }
}
