package VIEW;

import CONTROLLER.QuizController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import VIEW.MORE.CustomTextField;

import javax.swing.*;
import java.awt.*;

public class QuizView extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton, backButton;

    public QuizView(QuizController controller) {
        setTitle("Quiz");
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/QuizHinter.jpg");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Frage anzeigen
        questionLabel = new JLabel("Lade Frage...", SwingConstants.CENTER);
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setBounds(0, 50, 415, 30);
        backgroundPanel.add(questionLabel);

        // Eingabefeld für die Antwort
        answerField = new CustomTextField("Antwort");
        answerField.setBounds(50, 100, 300, 40);
        backgroundPanel.add(answerField);

        // Absenden-Button
        Button buttonFactory = new Button();
        submitButton = buttonFactory.createButton("Mal sehen!");
        submitButton.setBounds(50, 160, 300, 40);
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(controller); // Controller übernimmt die Steuerung
        backgroundPanel.add(submitButton);

        // Zurück-Button
        backButton = buttonFactory.createButton("Zurück");
        backButton.setBounds(5, 650, 500, 50);
        backButton.setActionCommand("Back");
        backButton.addActionListener(controller); // Controller übernimmt die Steuerung
        backgroundPanel.add(backButton);

        setVisible(true);
    }

    public void setQuestionText(String text) {
        questionLabel.setText(text);
    }

    public void clearAnswerField() {
        answerField.setText("");
    }

    public String getAnswerText() {
        return answerField.getText().trim();
    }
}
