package VIEW;

import MODEL.Statistics;
import VIEW.MORE.BackgroundPanel;
import VIEW.MORE.Button;
import CONTROLLER.HauptController;

import javax.swing.*;
import java.awt.*;

public class StatisticsView extends JFrameE {
    private JButton backButton;

    private PieChartPanel chartPanel;

    private JLabel correctLabel,incorrectLabel;

    private int richtig=0;
    private int falsch=0;

    public StatisticsView(HauptController controller) {

        setTitle("Statistiken");
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        // Hintergrundbild setzen
        BackgroundPanel backgroundPanel = new BackgroundPanel("Spellcraft/Bilder/stat.jpg");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Statistiken anzeigen
        correctLabel = new JLabel("Richtige Antworten: " + richtig);
        correctLabel.setForeground(Color.WHITE);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 35));
        correctLabel.setBounds(50, 20, 400, 200);

        incorrectLabel = new JLabel("Falsche Antworten: " + falsch);
        incorrectLabel.setForeground(Color.WHITE);
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 35));
        incorrectLabel.setBounds(50, 60, 400, 200);

        backgroundPanel.add(correctLabel);
        backgroundPanel.add(incorrectLabel);

        // Diagramm
        this.chartPanel = new PieChartPanel(richtig,falsch);
        chartPanel.setBounds(120, 200, 225, 225);
        backgroundPanel.add(chartPanel);

        // Zurück-Button unten links
        Button buttonFactory = new Button();
        backButton = buttonFactory.createButton("Zurücksetzen");
        backButton.setBounds(5, 587, 500, 50);
        backButton.setActionCommand("Reset");
        backButton.addActionListener(controller);
        backgroundPanel.add(backButton);

        backButton = buttonFactory.createButton("Zurück");
        backButton.setBounds(5, 650, 500, 50);
        backButton.setActionCommand("BackH");
        backButton.addActionListener(controller);
        backgroundPanel.add(backButton);


        setVisible(false);
    }

    public void updateInt(int richtig, int falsch){
        this.richtig=richtig;
        this.falsch=falsch;
        correctLabel.setText("Richtige Antworten: " + richtig);
        incorrectLabel.setText("Falsch Antworten: " + falsch);
        this.chartPanel.setCorrectIncorrect(richtig,falsch);
    }

    public void updateTextAnswer() {}

    public JTextField[] getTextfield() { return null; }
}
