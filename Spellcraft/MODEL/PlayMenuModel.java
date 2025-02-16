package MODEL;

import VIEW.HangmanView;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import VIEW.QuizView;
import VIEW.MainMenu;

import javax.swing.*;

public class PlayMenuModel extends JFrame {
    private Statistics statistics;

    public PlayMenuModel(Statistics statistics) {
        this.statistics = statistics;

        setTitle("Play Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Button Factory nutzen
        Button buttonFactory = new Button();
        JButton hangmanButton = buttonFactory.createButton("Hangman");
        JButton quizButton = buttonFactory.createButton("Quiz");
        JButton backButton = buttonFactory.createButton("Zurück"); // Neuer Zurück-Button

        // Buttons hinzufügen
        backgroundPanel.add(hangmanButton);
        backgroundPanel.add(quizButton);
        backgroundPanel.add(backButton); // Zurück-Button hinzufügen

        // Button-Positionierung
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        hangmanButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 80, buttonWidth, buttonHeight);
        quizButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 20, buttonWidth, buttonHeight);
        backButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 40, buttonWidth, buttonHeight); // "Zurück" unter den anderen

        // ActionListener für Hangman-Button
        hangmanButton.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                HangmanModel model = new HangmanModel();
                HangmanView view = new HangmanView(model, statistics);
                view.setVisible(true);
            });
        });

        // ActionListener für Quiz-Button
        quizButton.addActionListener(e -> {
            dispose();
            new QuizView(statistics);
        });

        // ActionListener für Zurück-Button (führt zum MainMenu zurück)
        backButton.addActionListener(e -> {
            dispose();
            new MainMenu(statistics);
        });

        setVisible(true);
    }
}
