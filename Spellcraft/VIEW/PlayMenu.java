package VIEW;

import CONTROLLER.HangmanController;
import CONTROLLER.HauptController;
import CONTROLLER.QuizController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.Statistics;

import javax.swing.*;

public class PlayMenu extends JFrameE {
    private Statistics statistics;  // Statistik speichern

    public PlayMenu(HauptController controller, Statistics statistics) {
        this.statistics = statistics;

        setTitle("Play Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        Button buttonFactory = new Button();
        JButton hangmanButton = buttonFactory.createButton("Hangman");
        hangmanButton.addActionListener(e -> {
            dispose();  // Schließt PlayMenu
            new HangmanController(statistics).startGame();  // Startet Hangman über den Controller
        });

        JButton quizButton = buttonFactory.createButton("Quiz");
        quizButton.addActionListener(e -> {
            dispose();  // Schließt PlayMenu
            new QuizController(statistics).startGame();  // Startet das Quiz über den Controller
        });

        JButton backButton = buttonFactory.createButton("Back");
        backButton.addActionListener(e -> {
            dispose();  // PlayMenu schließen
            new MainMenu(controller);  // Zurück zum MainMenu
        });


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
