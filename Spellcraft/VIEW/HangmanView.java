package VIEW;

import MODEL.HangmanModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

// View: Stellt die GUI dar
public class HangmanView extends JFrame {
    private JLabel wordLabel, categoryLabel;
    private JPanel keyboardPanel;
    private HangmanPanel hangmanPanel;
    private ImageIcon background;
    private JButton menuButton;
    private HangmanModel model;

    public HangmanView(HangmanModel model) {
        this.model = model;

        setTitle("Hangman Game");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        background = new ImageIcon("/mnt/data/image.png");

        JPanel topPanel = new JPanel(new BorderLayout());
        categoryLabel = new JLabel("Category: " + model.getCategory(), SwingConstants.CENTER);
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(Color.ORANGE);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(categoryLabel, BorderLayout.CENTER);

        menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Arial", Font.BOLD, 14));
        menuButton.addActionListener(e -> openMenu());
        topPanel.add(menuButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        wordLabel = new JLabel(model.getMaskedWord(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(wordLabel, BorderLayout.NORTH);

        hangmanPanel = new HangmanPanel(model);
        add(hangmanPanel, BorderLayout.CENTER);

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
            resetGame();
        } else if (model.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Game Over! Das Wort war: " + model.getWord());
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

    private void openMenu() {
        JDialog menuDialog = new JDialog(this, "Menu", true);
        menuDialog.setSize(200, 150);
        menuDialog.setLayout(new FlowLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> menuDialog.dispose());
        menuDialog.add(backButton);

        menuDialog.setLocationRelativeTo(this);
        menuDialog.setVisible(true);
    }

    public void updateView() {
        wordLabel.setText(model.getMaskedWord());
        hangmanPanel.repaint();
    }
}
