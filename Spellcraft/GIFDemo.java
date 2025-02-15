import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GIFDemo {
    public static void main(String[] args) {
        // Erstelle das Fenster (JFrame)
        JFrame frame = new JFrame("GIF in GUI");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Damit das Bild sich anpasst

        // Lade das GIF-Bild
        ImageIcon gifIcon = new ImageIcon("C:\\Users\\amira\\Downloads\\Spellcraft-RICHTIG-\\Spellcraft\\Bilder\\R.gif");

        // Erstelle ein JLabel mit dem GIF
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        gifLabel.setVerticalAlignment(JLabel.CENTER);

        // Füge das GIF zum Fenster hinzu
        frame.add(gifLabel, BorderLayout.CENTER);

        // Listener, um die Bildgröße bei Fensteränderung zu aktualisieren
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = frame.getWidth();
                int height = frame.getHeight();

                // Skaliere das GIF auf die neue Größe
                Image scaledImage = gifIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
                gifLabel.setIcon(new ImageIcon(scaledImage));
            }
        });

        frame.setVisible(true);
    }
}
