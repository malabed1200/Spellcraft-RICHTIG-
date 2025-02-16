package VIEW;

import MODEL.Statistics;

import javax.swing.*;
import java.awt.*;

public class PieChartPanel extends JPanel {
    private Statistics statistics;

    public PieChartPanel(Statistics statistics) {
        this.statistics = statistics;
        setPreferredSize(new Dimension(250, 250)); // Feste Größe für das Diagramm
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int correct = statistics.getCorrect();
        int incorrect = statistics.getIncorrect();
        int total = correct + incorrect;

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