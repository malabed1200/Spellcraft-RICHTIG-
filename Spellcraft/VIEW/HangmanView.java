package VIEW;

import CONTROLLER.HangmanController;
import MODEL.HangmanModel;
import MODEL.Statistics;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class HangmanView extends JFrame {
    private JLabel wordLabel, categoryLabel;
    private JPanel keyboardPanel;
    private HangmanPanel hangmanPanel;

    private JButton backButton, resetButton;
    private HangmanController controller;

    public HangmanView(HangmanController controller) {
        this.controller = controller;

        setTitle("Hangman Game");
        setSize(800, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        // Oberer Bereich mit Kategorie und Zurück-Button
        JPanel topPanel = new JPanel(new BorderLayout());
        categoryLabel = new JLabel("", SwingConstants.CENTER);
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(Color.ORANGE);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(categoryLabel, BorderLayout.CENTER);

        // Zurück-Button
        Button buttonFactory = new Button();
        backButton = buttonFactory.createButton("Zurück");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.setActionCommand("Back");
        backButton.addActionListener(controller);
        topPanel.add(backButton, BorderLayout.WEST);

        add(topPanel, BorderLayout.NORTH);

        // Hangman-Panel (Zeichnung)
        hangmanPanel = new HangmanPanel();
        add(hangmanPanel, BorderLayout.CENTER);

        // Tastatur unten (Events durch Controller)
        keyboardPanel = new JPanel(new GridLayout(4, 7));
        addKeyboard();
        add(keyboardPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addKeyboard() {
        for (char c = 'A'; c <= 'Z'; c++) {
            JButton button = new JButton(String.valueOf(c));
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setActionCommand("Letter_" + c);
            button.addActionListener(controller);
            keyboardPanel.add(button);
        }
    }

    public void updateView(String text, int wrongGuesses) {
        categoryLabel.setText(text);
        if(wrongGuesses>0){hangmanPanel.addWrongGuesses();}
        hangmanPanel.repaint();
    }

    public void setCategoryLabel(String text){
        this.categoryLabel.setText(text);
    }
}
