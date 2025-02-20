package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrameE {

    public MainMenu(HauptController controller) {
        setTitle("SPELLCRAFT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Hintergrund setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Main_Menu.png");
        backgroundPanel.setLayout(new GridBagLayout()); // GridBagLayout ermöglicht zentrierte Skalierung
        setContentPane(backgroundPanel);

        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton playButton = buttonFactory.createButton("Play");
        playButton.setActionCommand("Play");
        playButton.addActionListener(controller);

        JButton statsButton = buttonFactory.createButton("Stats");
        statsButton.setActionCommand("Stats");
        statsButton.addActionListener(controller);

        JButton optionsButton = buttonFactory.createButton("Options");
        optionsButton.setActionCommand("Options");
        optionsButton.addActionListener(controller);

        // Panel für die Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 10)); // 3 Reihen, 1 Spalte, 10 Pixel Abstand
        buttonPanel.setOpaque(false); // Hintergrund durchsichtig
        buttonPanel.add(playButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(optionsButton);

        // Zentrieren mit GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        backgroundPanel.add(buttonPanel, gbc);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Startet direkt im Fullscreen-Modus
        setVisible(true);
    }

    public void updateTextAnswer() {}

    public JTextField[] getTextfield() { return null; }
}
