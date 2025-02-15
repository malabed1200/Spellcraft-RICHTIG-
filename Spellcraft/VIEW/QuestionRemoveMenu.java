package VIEW;

import VIEW.MORE.*;

import javax.swing.*;

public class QuestionRemoveMenu extends JFrame {

    public QuestionRemoveMenu() {
        // Erstelle das Hauptfenster
        setTitle("Remove Question");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrundpanel hinzufügen
        //BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\amira\\Downloads\\Bilder111.gif");
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null); // Absolute Positionierung
        setContentPane(backgroundPanel);

        // Buttons hinzufügen
        Button buttonFactory = new Button();
        JButton button1 = buttonFactory.createButton("Remove");
        JButton button2 = buttonFactory.createButton("Back");

        // Buttons zum Hintergrund hinzufügen
        backgroundPanel.add(button1);
        backgroundPanel.add(button2);

        // Erstellen des Textfeldes & JLabels
        CustomTextField textFieldQ = new CustomTextField("Question Number");
        backgroundPanel.add(textFieldQ);

        int windowWidth = getWidth();
        int windowHeight = getHeight();

        int buttonWidth = 300;
        int buttonHeight = 40;
        int textFieldWidth = 300;
        int textFieldHeight = 30;

        // Textfeld unter den Buttons platzieren
        textFieldQ.setBounds((windowWidth - textFieldWidth) / 2, (windowHeight - textFieldHeight) / 2 - 60, textFieldWidth, textFieldHeight);

        // Buttons dynamisch zentrieren
        button1.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2, buttonWidth, buttonHeight);
        button2.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 60, buttonWidth, buttonHeight);

        // Frame anzeigen
        setVisible(true);
    }


    //TEST methode
    public static void main(String[] args) {
        new QuestionRemoveMenu();
    }
}

