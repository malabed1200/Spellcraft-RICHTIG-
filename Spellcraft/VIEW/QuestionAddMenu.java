package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class QuestionAddMenu extends JFrameE {
    private JTextField textField;
    private JTextField textField1;

    public QuestionAddMenu(HauptController controller) {
        // Erstelle das Hauptfenster
        setTitle("Add Question");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrundpanel hinzufügen
        //BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\amira\\Downloads\\Bilder111.gif");
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null); // Absolute Positionierung
        setContentPane(backgroundPanel);

        // Buttons hinzufügen
        Button buttonFactory = new Button();
        JButton button1 = buttonFactory.createButton("Add");
        button1.setActionCommand("Add");
        button1.addActionListener(controller);

        JButton button2 = buttonFactory.createButton("Back");
        button2.setActionCommand("Options");
        button2.addActionListener(controller);

        // Buttons zum Hintergrund hinzufügen
        backgroundPanel.add(button1);
        backgroundPanel.add(button2);

        // Erstellen des Textfeldes & JLabels
        textField = new CustomTextField("Question");
        backgroundPanel.add(textField);

        // Erstellen des Textfeldes & JLabels
        textField1 = new CustomTextField("Answer");
        backgroundPanel.add(textField1);

        int windowWidth = getWidth();
        int windowHeight = getHeight();

        int buttonWidth = 300;
        int buttonHeight = 40;
        int textFieldWidth = 300;
        int textFieldHeight = 30;

        // Textfeld unter den Buttons platzieren
        textField.setBounds((windowWidth - textFieldWidth) / 2, (windowHeight - textFieldHeight) / 2 - 90, textFieldWidth, textFieldHeight);
        textField1.setBounds((windowWidth - textFieldWidth) / 2, (windowHeight - textFieldHeight) / 2 - 30, textFieldWidth, textFieldHeight);

        // Buttons dynamisch zentrieren
        button1.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 30, buttonWidth, buttonHeight);
        button2.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 90, buttonWidth, buttonHeight);

        // Frame anzeigen
        setVisible(true);
    }

    public void updateTextAnswer(){
        textField.setText("");
        textField1.setText("");
    }

    public JTextField[] getTextfield(){
        return new JTextField []{textField,textField1};
    }
}
