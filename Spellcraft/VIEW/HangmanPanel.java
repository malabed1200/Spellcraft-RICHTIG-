package VIEW;
import MODEL.HangmanModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;


// HangmanPanel: Zeichnet den Hangman
class HangmanPanel extends JPanel {
    private ImageIcon background;
    private int wrongG=0;

    public HangmanPanel() {
        this.background = new ImageIcon("Spellcraft/Bilder/Hangman Hintergrundsbild.jpg");
    }

    public void addWrongGuesses() {
        this.wrongG+=1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(10));

        int centerX = getWidth() / 2 - 70;
        int baseY = 380;

        g.drawLine(centerX - 40, baseY, centerX + 40, baseY);
        g.drawLine(centerX - 20, 180, centerX - 20, baseY);
        g.drawLine(centerX - 20, 180, centerX + 20, 180);
        g.drawLine(centerX + 20, 180, centerX + 20, 210);

        if (wrongG > 0) g.fillOval(centerX, 210, 30, 30);
        if (wrongG > 1) g.drawLine(centerX + 15, 240, centerX + 15, 290);
        if (wrongG > 2) g.drawLine(centerX + 15, 250, centerX - 20, 280);
        if (wrongG > 3) g.drawLine(centerX + 15, 250, centerX + 50, 280);
        if (wrongG > 4) g.drawLine(centerX + 15, 290, centerX - 20, 330);
        if (wrongG > 5) g.drawLine(centerX + 15, 290, centerX + 50, 330);
    }
}
