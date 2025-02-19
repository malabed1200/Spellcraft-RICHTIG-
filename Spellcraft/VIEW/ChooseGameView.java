package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.Statistics;

import javax.swing.*;

public class ChooseGameView extends JFrameE {

    public ChooseGameView(HauptController controller) {
        setTitle("Choose Game");
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
        hangmanButton.setActionCommand("HangmanStart");
        hangmanButton.addActionListener(controller);

        JButton quizButton = buttonFactory.createButton("Quiz");
        quizButton.setActionCommand("QuizStart");
        quizButton.addActionListener(controller);

        JButton removeQuestionButton = buttonFactory.createButton("Quiz");
        removeQuestionButton.setActionCommand("QuizStart");
        removeQuestionButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("Back"); // Umbenannter Button
        backButton.setActionCommand("BackH");
        backButton.addActionListener(controller);

        // Buttons hinzufügen
        backgroundPanel.add(hangmanButton);
        backgroundPanel.add(quizButton);
        backgroundPanel.add(quizButton);
        backgroundPanel.add(backButton);

        // Button-Positionierung
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        addQuestionButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 80, buttonWidth, buttonHeight);
        removeQuestionButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 20, buttonWidth, buttonHeight);
        backButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 40, buttonWidth, buttonHeight);

        setVisible(true);
    }

    public void updateTextAnswer(){}

    public JTextField[] getTextfield(){return null;}
}
