package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import VIEW.MORE.CustomTextField;

import javax.swing.*;
import java.awt.*;

public class QuestionAddMenu extends JFrameE {
    private JTextField questionField;
    private JTextField answerField;

    public QuestionAddMenu(HauptController controller) {
        setTitle("Add Question");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrund setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(new GridBagLayout()); // Gleiche Struktur wie MainMenu
        setContentPane(backgroundPanel);

        // Textfelder für Frage und Antwort
        questionField = new CustomTextField("FRAGE");
        answerField = new CustomTextField("ANTWORT");


        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton addButton = buttonFactory.createButton("HINZUFÜGEN");
        addButton.setActionCommand("Add");
        addButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("ZURÜCK");
        backButton.setActionCommand("Back");
        backButton.addActionListener(controller);

        // Panel für die Elemente
        JPanel inputPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        inputPanel.setOpaque(false);
        inputPanel.add(questionField);
        inputPanel.add(answerField);
        inputPanel.add(addButton);
        inputPanel.add(backButton);

        // Alles in die Mitte positionieren
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        backgroundPanel.add(inputPanel, gbc);

        setVisible(true);
    }

    public void updateTextAnswer() {
        questionField.setText("");
        answerField.setText("");
    }

    public JTextField[] getTextfield() {
        return new JTextField[]{questionField, answerField};
    }
}
