package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.PlayMenuModel;
import MODEL.Statistics;

import javax.swing.*;

public class MainMenu extends JFrameE {

    public MainMenu(HauptController controller) {
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
        playButton.setActionCommand("Play");
        playButton.addActionListener(controller);

        JButton statsButton = buttonFactory.createButton("Stats");
        statsButton.setActionCommand("Stats");
        statsButton.addActionListener(controller);

        JButton optionsButton = buttonFactory.createButton("Options");
        optionsButton.setActionCommand("Options");
        optionsButton.addActionListener(controller);

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

        setVisible(true);
    }

    public void updateTextAnswer(){}

    public JTextField[] getTextfield(){return null;}
}
