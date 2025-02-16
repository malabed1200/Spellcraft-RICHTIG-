package VIEW;

import MODEL.HangmanModel;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class HangmanView extends JFrame {
    private JLabel wordLabel, categoryLabel;
    private JPanel keyboardPanel;
    private HangmanPanel hangmanPanel;
    private JButton backButton;
    private HangmanModel model;

    public HangmanView(HangmanModel model) {
        this.model = model;

        setTitle("Hangman Game");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Hintergrund als Fullscreen setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Hangman_Hintergrund.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        // Obere Leiste mit Kategorie
        JPanel topPanel = new JPanel(new BorderLayout());
        categoryLabel = new JLabel("ANIMALS", SwingConstants.CENTER);
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(Color.ORANGE);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(categoryLabel, BorderLayout.CENTER);

        // "Zurück"-Button oben rechts
        Button buttonFactory = new Button();
        backButton = buttonFactory.createButton("Zurück");
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.addActionListener(e -> goToMainMenu());
        topPanel.add(backButton, BorderLayout.EAST);

        backgroundPanel.add(topPanel, BorderLayout.NORTH);

        // Wort-Anzeige direkt unter Kategorie
        wordLabel = new JLabel(model.getMaskedWord(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 32));
        backgroundPanel.add(wordLabel, BorderLayout.CENTER);

        // Hangman-Zeichnung (fullscreen angepasst)
        hangmanPanel = new HangmanPanel(model);
        backgroundPanel.add(hangmanPanel, BorderLayout.CENTER);

        // Tastatur füllt gesamten unteren Bereich
        keyboardPanel = new JPanel(new GridLayout(4, 7, 5, 5)); // Abstände entfernt
        backgroundPanel.add(keyboardPanel, BorderLayout.SOUTH);
        addKeyboard();

        setVisible(true);
    }

    private void addKeyboard() {
        keyboardPanel.removeAll();
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton button = new JButton(String.valueOf(c));
            button.setFont(new Font("Arial", Font.BOLD, 18));
            char finalC = c;
            button.addActionListener(e -> processGuess(finalC, button));
            keyboardPanel.add(button);
        }
        keyboardPanel.revalidate();
        keyboardPanel.repaint();
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
            resetGame();
        } else if (model.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Game Over! Das Wort war: " + model.getWord());
            resetGame();
        }
    }

    private void resetGame() {
        model.resetGame();
        updateView();
        addKeyboard();
    }

    private void goToMainMenu() {
        this.dispose();
        new MainMenu();
    }

    public void updateView() {
        wordLabel.setText(model.getMaskedWord());
        hangmanPanel.repaint();
    }
}