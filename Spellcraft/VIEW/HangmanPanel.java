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
    private HangmanModel model;
    private ImageIcon background;

    public HangmanPanel(HangmanModel model) {
        this.model = model;
        this.background = new ImageIcon("Spellcraft/Bilder/Hangman Hintergrundsbild.jpg");
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

        if (model.getWrongGuesses() > 0) g.fillOval(centerX, 210, 35, 35);
        if (model.getWrongGuesses() > 1) g.drawLine(centerX + 20, 250, centerX + 20, 300);
        if (model.getWrongGuesses() > 2) g.drawLine(centerX + 20, 260, centerX - 10, 290);
        if (model.getWrongGuesses() > 3) g.drawLine(centerX + 20, 260, centerX + 50, 290);
        if (model.getWrongGuesses() > 4) g.drawLine(centerX + 20, 300, centerX - 10, 330);
        if (model.getWrongGuesses() > 5) g.drawLine(centerX + 20, 300, centerX + 50, 330);
    }
}

