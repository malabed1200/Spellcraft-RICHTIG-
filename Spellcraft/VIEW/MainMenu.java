package VIEW;

import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        // Erstelle das Hauptfenster
        setTitle("SPELLCRAFT");//wassolldas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrundpanel hinzufügen
        //BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\amira\\Downloads\\Bilder111.gif");
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Main_Menu.png");
        backgroundPanel.setLayout(null); // Absolute Positionierung
        setContentPane(backgroundPanel);

        // Buttons hinzufügen
        Button buttonFactory = new Button();
        JButton button1 = buttonFactory.createButton("Play");
        JButton button2 = buttonFactory.createButton("Stats");
        JButton button3 = buttonFactory.createButton("Options");

        // Buttons zum Hintergrund hinzufügen
        backgroundPanel.add(button1);
        backgroundPanel.add(button2);
        backgroundPanel.add(button3);

        int windowWidth = getWidth();
        int windowHeight = getHeight();

        int buttonWidth = 300;
        int buttonHeight = 40;

        // Buttons dynamisch zentrieren
        button1.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 - 60, buttonWidth, buttonHeight);
        button2.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2, buttonWidth, buttonHeight);
        button3.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 60, buttonWidth, buttonHeight);

        // Frame anzeigen
        setVisible(true);
    }


    //TEST methode
    public static void main(String[] args) {
        new MainMenu();
    }
}

// Benutzerdefiniertes JPanel für den flexiblen Hintergrund

