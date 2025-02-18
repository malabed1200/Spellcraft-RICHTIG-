package VIEW;

import MODEL.Statistics;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;

import javax.swing.*;
import java.awt.*;

public class StatisticsView extends JFrame {
    private Statistics statistics;

    public StatisticsView(Statistics statistics) {
        this.statistics = statistics;

        setTitle("Statistiken");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/Background_Dirt.png");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Statistiken anzeigen (Links)
        JLabel correctLabel = new JLabel("Richtige Antworten: " + statistics.getCorrect());
        correctLabel.setForeground(Color.WHITE);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 20));
        correctLabel.setBounds(50, 50, 300, 30);

        JLabel incorrectLabel = new JLabel("Falsche Antworten: " + statistics.getIncorrect());
        incorrectLabel.setForeground(Color.WHITE);
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 20));
        incorrectLabel.setBounds(50, 100, 300, 30);

        backgroundPanel.add(correctLabel);
        backgroundPanel.add(incorrectLabel);

        // Diagramm (Rechts)
        JPanel chartPanel = new PieChartPanel(statistics);
        chartPanel.setBounds(450, 100, 250, 250); // Position und Größe des Diagramms
        backgroundPanel.add(chartPanel);

        // Zurück-Button unten links
        Button buttonFactory = new Button();
        JButton backButton = buttonFactory.createButton("Zurück");
        backButton.setBounds(50, 500, 120, 40);
        backButton.addActionListener(e -> {
            dispose();
            //new MainMenu(statistics); // Korrigierter Aufruf mit statistics-Parameter
        });

        backgroundPanel.add(backButton);

        setVisible(true);
    }
}