package VIEW.MORE;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomTextField extends JTextField {
    private final String placeholder;

    public CustomTextField(String placeholder) {
        super();
        this.placeholder = placeholder;

        setForeground(Color.WHITE); // Normale Textfarbe
        setBackground(Color.BLACK); // Hintergrundfarbe
        setCaretColor(Color.WHITE); // Cursorfarbe
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2)); // Randfarbe

        // Benutzerdefinierte Schriftart laden
        try {
            String fontPath = "Spellcraft/Font/Minecraft-Regular.otf";
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(18f);
            setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            setFont(new Font("Arial", Font.PLAIN, 18)); // Fallback-Schriftart
        }

        setUI(new CustomTextFieldUI());
    }

    private class CustomTextFieldUI extends BasicTextFieldUI {
        @Override
        protected void paintSafely(Graphics g) {
            super.paintSafely(g);
            if (getText().isEmpty()) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.GRAY); // Placeholder-Farbe
                g2.setFont(getFont().deriveFont(Font.PLAIN));
                g2.drawString(placeholder, getInsets().left, getHeight() / 2 + getFont().getSize() / 2 - 3);
            }
        }
    }

    // TEST Methode
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom TextField Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // CustomTextField hinzufügen
        CustomTextField textField = new CustomTextField("Suche oder Webadresse eingeben");
        frame.add(textField, BorderLayout.CENTER);

        // Frame sichtbar machen
        frame.setVisible(true);
    }
}