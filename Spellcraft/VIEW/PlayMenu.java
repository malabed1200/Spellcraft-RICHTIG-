package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.Statistics;

import javax.swing.*;

public class PlayMenu extends JFrameE {
    private Statistics statistics;

    public PlayMenu(HauptController controller, Statistics statistics) {
        this.statistics = statistics;

        setTitle("Play Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        Button buttonFactory = new Button();
        JButton hangmanButton = buttonFactory.createButton("HANGMAN");
        hangmanButton.setActionCommand("Hangman");
        hangmanButton.addActionListener(controller);

        JButton quizButton = buttonFactory.createButton("QUIZ");
        quizButton.setActionCommand("Quiz");
        quizButton.addActionListener(controller);

        JButton guessButton = buttonFactory.createButton("ERRATE DAS BILD");
        guessButton.setActionCommand("GuessThePic");
        guessButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("ZURÜCK");
        backButton.setActionCommand("BackH");
        backButton.addActionListener(controller);

        backgroundPanel.add(hangmanButton);
        backgroundPanel.add(quizButton);
        backgroundPanel.add(guessButton);
        backgroundPanel.add(backButton);

        setLayout(null);
        int buttonWidth = 300;
        int buttonHeight = 40;
        int centerX = (getWidth() - buttonWidth) / 2;
        int centerY = (getHeight() - buttonHeight) / 2;

        hangmanButton.setBounds(centerX, centerY - 80, buttonWidth, buttonHeight);
        quizButton.setBounds(centerX, centerY - 20, buttonWidth, buttonHeight);
        guessButton.setBounds(centerX, centerY + 40, buttonWidth, buttonHeight);
        backButton.setBounds(centerX, centerY + 100, buttonWidth, buttonHeight);

        setVisible(true);
    }

    public void updateTextAnswer() {}

    public JTextField[] getTextfield() { return null; }
}
