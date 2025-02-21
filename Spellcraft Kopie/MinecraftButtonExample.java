import javax.swing.*;
import java.awt.*;

public class MinecraftButtonExample extends JFrame {

    public MinecraftButtonExample() {
        // Set upa JFrame
        setTitle("Minecraft Button Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Using null layout for custom positioning

        // Create a button
        JButton button = new JButton("Singleplayer") {
            @Override
            protected void paintComponent(Graphics g) {
                // Set up custom button appearance
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background rectangle (gray with Minecraft style)
                g2.setColor(new Color(140, 140, 140)); // Adjust color to match Minecraft button
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Button border
                g2.setColor(Color.BLACK);
                g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

                // Text in the button
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 14)); // Use Minecraft-like font style
                FontMetrics fm = g2.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent()) / 2 - 2;
                g2.drawString(getText(), x, y);
            }
        };

        // Set button properties
        button.setBounds(50, 40, 200, 40); // Position and size similar to Minecraft button
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        // Add button to the frame
        add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MinecraftButtonExample frame = new MinecraftButtonExample();
            frame.setVisible(true);
        });
    }
}