package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import VIEW.MORE.CustomTextField;

import javax.swing.*;
import java.awt.*;

public class QuestionRemoveMenu extends JFrameE {
    private JTextField textField;

    public QuestionRemoveMenu(HauptController controller) {
        setTitle("Remove Question");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hintergrund setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(new GridBagLayout()); // Gleiche Struktur wie MainMenu
        setContentPane(backgroundPanel);

        // Textfeld für Eingabe
        textField = new CustomTextField("NUMMER");

        // Buttons erstellen
        Button buttonFactory = new Button();
        JButton removeButton = buttonFactory.createButton("ENTFERNEN");
        removeButton.setActionCommand("Remove");
        removeButton.addActionListener(controller);

        JButton backButton = buttonFactory.createButton("ZURÜCK");
        backButton.setActionCommand("Back");
        backButton.addActionListener(controller);

        // Panel für die Elemente
        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 0, 10));
        inputPanel.setOpaque(false);
        inputPanel.add(textField);
        inputPanel.add(removeButton);
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
        textField.setText("");
    }

    public JTextField[] getTextfield() {
        return new JTextField[]{textField};
    }
}
