package VIEW;

import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.PlayMenuModel;

import javax.swing.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        // Hauptfenster
        setTitle("SPELLCRAFT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrund
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Main_Menu.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton playButton = buttonFactory.createButton("Play");
        JButton statsButton = buttonFactory.createButton("Stats");
        JButton optionsButton = buttonFactory.createButton("Options");

        // Buttons hinzufügen
        backgroundPanel.add(playButton);
        backgroundPanel.add(statsButton);
        backgroundPanel.add(optionsButton);

        // Button-Größe & Position
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        playButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 60, buttonWidth, buttonHeight);
        statsButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2, buttonWidth, buttonHeight);
        optionsButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 60, buttonWidth, buttonHeight);

        // ActionListener für Play
        playButton.addActionListener(e -> {
            dispose();
            new PlayMenuModel();
        });

        // ActionListener für Stats
        statsButton.addActionListener(e -> showStats());

        // ActionListener für Options
        optionsButton.addActionListener(e -> {
            dispose();
            new OptionsMenu();
        });

        setVisible(true);
    }

    private void showStats() {
        JOptionPane.showMessageDialog(this, "Statistiken werden hier später angezeigt!");
    }


}
