package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.Statistics;

import javax.swing.*;
import java.awt.*;

public class PlayMenu extends JFrameE {
    public PlayMenu(HauptController controller) {

        setTitle("Play Menu");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrund setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(new GridBagLayout()); // Gleiche Struktur wie MainMenu
        setContentPane(backgroundPanel);

        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton hangmanButton = buttonFactory.createButton("Hangman");
        hangmanButton.setActionCommand("Hangman");
        hangmanButton.addActionListener(controller);

        JButton quizButton = buttonFactory.createButton("Quiz");
        quizButton.setActionCommand("Quiz");
        quizButton.addActionListener(controller);

        JButton guessButton = buttonFactory.createButton("Was ist das?");
        guessButton.setActionCommand("GuessThePic");
        guessButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("Zurück");
        backButton.setActionCommand("BackH");
        backButton.addActionListener(controller);

        // Panel für die Buttons (gleiche Struktur wie in MainMenu)
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10)); // 4 Reihen, 1 Spalte, Abstand 10px
        buttonPanel.setOpaque(false); // Hintergrund durchsichtig
        buttonPanel.add(hangmanButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(guessButton);
        buttonPanel.add(backButton);

        // Buttons in der Mitte positionieren
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        backgroundPanel.add(buttonPanel, gbc);

        setVisible(true);
    }

    public void updateTextAnswer() {}

    public JTextField[] getTextfield() { return null; }
}
