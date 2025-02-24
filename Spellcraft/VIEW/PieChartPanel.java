package VIEW;

import MODEL.Statistics;

import javax.swing.*;
import java.awt.*;

public class PieChartPanel extends JPanel {
    private int correct,incorrect;

    public PieChartPanel(int correct, int incorrect) {
        this.correct = correct;
        this.incorrect = incorrect;
        setPreferredSize(new Dimension(250, 250)); // Feste Größe für das Diagramm
    }

    public void setCorrectIncorrect(int correct, int incorrect) {
        this.correct = correct;
        this.incorrect = incorrect;
        repaint(); // Neuzeichnen anfordern
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int total = this.correct + this.incorrect;

        if (total == 0) return; // Vermeidet Division durch 0

        int startAngle = 0;
        int correctAngle = (int) Math.round(360.0 * correct / total);
        int incorrectAngle = 360 - correctAngle;

        // Kreis zeichnen
        g.setColor(Color.GREEN);
        g.fillArc(10, 10, 200, 200, startAngle, correctAngle);
        g.setColor(Color.RED);
        g.fillArc(10, 10, 200, 200, startAngle + correctAngle, incorrectAngle);
    }
}