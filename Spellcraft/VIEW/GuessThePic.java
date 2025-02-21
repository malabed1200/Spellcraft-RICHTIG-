package VIEW;

import CONTROLLER.GuessThePicController;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import VIEW.MORE.CustomTextField;

import javax.swing.*;
import java.awt.*;

public class GuessThePic extends JFrame {

    private JTextField eingabe;
    private JPanel kreisPanel;
    private JPanel bildPanel;
    private JLabel bildLabel;
    private Color[] kreisFarben;

    public GuessThePic(GuessThePicController controller) {
        setTitle("Guess the Pic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/cavewall.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Panel für Kreise erstellen
        kreisPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int radius = 20;
                int gap = 10;
                int totalWidth = (radius * 2 + gap) * kreisFarben.length - gap;
                int startX = (getWidth() - totalWidth) / 2;
                int y = 10;

                for (int i = 0; i < kreisFarben.length; i++) {
                    g.setColor(kreisFarben[i]);
                    g.fillOval(startX + i * (radius * 2 + gap), y, radius * 2, radius * 2);
                }
            }
        };
        kreisPanel.setBounds(0, 0, 800, 50);
        kreisFarben = new Color[10];
        for (int i = 0; i < kreisFarben.length; i++) {
            kreisFarben[i] = Color.WHITE; // Standard auf Weiß
        }
        backgroundPanel.add(kreisPanel);

        // Panel für das Bild erstellen
        bildPanel = new JPanel(new BorderLayout());
        bildPanel.setBounds(250, 100, 300, 300);
        bildLabel = new JLabel();
        bildLabel.setHorizontalAlignment(JLabel.CENTER);
        bildLabel.setVerticalAlignment(JLabel.CENTER);
        bildPanel.add(bildLabel, BorderLayout.CENTER);
        backgroundPanel.add(bildPanel);

        // Button Factory nutzen
        Button buttonFactory = new Button();
        JButton guess = buttonFactory.createButton("Guess");
        guess.setActionCommand("Guess");
        guess.addActionListener(controller);

        // Erstellen des Textfeldes & JLabels
        eingabe = new CustomTextField("Eingabe");
        backgroundPanel.add(eingabe);

        // Buttons hinzufügen
        backgroundPanel.add(guess);

        // Button-Positionierung
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int buttonWidth = 300;
        int buttonHeight = 40;

        eingabe.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 180, buttonWidth, buttonHeight);
        guess.setBounds((windowWidth - buttonWidth) / 2, (windowHeight - buttonHeight) / 2 + 240, buttonWidth, buttonHeight);

        setVisible(true);
    }

    public void updateTextAnswer() {
        this.eingabe.setText("");
    }

    public void setKreisFarbe(int index, Color farbe) {
        if (index >= 0 && index < kreisFarben.length) {
            kreisFarben[index] = farbe;
            kreisPanel.repaint();
        }
    }

    public void setBild(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage().getScaledInstance(bildPanel.getWidth(), bildPanel.getHeight(), Image.SCALE_SMOOTH);
        bildLabel.setIcon(new ImageIcon(image));
    }

    public JTextField getTextfield() {
        return eingabe;
    }
}
