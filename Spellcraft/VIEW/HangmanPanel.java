package VIEW;
import MODEL.HangmanModel;

import javax.swing.*;
import java.awt.*;

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

        if (model.getWrongGuesses() > 0) g.fillOval(centerX, 210, 30, 30);
        if (model.getWrongGuesses() > 1) g.drawLine(centerX + 15, 240, centerX + 15, 290);
        if (model.getWrongGuesses() > 2) g.drawLine(centerX + 15, 250, centerX - 20, 280);
        if (model.getWrongGuesses() > 3) g.drawLine(centerX + 15, 250, centerX + 50, 280);
        if (model.getWrongGuesses() > 4) g.drawLine(centerX + 15, 290, centerX - 20, 330);
        if (model.getWrongGuesses() > 5) g.drawLine(centerX + 15, 290, centerX + 50, 330);
    }
}
