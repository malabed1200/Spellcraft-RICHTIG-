package MODEL;

import VIEW.HangmanView;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.Question;
import MODEL.QuestionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenuModel extends JFrame {

    public PlayMenuModel() {
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

        // Buttons hinzufügen
        backgroundPanel.add(hangmanButton);
        backgroundPanel.add(quizButton);

        // Button-Positionierung
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        hangmanButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 60, buttonWidth, buttonHeight);
        quizButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2, buttonWidth, buttonHeight);

        // ActionListener für Hangman-Button
        hangmanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Schließt das aktuelle Fenster
                SwingUtilities.invokeLater(() -> {
                    HangmanModel model = new HangmanModel();
                    HangmanView view = new HangmanView(model);
                    view.setVisible(true);
                });
            }
        });

        // ActionListener für Quiz-Button
        quizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuestionManager questionManager = new QuestionManager();
                questionManager.loadQuestions(); // Lädt Fragen
                Question question = questionManager.getQuestion(0); // Erste Frage abrufen

                if (question != null) {
                    JOptionPane.showMessageDialog(null, "Frage: " + question.getQuestionText());
                } else {
                    JOptionPane.showMessageDialog(null, "Keine Fragen verfügbar!");
                }
            }
        });

        setVisible(true);
    }


}
