package VIEW.MORE;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        setForeground(Color.LIGHT_GRAY); // Textfarbe

        // Benutzerdefinierte Schriftart laden
        try {
            String fontPath = "Spellcraft/Font/Minecraft-Regular.otf"; // Pfad zur Schriftart
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(18f);
            setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            setFont(new Font("Arial", Font.BOLD, 18)); // Fallback-Schriftart
        }
    }

    public static void main(String[] args) {
        CustomLabel Label= new CustomLabel("Hallo");
    }
}

