package VIEW;

import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import MODEL.Statistics;

import javax.swing.*;

public class OptionsMenu extends JFrame {
    private Statistics statistics;

    public OptionsMenu(Statistics statistics) {
        this.statistics = statistics;

        setTitle("Minecraft Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Button Factory nutzen
        Button buttonFactory = new Button();
        JButton addQuestionButton = buttonFactory.createButton("Add Question");
        JButton removeQuestionButton = buttonFactory.createButton("Remove Question");
        JButton backButton = buttonFactory.createButton("Zurück"); // Umbenannter Button

        // Buttons hinzufügen
        backgroundPanel.add(addQuestionButton);
        backgroundPanel.add(removeQuestionButton);
        backgroundPanel.add(backButton);

        // Button-Positionierung
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        addQuestionButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 80, buttonWidth, buttonHeight);
        removeQuestionButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 20, buttonWidth, buttonHeight);
        backButton.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 40, buttonWidth, buttonHeight);

        // ActionListener für "Zurück"-Button → Zurück zum MainMenu mit Statistik
        backButton.addActionListener(e -> {
            dispose();
            new MainMenu(statistics);
        });

        setVisible(true);
    }
}
