package VIEW;

import javax.swing.*;
import java.awt.*;

class HangmanPanel extends JPanel {
    private Image background; // Hintergrundbild
    private int wrongG = 0;
    private final Image[] steveParts;

    public HangmanPanel() {
        // Hintergrundbild laden
        this.background = new ImageIcon("Spellcraft/Bilder/hinter33.png").getImage();

        // Steve-Körperteile laden und skalieren
        this.steveParts = new Image[] {
                new ImageIcon("Spellcraft/Bilder/Kopf(1).png").getImage(),      // Kopf
                new ImageIcon("Spellcraft/Bilder/Koerper(2).png").getImage(),   // Körper
                new ImageIcon("Spellcraft/Bilder/LinkeArm (3).png").getImage(), // Linker Arm
                new ImageIcon("Spellcraft/Bilder/RechteArm(4).png").getImage(), // Rechter Arm
                new ImageIcon("Spellcraft/Bilder/LinkeFuss(5).png").getImage(), // Linker Fuß
                new ImageIcon("Spellcraft/Bilder/RechteFuss(6).png").getImage() // Rechter Fuß
        };

        setOpaque(false); // Verhindert, dass das Panel den Hintergrund überdeckt
    }

    public void addWrongGuesses() {
        this.wrongG += 1;
        repaint(); // Neu zeichnen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrundbild zeichnen (Skaliert auf Panel-Größe)
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        // Position von Steve (leicht angepasst)
        int centerX = getWidth() / 2 - 28; // Nach rechts verschoben für bessere Zentrierung
        int baseY = 210; // Steve 5% höher (vorher 220 → jetzt 210)
        int armWidth = 28; // Arme 20% kleiner gemacht
        int bodyWidth = 56; // Körper 20% kleiner
        int bodyHeight = 84; // Körper 20% kleiner
        int legWidth = 28; // Beine 20% kleiner
        int legHeight = 56; // Beine 20% kleiner

        // Steve-Teile zeichnen (5% nach oben geschoben)
        if (wrongG > 0) g.drawImage(steveParts[0], centerX, baseY, 56, 56, this); // Kopf (56x56)
        if (wrongG > 1) g.drawImage(steveParts[1], centerX, baseY + 56, bodyWidth, bodyHeight, this); // Körper (56x84)
        if (wrongG > 2) g.drawImage(steveParts[2], centerX - armWidth, baseY + 56, armWidth, bodyHeight, this); // Linker Arm (28x84)
        if (wrongG > 3) g.drawImage(steveParts[3], centerX + bodyWidth, baseY + 56, armWidth, bodyHeight, this); // Rechter Arm (28x84)
        if (wrongG > 4) g.drawImage(steveParts[4], centerX, baseY + 140, legWidth, legHeight, this); // Linkes Bein (28x56)
        if (wrongG > 5) g.drawImage(steveParts[5], centerX + legWidth, baseY + 140, legWidth, legHeight, this); // Rechtes Bein (28x56)
    }
}
