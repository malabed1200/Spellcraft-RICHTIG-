package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class OptionsMenu extends JFrameE {

    public OptionsMenu(HauptController controller) {
        setTitle("Options Menu");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrund setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(new GridBagLayout()); // Gleiche Struktur wie MainMenu
        setContentPane(backgroundPanel);

        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton addQuestionButton = buttonFactory.createButton("Fragen hinzufügen");
        addQuestionButton.setActionCommand("Add Question");
        addQuestionButton.addActionListener(controller);

        JButton removeQuestionButton = buttonFactory.createButton("Frage entfernen");
        removeQuestionButton.setActionCommand("Remove Question");
        removeQuestionButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("Zurück");
        backButton.setActionCommand("BackH");
        backButton.addActionListener(controller);

        // Panel für die Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 10)); // 3 Reihen, 1 Spalte, Abstand 10px
        buttonPanel.setOpaque(false); // Hintergrund durchsichtig
        buttonPanel.add(addQuestionButton);
        buttonPanel.add(removeQuestionButton);
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
