package VIEW;

import CONTROLLER.HauptController;
import VIEW.MORE.*;

import javax.swing.*;

public class QuestionRemoveMenu extends JFrameE {
    private JTextField textField;

    public QuestionRemoveMenu(HauptController controller) {
        // Erstelle das Hauptfenster
        setTitle("Remove Question");
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
        JButton button1 = buttonFactory.createButton("Remove");
        button1.setActionCommand("Remove");
        button1.addActionListener(controller);

        JButton button2 = buttonFactory.createButton("Back");
        button2.setActionCommand("Back");
        button2.addActionListener(controller);

        // Buttons zum Hintergrund hinzufügen
        backgroundPanel.add(button1);
        backgroundPanel.add(button2);

        // Erstellen des Textfeldes & JLabels
        textField = new CustomTextField("Question Number");
        backgroundPanel.add(textField);
        textField.setEditable(true);

        int windowWidth = getWidth();
        int windowHeight = getHeight();

        int buttonWidth = 300;
        int buttonHeight = 40;
        int textFieldWidth = 300;
        int textFieldHeight = 30;

        // Textfeld unter den Buttons platzieren
        textField.setBounds((windowWidth - textFieldWidth) / 2, (windowHeight - textFieldHeight) / 2 - 60, textFieldWidth, textFieldHeight);

        // Buttons dynamisch zentrieren
        button1.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2, buttonWidth, buttonHeight);
        button2.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 60, buttonWidth, buttonHeight);

        // Frame anzeigen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void updateTextAnswer(){
        textField.setText("");
    }

    public JTextField[] getTextfield(){
        return new JTextField []{textField};
    }
}

