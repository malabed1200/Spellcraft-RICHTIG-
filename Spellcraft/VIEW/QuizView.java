package VIEW;

import CONTROLLER.QuizController;
import MODEL.Statistics;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class QuizView extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton, backButton;
    private QuizController controller;

    public QuizView(QuizController controller, Statistics statistics) {
        this.controller = controller;

        setTitle("Quiz");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        questionLabel = new JLabel("Lade Frage...");
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setBounds(50, 50, 700, 30);
        backgroundPanel.add(questionLabel);

        answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 18));
        answerField.setBounds(50, 100, 300, 40);
        backgroundPanel.add(answerField);

        Button buttonFactory = new Button();
        submitButton = buttonFactory.createButton("Absenden");
        submitButton.setBounds(50, 160, 120, 40);
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(controller);
        backgroundPanel.add(submitButton);

        backButton = buttonFactory.createButton("Zurück");
        backButton.setBounds(50, 500, 120, 40);
        backButton.setActionCommand("Back");
        backButton.addActionListener(controller);
        backgroundPanel.add(backButton);

        setVisible(true);
    }

    public String getAnswerText() {
        return answerField.getText().trim();
    }

    public void setQuestionText(String question) {
        questionLabel.setText(question);
    }
}
