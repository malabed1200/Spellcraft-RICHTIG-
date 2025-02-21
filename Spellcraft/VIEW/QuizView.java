package VIEW;

import CONTROLLER.QuizController;
import MODEL.Question;
import MODEL.QuestionManager;
import MODEL.Statistics;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class QuizView extends JFrame {
    private QuestionManager questionManager;
    private Statistics statistics;
    private Question currentQuestion;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton, backButton;
    private int currentQuestionIndex = 0;
    private QuizController controller;

    public QuizView(QuizController controller, Statistics statistics) {
        this.controller = controller;
        this.statistics = statistics;
        this.questionManager = new QuestionManager();
        questionManager.loadQuestions(); // Fragen laden

        setTitle("Quiz");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setLocationRelativeTo(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Frage anzeigen
        currentQuestion = questionManager.getQuestion(currentQuestionIndex);
        questionLabel = new JLabel(currentQuestion != null ? currentQuestion.getQuestionText() : "Keine Fragen verfügbar!");
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setBounds(50, 50, 700, 30);
        backgroundPanel.add(questionLabel);

        // Eingabefeld für die Antwort
        answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 18));
        answerField.setBounds(50, 100, 300, 40);
        backgroundPanel.add(answerField);

        // Absenden-Button
        Button buttonFactory = new Button();
        submitButton = buttonFactory.createButton("ABSENDEN");
        submitButton.setBounds(50, 160, 120, 40);
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(controller);
        backgroundPanel.add(submitButton);

        // Zurück-Button
        backButton = buttonFactory.createButton("ZURÜCK");
        backButton.setBounds(50, 500, 120, 40);
        backButton.setActionCommand("Back");
        backButton.addActionListener(controller);
        backgroundPanel.add(backButton);

        setVisible(true);
    }

    public void checkAnswer() {
        if (currentQuestion != null) {
            String userAnswer = answerField.getText().trim();
            if (currentQuestion.checkAnswer(userAnswer)) {
                JOptionPane.showMessageDialog(this, "Richtig!");
                statistics.incrementCorrect();
            } else {
                JOptionPane.showMessageDialog(this, "Falsch! Die richtige Antwort war: " + currentQuestion.getQuestionText());
                statistics.incrementIncorrect();
            }
            nextQuestion();
        }
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        currentQuestion = questionManager.getQuestion(currentQuestionIndex);
        if (currentQuestion != null) {
            questionLabel.setText(currentQuestion.getQuestionText());
            answerField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Quiz beendet!");
            dispose();
        }
    }
}
