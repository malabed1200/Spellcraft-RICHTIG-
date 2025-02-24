package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrameE {

    public MainMenu(HauptController controller) {
        setTitle("SPELLCRAFT");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrund setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Main_Menu.png");
        backgroundPanel.setLayout(new GridBagLayout()); // GridBagLayout für zentrierte Buttons
        setContentPane(backgroundPanel);

        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton playButton = buttonFactory.createButton("Spielen");
        playButton.setActionCommand("Play");
        playButton.addActionListener(controller);

        JButton statsButton = buttonFactory.createButton("Statistik");
        statsButton.setActionCommand("Stats");
        statsButton.addActionListener(controller);

        JButton optionsButton = buttonFactory.createButton("Einstellungen");
        optionsButton.setActionCommand("Options");
        optionsButton.addActionListener(controller);

        JButton exitButton = buttonFactory.createButton("Verlassen"); // Neuer Button
        exitButton.setActionCommand("Exit"); // ActionCommand setzen
        exitButton.addActionListener(controller); // Beendet das Programm

        // Panel für die Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10)); // 4 Reihen, 1 Spalte, Abstand 10px
        buttonPanel.setOpaque(false); // Hintergrund durchsichtig
        buttonPanel.add(playButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitButton); // Schließen-Button hinzufügen

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
