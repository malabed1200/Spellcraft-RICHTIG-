    package VIEW.MORE;

    import javax.swing.*;
    import java.awt.*;

    public class BackgroundPanel extends JPanel {
        private final Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Hintergrundbild auf die gesamte Fenstergröße skalieren
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }