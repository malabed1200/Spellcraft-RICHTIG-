package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class PlayMenu extends JFrameE {
    public PlayMenu(HauptController controller) {
        setTitle("Play Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        Button buttonFactory = new Button();
        JButton hangmanButton = buttonFactory.createButton("Hangman");
        hangmanButton.setActionCommand("Play Hangman");
        hangmanButton.addActionListener(controller);

        JButton quizButton = buttonFactory.createButton("Quiz");
        quizButton.setActionCommand("Play Quiz");
        quizButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("Back");
        backButton.setActionCommand("BackH");
        backButton.addActionListener(controller);

        backgroundPanel.add(hangmanButton);
        backgroundPanel.add(quizButton);
        backgroundPanel.add(backButton);

        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        hangmanButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 80, buttonWidth, buttonHeight);
        quizButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 20, buttonWidth, buttonHeight);
        backButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 40, buttonWidth, buttonHeight);

        setVisible(true);
    }

    public void updateTextAnswer() {}

    public JTextField[] getTextfield() { return null; }
}
