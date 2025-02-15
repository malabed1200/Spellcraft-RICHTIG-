package VIEW;

import VIEW.MORE.*;

import javax.swing.*;

public class QuestionAddMenu extends JFrame {

    public QuestionAddMenu() {
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
        JButton button2 = buttonFactory.createButton("Back");

        // Buttons zum Hintergrund hinzufügen
        backgroundPanel.add(button1);
        backgroundPanel.add(button2);

        // Erstellen des Textfeldes & JLabels
        CustomTextField textFieldQ = new CustomTextField("Question");
        backgroundPanel.add(textFieldQ);
        //JLabel Label= new CustomLabel("Hallo");

        // Erstellen des Textfeldes & JLabels
        CustomTextField textFieldA = new CustomTextField("Answer");
        backgroundPanel.add(textFieldA);

        int windowWidth = getWidth();
        int windowHeight = getHeight();

        int buttonWidth = 300;
        int buttonHeight = 40;
        int textFieldWidth = 300;
        int textFieldHeight = 30;

        // Textfeld unter den Buttons platzieren
        textFieldQ.setBounds((windowWidth - textFieldWidth) / 2, (windowHeight - textFieldHeight) / 2 - 90, textFieldWidth, textFieldHeight);
        textFieldA.setBounds((windowWidth - textFieldWidth) / 2, (windowHeight - textFieldHeight) / 2 - 30, textFieldWidth, textFieldHeight);

        // Buttons dynamisch zentrieren
        button1.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 30, buttonWidth, buttonHeight);
        button2.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 90, buttonWidth, buttonHeight);

        // Frame anzeigen
        setVisible(true);
    }


    //TEST methode
    public static void main(String[] args) {
        new QuestionAddMenu();
    }
}
